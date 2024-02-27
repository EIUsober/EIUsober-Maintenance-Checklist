/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.LoginDAO;
import dao.MachineDAO;
import dao.TicketDAO;
import entity.Account;
import entity.CategoryChecklist;
import entity.Machine;
import entity.Ticket;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.DateFormatter;

/**
 *
 * @author Admin
 */
public class ManageControl extends HttpServlet {

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
        String target = "Manage.jsp";
        String mode = request.getParameter("mode");
        String ticketID = "";

        MachineDAO machineDAO = new MachineDAO();
        LoginDAO loginDAO = new LoginDAO();
        HttpSession session = request.getSession();
        LocalDateTime localdate = java.time.LocalDateTime.now();
        Account a = (Account) session.getAttribute("account");
        Account account = loginDAO.getAccountDepartment(a);
        ArrayList<Machine> list;
        ArrayList<Account> listA;
        ArrayList<Ticket> tickets;
        ArrayList<Ticket> tasks;
        TicketDAO ticketDAO = new TicketDAO();
        tickets = ticketDAO.getAllTicket();
        list = machineDAO.getAllMachine();
        int count = list.size();
        int pageSize = 10;
        int endPage = 0;
        endPage = count / pageSize;
        if (count % pageSize != 0) {
            endPage++;
        }

        request.setAttribute("endPage", endPage);

