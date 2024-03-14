/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import configPkg.ConfigInfo;
import dao.LoginDAO;
import dao.TicketDAO;
import entity.Account;
import entity.Ticket;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Admin
 */
//@WebServlet(name = "LoginControl", urlPatterns = {"/LoginControl"})
//@MultipartConfig(
//        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
//        maxFileSize = 1024 * 1024 * 10, // 10 MB
//        maxRequestSize = 1024 * 1024 * 100 // 100 MB
//)
public class LoginControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String target = "Login.jsp";
        String mode = request.getParameter("mode");
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");
        ArrayList<Ticket> undone;
        TicketDAO ticketDAO = new TicketDAO();

        LoginDAO loginDAO = new LoginDAO();

        switch (mode) {
            case "enableUser" -> {
                String accountID = request.getParameter("accountID");
                loginDAO.enableUser(accountID);
                target = "Users.jsp";
            }
            case "disableUser" -> {
                String accountID = request.getParameter("accountID");
                loginDAO.disableUser(accountID);
                request.setAttribute("messageDis", "Disable User Successful!");

                target = "Users.jsp";
            }
            case "edit" -> {
                String accountID = request.getParameter("accountID");
                Account acc = loginDAO.getAccountByID(accountID);
                request.setAttribute("acc", acc);
                target = "EditUser.jsp";
            }
            case "resetPassword" -> {
                String accountID = request.getParameter("accountID");
                loginDAO.resetPassword(accountID);
                request.setAttribute("messagePass", "Password Changed Successful to '123'");

                target = "Users.jsp";
            }
            case "addUser" -> {
                String userName = request.getParameter("username");
                String password = request.getParameter("password");
                String department = request.getParameter("department");
                String accountID = request.getParameter("accountID");

                loginDAO.addUser(userName, password, department, accountID);
                request.setAttribute("message", "Add Successful!");
                target = "Users.jsp";
            }
            case "login" -> {

                String username = request.getParameter("username");
                String password = request.getParameter("password");
                a = loginDAO.login(username, password);
                if (a == null || a.getIsActive() == 0) {
                    request.setAttribute("mess", "Wrong Username or Password");
                } else {
                    session.setAttribute("account", a);
                    undone = ticketDAO.getUndone(a.getAccountID());
                    request.setAttribute("u", undone.size());
                    if (a.getIsAdmin() == 1) {
                        target = "ManageControl?mode=view";
                    } else {
                        target = "ManageControl?mode=viewByDepartment";
                    }
                }
            }
            case "loginStaff" -> {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                a = loginDAO.login(username, password);
                if (a == null || a.getIsActive() == 0) {
                    request.setAttribute("mess", "Wrong Username or Password");
                } else {
                    session.setAttribute("account", a);
                    target = "ManageControl";
                }
            }
            case "signOut" -> {
                session.removeAttribute("account");
                target = "HomePage.jsp";
            }
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(target);
        requestDispatcher.forward(request, response);

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
        processRequest(request, response);
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
        processRequest(request, response);
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
