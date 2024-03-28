/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.CheckListDAO;
import dao.LoginDAO;
import dao.MachineDAO;
import dao.TicketDAO;
import entity.Account;
import entity.CategoryChecklist;
import entity.History;
import entity.Machine;
import entity.Schedule;
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
        LocalDate localdate = java.time.LocalDate.now();
        Account a = (Account) session.getAttribute("account");
        Account account = loginDAO.getAccountDepartment(a);
        ArrayList<Machine> list;
        ArrayList<Machine> listAll;
        ArrayList<Account> listA;
        ArrayList<Ticket> tickets;
        ArrayList<Ticket> undone;
        ArrayList<Ticket> staffTickets;
        ArrayList<Ticket> tasks;
        CheckListDAO listDAO = new CheckListDAO();
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
                ticketDAO.updateStatus(status, tickid, localdate);
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
                ticketDAO.updateStatus(status, tickid, localdate);
                target = "Implementor.jsp";
            }
            case "staffViewTicket" -> {
                staffTickets = ticketDAO.viewTicketByDepartment(a.getAccountID());
                session.setAttribute("listT", staffTickets);
                target = "StaffViewTicket.jsp";
            }
            case "viewTicket" -> {
                undone = ticketDAO.getUndone(a.getAccountID());
                request.setAttribute("u", undone.size());
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
                Ticket ticket = new Ticket(id, staffName, date, "", department, location, description, "");

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
                String remark_1 = request.getParameter("remark1");
                String remark_2 = request.getParameter("remark2");
                String remark_3 = request.getParameter("remark3");
                String remark_4 = request.getParameter("remark4");
                String remark_5 = request.getParameter("remark5");
                String remark_6 = request.getParameter("remark6");
                String remark_7 = request.getParameter("remark7");
                String category = request.getParameter("category");
                List<Machine> listCa;

                Machine machine = new Machine(name, assetNo, department, location, checklist_1, checklist_2, checklist_3, checklist_4, checklist_5, checklist_6, checklist_7, remark_1, remark_2, remark_3, remark_4, remark_5, remark_6, remark_7, category);
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
                String remark_1 = request.getParameter("remark1");
                String remark_2 = request.getParameter("remark2");
                String remark_3 = request.getParameter("remark3");
                String remark_4 = request.getParameter("remark4");
                String remark_5 = request.getParameter("remark5");
                String remark_6 = request.getParameter("remark6");
                String remark_7 = request.getParameter("remark7");
                String category = request.getParameter("category");
                List<Machine> listCa;

                Machine machine = new Machine(name, assetNo, department, location, checklist_1, checklist_2, checklist_3, checklist_4, checklist_5, checklist_6, checklist_7, remark_1, remark_2, remark_3, remark_4, remark_5, remark_6, remark_7, category);
                machineDAO.addMachine(machine);
                listCa = machineDAO.getAllCategory();
                request.setAttribute("message", "Add Successful!");
                request.setAttribute("listC", listCa);
                target = "ManageControl?mode=viewByDepartment";

            }
            case "editTicket" -> {
                String id = request.getParameter("id");
                Ticket t = ticketDAO.getTicket(id);
                request.setAttribute("t", t);
                target = "EditTicket.jsp";
            }
            case "deleteTicket" -> {
                String id = request.getParameter("id");
                ticketDAO.deleteTicket(id);
                request.setAttribute("deleteSuccess", "Deleted Successful!");

                target = "ManageControl?mode=staffViewTicket";
            }
            case "addRemark" -> {
                String remark = request.getParameter("remark");
                String id = request.getParameter("ticketID");
                ticketDAO.addTicketRemark(remark, id);

                target = "Implementor.jsp";
            }
            case "editingTicket" -> {
                String id = request.getParameter("id");
                String staffID = request.getParameter("staffID");
                String date = request.getParameter("dateTicket");
                String maintain = request.getParameter("maintain");
                String status = request.getParameter("status");
                String description = request.getParameter("description");
                Ticket ticket = new Ticket(id, staffID, date, "", maintain, status, description, "");
                ticketDAO.editTicket(ticket);
                request.setAttribute("editSuccess", "Edited Successful!");

                target = "ManageControl?mode=staffViewTicket";
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
                String remark_1 = request.getParameter("remark1");
                String remark_2 = request.getParameter("remark2");
                String remark_3 = request.getParameter("remark3");
                String remark_4 = request.getParameter("remark4");
                String remark_5 = request.getParameter("remark5");
                String remark_6 = request.getParameter("remark6");
                String remark_7 = request.getParameter("remark7");
                String edit_category = request.getParameter("category");

                Machine machine = new Machine(edit_name, edit_assetNo, edit_department, edit_location, edit_checklist_1, checklist_2, checklist_3, checklist_4, checklist_5, checklist_6, checklist_7, remark_1, remark_2, remark_3, remark_4, remark_5, remark_6, remark_7, edit_category);
                machineDAO.editMachine(machine);
                request.setAttribute("editSuccess", "Edited Successful!");

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
            case "view" -> {
                ArrayList<History> listR = listDAO.getRecentHistory();
                ArrayList<Ticket> ticket = ticketDAO.getTotalUndone();
                ArrayList<History> list1m = listDAO.get1monthRevenue();
                ArrayList<History> list2m = listDAO.get2monthRevenue();
                ArrayList<History> list3m = listDAO.get3monthRevenue();
                request.setAttribute("month1", list1m);
                request.setAttribute("month2", list2m);
                request.setAttribute("month3", list3m);
                request.setAttribute("tick", ticket);
                request.setAttribute("listR", listR);
                list = machineDAO.get1stPageMachine();
                request.setAttribute("machine", list);
                target = "Manage.jsp";
            }
            case "viewByDepartment" -> {
                undone = ticketDAO.getUndone(a.getAccountID());
                request.setAttribute("u", undone.size());
                ArrayList<Machine> listD = machineDAO.getMachineByDepartment(a.getDepartment());
                request.setAttribute("listD", listD);
                request.setAttribute("date", localdate);
                target = "StaffManage.jsp";
            }
            case "StaffViewCheckList" -> {
                String text1 = request.getParameter("id");
                String text = request.getParameter("assetNo");
                History his = listDAO.getHistoryByID(text1);
                Machine machine3 = machineDAO.getMachineByAssetNo(text);
                Machine machine1 = machineDAO.getMachineByID(text1);
                CategoryChecklist machine2 = machineDAO.getChecklistByCategory(machine3.getCategory());
                request.setAttribute("his", his);
                request.setAttribute("machine3", machine3);
                request.setAttribute("categoryChecklist", machine2);
                LocalDate date = java.time.LocalDate.now();
                String[] remark = new String[7];
                account = (Account) session.getAttribute("account");
                String[] checkboxs = request.getParameterValues("checkedbox");
                String[] checked = new String[7];
                for (int i = 0; i < checked.length; i++) {
                    checked[i] = "";
                }

                try {
                    Schedule machine = machineDAO.getMachine3ByAssetNo(text);
                    if (checkboxs != null) {
                        for (String checkbox : checkboxs) {
                            for (int i = 0; i < checked.length; i++) {
                                if (checkbox.matches("check" + (i + 1) + "[WMQBAD]")) {
                                    checked[i] += checkbox.charAt(checkbox.length() - 1);
                                }
                                if (checkbox.matches("checkedAll")) {
                                    listDAO.isChecked3(text, "checklist_" + (i + 1), checked[i]);
                                    listDAO.isChecked(text, "checklist_" + (i + 1), checked[i]);
                                }
                            }
                        }
                        for (int i = 0; i < checked.length; i++) {
                            listDAO.isChecked3(text, "checklist_" + (i + 1), checked[i]);
                            listDAO.isChecked(text, "checklist_" + (i + 1), checked[i]);
//                            listDAO.updateByCategory(machine.getCategory(), "checklist_" + (i + 1), checked[i]);
                        }
                        for (int i = 0; i < remark.length; i++) {
                            remark[i] = request.getParameter("remark" + (i + 1));
                            if (remark[i] != null) {
                                listDAO.updateRemark3(text, "remark_" + (i + 1), remark[i]);
                            }
                        }
                        listDAO.insertSchedule3(machine.getName(), text, date, account.getAccountID(), checked[0],
                                checked[1], checked[2], checked[3], checked[4],
                                checked[5], checked[6], remark[0], remark[1], remark[2], remark[3],
                                remark[4], remark[5], remark[6]);
                        listDAO.insertHistory(machine.getName(), text, date, account.getAccountID(), checked[0],
                                checked[1], checked[2], checked[3], checked[4],
                                checked[5], checked[6], remark[0], remark[1], remark[2], remark[3],
                                remark[4], remark[5], remark[6]);
                        for (int i = 0; i < checked.length; i++) {
                            checked[i] = "";
                        }
                    }
                    request.setAttribute("machine", machine);
                } catch (NullPointerException e) {
                    System.out.println(e);
                }
                target = "ViewCheckList.jsp";
            }
            case "ViewAssetChecklist" -> {
                String text = request.getParameter("assetNo");
                Machine machine3 = machineDAO.getMachineByAssetNo(text);
                CategoryChecklist machine1 = machineDAO.getChecklistByCategory(machine3.getCategory());
                request.setAttribute("machine3", machine3);
                request.setAttribute("machine1", machine1);

                target = "AssetChecklist.jsp";
            }
            case "StaffViewSchedule" -> {
                String text1 = request.getParameter("id");
                Machine machine = machineDAO.getMachineByID(text1);
                request.setAttribute("machine", machine);
                target = "ViewSchedule.jsp";
            }
            case "search" -> {
                String search = request.getParameter("text");
                list = machineDAO.searchByName(search);
                request.setAttribute("value", search);
                request.setAttribute("listM", list);
                request.setAttribute("searched", "Not null");

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
            case "allMachines" -> {

                listAll = machineDAO.getAllMachine();
                request.setAttribute("listAll", listAll);
                String text = request.getParameter("assetNo");
                Machine machine3 = machineDAO.getMachineByAssetNo(text);
                list = machineDAO.searchByName(text);
                request.setAttribute("listM", list);
                request.setAttribute("machine3", machine3);
                target = "AllMachine.jsp";
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
