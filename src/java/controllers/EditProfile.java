/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import models.*;

/**
 *
 * @author bayan
 */
@MultipartConfig
public class EditProfile extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /* protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
   
           
        }
    } */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Person person = models.Account.getCurrentPerson(request);

        if (person == null) {
            response.sendRedirect("Login");
            return;
        }

        getServletContext().getRequestDispatcher("/WEB-INF/controllers/myprofile/editProfile.jsp")
                .forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Person person = models.Account.getCurrentPerson(request);

        if (person == null) {
            response.sendRedirect("Login");
            return;
        }

        String path = "C:\\Users\\bayan\\OneDrive\\Документы\\NetBeansProjects\\Test\\web\\Content"; //getServletContext().getRealPath("/Content");

        // Part filePart = request.getPart("file");
        if (request.getPart("editfile") != null) {
            Part filePart = request.getPart("editfile");
            String fileName = DataUtils.generateRandomString(15) + ".jpg";

            try {
                DataUtils.deletePersonImage(person.getPhoto());
                DataUtils.savePhoto(filePart, path, fileName);
                person.setPhoto(fileName);

            } catch (Exception e) {
                e.printStackTrace();
            }

            DbHelper db = new DbHelper();
            db.updatePerson(person);
        }

        if (request.getParameterNames() != null) {
            if (request.getParameter("editName") != null) {

                String name = request.getParameter("editName");
                person.setName(name);

            }
            if (request.getParameter("editLastname") != null) {
                String lastname = request.getParameter("editLastname");
                person.setLastname(lastname);
            }

            if (request.getParameter("editBirthday") != null) {
                Long b = DataUtils.convertDataToLongWithRawString(request.getParameter("editBirthday"));
                person.setBirthday(b);
            }
            DbHelper db = new DbHelper();
            db.updatePerson(person);
                 request.setAttribute("settingssaved", "Изменения успешно сохранены");

        }

        response.sendRedirect("EditProfile");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
