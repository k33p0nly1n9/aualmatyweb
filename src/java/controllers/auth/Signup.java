/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.auth;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import models.*;

/**
 *
 * @author bayan
 */
public class Signup extends HttpServlet {

    private static final String SIGNUP_JSP = "/WEB-INF/auth/signup.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        getServletContext().getRequestDispatcher(SIGNUP_JSP)
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
        String name = request.getParameter("personName");
        String lastName = request.getParameter("personLast");

        String passwd = request.getParameter("passwd");
        String confirm = request.getParameter("confirm");

        String path = "C:\\Users\\bayan\\OneDrive\\Документы\\NetBeansProjects\\Test\\web\\Content";

        String fileName = "";
        Part filePart = null;
        if (request.getPart("signupphoto") != null) {
            filePart = request.getPart("signupphoto");
            fileName = DataUtils.generateRandomString(15) + ".jpg";
        }

        Long birthday = 0L;
        try {
            String b = request.getParameter("birthday");
            birthday = DataUtils.convertDataToLongWithRawString(b);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String numb = request.getParameter("number");

        if (!(passwd.equals(confirm))) {
            request.setAttribute("signuperror", "Пароли не совпадают");
            getServletContext().getRequestDispatcher(SIGNUP_JSP)
                    .forward(request, response);
        }
        else {

            DbHelper db = new DbHelper();
            Person p = db.getPersonByNumb(numb);
            if (p != null) {
                request.setAttribute("signuperror", "Пользователь с таким номером уже зарегистрирован");
                getServletContext().getRequestDispatcher(SIGNUP_JSP)
                        .forward(request, response);
            }
            else {

                Person person = new Person(name, lastName, passwd, numb, 0);

                if (request.getParameter("birthday") != null) {
                    person.setBirthday(birthday);
                }

                try {

                    if (filePart != null) {
                        DataUtils.savePhoto(filePart, path, fileName);
                        person.setPhoto(fileName);
                    }

                    db.addPerson(person);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                response.sendRedirect("Login");
            }
        }
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
