/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ContactDAO;
import DAO.GalleryDAO;
import DAO.ImageDAO;
import Model.ContactModel;
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
@WebServlet(name = "HomeCotroller", urlPatterns = {"/home"})
public class HomeCotroller extends HttpServlet {

    GalleryDAO galleryDAO = new GalleryDAO();
    ImageDAO imageDAO = new ImageDAO();
    ContactDAO contactDAO = new ContactDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            ContactModel contactModel = contactDAO.findContactModel();
            List<GalleryModel> galleryModels = galleryDAO.findTop3Gallery();
            if (!galleryModels.isEmpty()) {
                request.setAttribute("galleryHeader", galleryModels);
            }
            if (contactModel != null) {
                request.setAttribute("contact", contactModel);
            }

            int index = 1;
            if (request.getParameterMap().containsKey("index")) {
                try {
                    index = Integer.parseInt(request.getParameter("index"));
                } catch (NumberFormatException ex) {
                    index = 1;
                }
            }
            int maxPage = 3;
            int totalItem = galleryDAO.countAllGallery();
            PageRequest page = new PageRequest(index, maxPage);
            int totalPage = (int) Math.ceil((double) totalItem / maxPage);
            if (totalPage > 0) {
                if (index > totalPage) {
                    response.sendRedirect("home");
                    return;
                }
            }
            List<GalleryModel> list = galleryDAO.getlistGallery(page);
            request.setAttribute("list", list);
            for (GalleryModel galleryModel : list) {
                ImageModel imageModel = imageDAO.findRandomImageByIdGallery(galleryModel.getId());
                if (imageModel != null) {
                    galleryModel.setUrl(imageModel.getUrl());
                }
            }
            request.setAttribute("index", index);
            request.setAttribute("totalPage", totalPage);
            request.setAttribute("activeHome", true);
            RequestDispatcher rd = request.getRequestDispatcher("view/home.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
        }
    }

}