        switch (mode) {
            case "getAccounts" -> {
                listA = ticketDAO.getAllAccount();
                request.setAttribute("acc", listA);
                target = "Users.jsp";
            }
            case "updateExecute" -> {
                String tickid = request.getParameter("id");
                String staffID = request.getParameter("staffID");
                ticketDAO.updateExecute(staffID, tickid);
                target = "ViewTicket.jsp";
            }
            case "updateStatus" -> {
                String tickid = request.getParameter("id");
                String status = request.getParameter("status");
                ticketDAO.updateStatus(status, tickid);
                target = "Implementor.jsp";
            }
            case "viewTask" -> {
                tasks = ticketDAO.getTicketByStaff(a.getAccountID());
                session.setAttribute("listT", tasks);

                target = "Implementor.jsp";
            }
            case "viewImplementor" -> {
                session.setAttribute("listT", tickets);
                String tickid = request.getParameter("id");
                String status = request.getParameter("status");
                ticketDAO.updateStatus(status, tickid);
                target = "Implementor.jsp";
            }
            case "viewTicket" -> {
                session.setAttribute("listT", tickets);
                target = "ViewTicket.jsp";
            }
            case "addTicket" -> {
                String id = request.getParameter("id");
                String staffName = request.getParameter("staffName");
                String date = request.getParameter("dateTicket");
                String department = request.getParameter("departmentTicket");
                String location = request.getParameter("locationTicket");
                String description = request.getParameter("descriptionTicket");
                Ticket ticket = new Ticket(id, staffName, date, department, location, description);

                ticketDAO.addTicket(ticket);
                request.setAttribute("ticketMessage", "Add Successful!");
                target = "ManageControl?mode=viewByDepartment";
            }
            case "paging" -> {
                for (int i = 0; i < endPage; i++) {
                    list = machineDAO.getNextPageMachine(i);
                }
                request.setAttribute("machine", list);
                target = "Manage.jsp";
            }
            case "view" -> {
                list = machineDAO.get1stPageMachine();
                request.setAttribute("machine", list);
                target = "Manage.jsp";
            }
            case "add" -> {
                String name = request.getParameter("name");
                String assetNo = request.getParameter("assetNo");
                String department = request.getParameter("department");
                String location = request.getParameter("location");
                String checklist_1 = request.getParameter("checklist_1");
                String checklist_2 = request.getParameter("checklist_2");
                String checklist_3 = request.getParameter("checklist_3");
                String checklist_4 = request.getParameter("checklist_4");
                String checklist_5 = request.getParameter("checklist_5");
                String checklist_6 = request.getParameter("checklist_6");
                String checklist_7 = request.getParameter("checklist_7");
                String checklist_8 = request.getParameter("checklist_8");
                String remark_1 = request.getParameter("remark1");
                String remark_2 = request.getParameter("remark2");
                String remark_3 = request.getParameter("remark3");
                String remark_4 = request.getParameter("remark4");
                String remark_5 = request.getParameter("remark5");
                String remark_6 = request.getParameter("remark6");
                String remark_7 = request.getParameter("remark7");
                String category = request.getParameter("category");
                List<Machine> listCa;

                Machine machine = new Machine(name, assetNo, department, location, checklist_1, checklist_2, checklist_3, checklist_4, checklist_5, checklist_6, checklist_7, checklist_8, remark_1, remark_2, remark_3, remark_4, remark_5, remark_6, remark_7, category);
                machineDAO.addMachine(machine);
                listCa = machineDAO.getAllCategory();
                request.setAttribute("message", "Add Successful!");
                request.setAttribute("listC", listCa);
                target = "ManageControl?mode=view";

            }
            case "addByStaff" -> {
                String name = request.getParameter("name");
                String assetNo = request.getParameter("assetNo");
                String department = request.getParameter("department");
                String location = request.getParameter("location");
                String checklist_1 = request.getParameter("checklist_1");
                String checklist_2 = request.getParameter("checklist_2");
                String checklist_3 = request.getParameter("checklist_3");
                String checklist_4 = request.getParameter("checklist_4");
                String checklist_5 = request.getParameter("checklist_5");
                String checklist_6 = request.getParameter("checklist_6");
                String checklist_7 = request.getParameter("checklist_7");
                String checklist_8 = request.getParameter("checklist_8");
                String remark_1 = request.getParameter("remark1");
                String remark_2 = request.getParameter("remark2");
                String remark_3 = request.getParameter("remark3");
                String remark_4 = request.getParameter("remark4");
                String remark_5 = request.getParameter("remark5");
                String remark_6 = request.getParameter("remark6");
                String remark_7 = request.getParameter("remark7");
                String category = request.getParameter("category");
                List<Machine> listCa;

                Machine machine = new Machine(name, assetNo, department, location, checklist_1, checklist_2, checklist_3, checklist_4, checklist_5, checklist_6, checklist_7, checklist_8, remark_1, remark_2, remark_3, remark_4, remark_5, remark_6, remark_7, category);
                machineDAO.addMachine(machine);
                listCa = machineDAO.getAllCategory();
                request.setAttribute("message", "Add Successful!");
                request.setAttribute("listC", listCa);
                target = "ManageControl?mode=viewByDepartment";

            }
            case "edit" -> {
                String assetNo = request.getParameter("assetNo");
                Machine machine = machineDAO.getMachineByAssetNo(assetNo);
                request.setAttribute("machine", machine);
                target = "Edit.jsp";
            }
            case "editing" -> {
                String edit_name = request.getParameter("name");
                String edit_assetNo = request.getParameter("assetNo");
                String edit_department = request.getParameter("department");
                String edit_location = request.getParameter("location");
                String edit_checklist_1 = request.getParameter("checklist_1");
                String checklist_2 = request.getParameter("checklist_2");
                String checklist_3 = request.getParameter("checklist_3");
                String checklist_4 = request.getParameter("checklist_4");
                String checklist_5 = request.getParameter("checklist_5");
                String checklist_6 = request.getParameter("checklist_6");
                String checklist_7 = request.getParameter("checklist_7");
                String checklist_8 = request.getParameter("checklist_8");
                String remark_1 = request.getParameter("remark1");
                String remark_2 = request.getParameter("remark2");
                String remark_3 = request.getParameter("remark3");
                String remark_4 = request.getParameter("remark4");
                String remark_5 = request.getParameter("remark5");
                String remark_6 = request.getParameter("remark6");
                String remark_7 = request.getParameter("remark7");
                String category = request.getParameter("category");

                Machine machine = new Machine(edit_name, edit_assetNo, edit_department, edit_location, edit_checklist_1, checklist_2, checklist_3, checklist_4, checklist_5, checklist_6, checklist_7, checklist_8, remark_1, remark_2, remark_3, remark_4, remark_5, remark_6, remark_7, category);
                machineDAO.editMachine(machine);
                target = "ManageControl?mode=view";
            }
            case "delete" -> {
                String assetNo = request.getParameter("assetNo");
                Machine machines = machineDAO.getMachineByAssetNo(assetNo);
                machineDAO.deleteMachine(assetNo);
                request.setAttribute("machines", machines);
                request.setAttribute("message2", "Delete Successful!");
                target = "ManageControl?mode=view";
            }
            case "viewByDepartment" -> {
                ArrayList<Machine> listD = machineDAO.getMachineByDepartment(a.getDepartment());
                request.setAttribute("listD", listD);
                target = "StaffManage.jsp";
            }
            case "StaffViewCheckList" -> {
                String text1 = request.getParameter("assetNo");
                Machine machine = machineDAO.getMachineByAssetNo(text1);
                request.setAttribute("machine", machine);
                target = "ViewCheckList.jsp";
            }
            case "StaffViewSchedule" -> {
                String text1 = request.getParameter("assetNo");
                Machine machine = machineDAO.getMachineByAssetNo(text1);
                request.setAttribute("machine", machine);
                target = "ViewSchedule.jsp";
            }
            case "search" -> {
                String search = request.getParameter("text");
                list = machineDAO.searchByName(search);
                request.setAttribute("value", search);
                request.setAttribute("listM", list);
                target = "Manage.jsp";
            }
            case "searchStaff" -> {
                String search = request.getParameter("text");
                list = machineDAO.searchByStaff(search, a.getDepartment());
                request.setAttribute("value", search);
                request.setAttribute("list", list);
                target = "StaffManage.jsp";
            }
            case "schedule" -> {
                target = "Schedule.jsp";
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
