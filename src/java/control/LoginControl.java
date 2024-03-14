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

//@WebServlet(name = "LoginControl", urlPatterns = {"/LoginControl"})
//@MultipartConfig(
//        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
//        maxFileSize = 1024 * 1024 * 10, // 10 MB
//        maxRequestSize = 1024 * 1024 * 100 // 100 MB
//)
public class LoginControl extends HttpServlet {
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
