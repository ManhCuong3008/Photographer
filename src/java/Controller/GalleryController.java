package Controller;

import DAO.GalleryDAO;
import DAO.ImageDAO;
import Model.GalleryModel;
import Model.ImageModel;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import paging.PageRequest;

/**
 *
 * @author NguyenManhCuong
 */
@WebServlet(name = "GalleryController", urlPatterns = {"/gallery"})
public class GalleryController extends HttpServlet {

    GalleryDAO galleryDAO = new GalleryDAO();
    ImageDAO imageDAO = new ImageDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Integer id = null;
            List<GalleryModel> galleryModels = galleryDAO.findTop3Gallery();
            if (!galleryModels.isEmpty()) {
                request.setAttribute("galleryHeader", galleryModels);
            }
            if (request.getParameterMap().containsKey("id")) {
                try {
                    id = Integer.parseInt(request.getParameter("id"));
                    request.setAttribute("id", id);
                } catch (Exception ex) {
                    id = null;
                }
            }
            Integer index = 1;
            if (request.getParameterMap().containsKey("index")) {
                try {
                    index = Integer.parseInt(request.getParameter("index"));
                } catch (Exception ex) {
                    index = 1;
                }
            }
            Integer view = null;
            if (request.getParameterMap().containsKey("view")) {
                try {
                    view = Integer.parseInt(request.getParameter("view"));
                } catch (Exception ex) {
                    view = null;
                }
            }
            if (id == null) {
                response.sendRedirect("home");
                return;
            }
            GalleryModel galleryModel = galleryDAO.findById(id);
            if (galleryModel == null) {
                response.sendRedirect("home");
                return;
            }
            int maxImageInPage = 8;
            int totalItem = imageDAO.countByIdGallery(id);
            PageRequest page = new PageRequest(index, maxImageInPage);
            int totalPage = (int) Math.ceil((double) totalItem / maxImageInPage);
            if (totalPage > 0) {
                if (index > totalPage) {
                    response.sendRedirect("gallery?id=" + id);
                    return;
                }
            }
            List<ImageModel> listImg = imageDAO.getImageOffSetByIdGallery(id, page);
            List<ImageModel> listAllImage = imageDAO.getImageByIdGallery(id);
            if (listAllImage == null || listImg == null) {
                request.setAttribute("error", "Can not found image");
            } else {
                galleryModel.setListImages(listAllImage);
                request.setAttribute("index", index);
                request.setAttribute("modelGallery", galleryModel);
                request.setAttribute("modelPaging", listImg);
                request.setAttribute("idGallerry", id);
                request.setAttribute("totalPage", totalPage);
                if (view != null) {
                    ImageModel modelView = new ImageModel();
                    boolean check = false;
                    Integer idBefore = null;
                    Integer idAfter = null;
                    for (int i = 0; i < listAllImage.size(); i++) {
                        if (view == listAllImage.get(i).getId()) {
                            modelView = listAllImage.get(i);
                            if (i > 0 && i < listAllImage.size() - 1) {
                                idBefore = listAllImage.get(i - 1).getId();
                                idAfter = listAllImage.get(i + 1).getId();
                            }
                            if (i == 0) {
                                idAfter = listAllImage.get(i + 1).getId();
                            }
                            if (i == listAllImage.size() - 1) {
                                idBefore = listAllImage.get(i - 1).getId();
                            }
                            check = true;
                            break;
                        }
                    }
                    if (check) {
                        request.setAttribute("viewImageModel", modelView);
                        request.setAttribute("idBefore", idBefore);
                        request.setAttribute("idAfter", idAfter);
                    } else {
                        response.sendRedirect("gallery?id=" + id);
                        return;
                    }
                }
            }
            RequestDispatcher rd = request.getRequestDispatcher("view/gallery.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
        }
    }
}
