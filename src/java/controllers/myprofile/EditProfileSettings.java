/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.myprofile;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.*;

/**
 *
 * @author bayan
 */
public class EditProfileSettings extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String EDITPROFILESETTINGS = "/WEB-INF/controllers/myprofile/editProfileSettings.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet editProfileSettings</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet editProfileSettings at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }

    }

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
        models.Person person = models.Account.getCurrentPerson(request);

        if (person == null) {
            response.sendRedirect("Login");
            return;
        }

        getServletContext().getRequestDispatcher(EDITPROFILESETTINGS)
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
        DbHelper db = new models.DbHelper();

        if (person == null) {
            response.sendRedirect("Login");
            return;
        }

        if (request.getParameterNames() != null) {

            if (request.getParameter("profilesetetNumb") != null) {
                String number = request.getParameter("profilesetetNumb");
                Person p = db.getPersonByNumb(number);
                if (p != null) {
                    request.setAttribute("settingserror", "Пользователь с таким номером уже зарегистрирован");
                    getServletContext().getRequestDispatcher(EDITPROFILESETTINGS)
                            .forward(request, response);
                }
                else {
                    person.setNumber(number);
                }
            }

            if (request.getParameter("profilesetetPasswd") != null) {

                String oldpasswd = request.getParameter("profilesetetoldpasswd").trim();
                if (!person.getPasswd().equals(oldpasswd)) {
                    request.setAttribute("settingserror", "Ошибочно указан старый пароль");
                    getServletContext().getRequestDispatcher(EDITPROFILESETTINGS)
                            .forward(request, response);
                }
                String passwd = request.getParameter("profilesetetPasswd");
                String confirm = request.getParameter("profilesetetPasswdconfirm");
                if (!(passwd.equals(confirm))) {
                    request.setAttribute("settingserror", "Пароли не совпадают");
                    getServletContext().getRequestDispatcher(EDITPROFILESETTINGS)
                            .forward(request, response);
                }else{
                    person.setPasswd(passwd);
                }
            }
            db.updatePerson(person);
             request.setAttribute("settingssaved", "Изменения успешно сохранены");
        }
         getServletContext().getRequestDispatcher(EDITPROFILESETTINGS)
                            .forward(request, response);
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
