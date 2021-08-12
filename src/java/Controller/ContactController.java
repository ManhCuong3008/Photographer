/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ContactDAO;
import DAO.GalleryDAO;
import Model.ContactModel;
import Model.GalleryModel;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author NguyenManhCuong
 */
@WebServlet(name = "ContactController", urlPatterns = {"/contact"})
public class ContactController extends HttpServlet {

    GalleryDAO galleryDAO = new GalleryDAO();
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
            request.setAttribute("activeContact", true);
            RequestDispatcher rd = request.getRequestDispatcher("view/contact.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
        }
    }

}
