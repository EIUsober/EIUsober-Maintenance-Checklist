package control;

import dao.CheckListDAO;
import dao.MachineDAO;
import entity.Account;
import entity.CategoryChecklist;
import entity.History;
import entity.Machine;
import entity.Sample;
import entity.Schedule;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class MainControl extends HttpServlet {

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
        String target = "HomePage.jsp";
        String mode = request.getParameter("mode");
        MachineDAO machineDAO = new MachineDAO();
        CheckListDAO listDAO = new CheckListDAO();
        HttpSession session = request.getSession();
        LocalDate date = java.time.LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
        String month = request.getParameter("month");
        Account account = (Account) session.getAttribute("account");

        switch (mode) {
            case "search" -> {
                String text1 = request.getParameter("search");
                Machine machine = machineDAO.getMachineByAssetNo(text1);
                CategoryChecklist machine1 = machineDAO.getChecklistByCategory(machine.getCategory());
                request.setAttribute("machine", machine);
                request.setAttribute("categoryChecklist", machine1);
                listDAO.insertSchedule3(machine.getName(), machine.getAssetNo(), date, account.getAccountID(), machine1.getChecklist_1(), machine1.getChecklist_2(),
                        machine1.getChecklist_3(), machine1.getChecklist_4(), machine1.getChecklist_5(), machine1.getChecklist_6(),
                        machine1.getChecklist_7(), machine1.getRemark_1(), machine1.getRemark_2(), machine1.getRemark_3(), machine1.getRemark_4(),
                        machine1.getRemark_5(), machine1.getRemark_6(), machine1.getRemark_7());
            }
            case "recentHistory" -> {
                ArrayList<History> listR = listDAO.getRecentHistory();
                request.setAttribute("listR", listR);

                target = "Manage.jsp";
            }
            case "history" -> {
                if (month == null) {
                    ArrayList<History> listAll = listDAO.getAllHistory();
                    request.setAttribute("listAll", listAll);
                } else {
                    ArrayList<History> list = listDAO.getHistoryByMonth(month);
                    request.setAttribute("listH", list);
                }
                target = "History.jsp";
            }
            case "updateScheduleStatus" -> {
                String id = request.getParameter("id");
                listDAO.updateScheduleStatus(id);

                target = "StaffViewSchedule.jsp";
            }
            case "viewScheduleByStaff" -> {
                account = (Account) session.getAttribute("account");
                ArrayList<Sample> listScheduleStaff = listDAO.getScheduleByStaff(account.getAccountID());
                request.setAttribute("listStaff", listScheduleStaff);
                target = "StaffViewSchedule.jsp";
            }
            case "viewSchedule3" -> {
                ArrayList<Schedule> listHis3 = listDAO.getSchedule3(month);
                request.setAttribute("listHis3", listHis3);
                target = "MainControl?mode=viewSchedule";
                request.setAttribute("month", month);
            }
            case "updateSchedule3Execute" -> {
                String id = request.getParameter("id");
                String staffID = request.getParameter("staffID");
                listDAO.updateSchedule3Execute(staffID, id, date);
                target = "Schedule.jsp";
            }
            case "updateScheduleExecute" -> {
                String id = request.getParameter("id");
                String staffID = request.getParameter("staffID");
                listDAO.updateScheduleExecute(staffID, id, month);
                target = "Schedule.jsp";
            }
            case "viewScheduleByMonth" -> {
                ArrayList<Schedule> listHis3 = listDAO.getSchedule3(month);
                ArrayList<Sample> listSamp = listDAO.getSampleSchedule();
                ArrayList<Sample> listHis = listDAO.getHistorySchedule(month);
                ArrayList<Sample> listD = listDAO.getDoneMachine();
                request.setAttribute("listHis", listHis);
                request.setAttribute("listSamp", listSamp);
                request.setAttribute("month", month);
                request.setAttribute("listD", listD);
                request.setAttribute("listHis3", listHis3);

                target = "MainControl?mode=viewSchedule";
            }
            case "viewSchedule" -> {
                ArrayList<History> list = listDAO.getHistoryByMonth(month);
                ArrayList<History> listAll = listDAO.getAllHistory();
                ArrayList<Sample> listD = listDAO.getDoneMachine();
                ArrayList<History> listUD = listDAO.getUnDoneMachine();
                ArrayList<Sample> listSamp = listDAO.getSampleSchedule();
                ArrayList<Sample> listDone3 = listDAO.getScheduleDone3();
                request.setAttribute("done3", listDone3);
                request.setAttribute("listH", list);
                request.setAttribute("listSamp", listSamp);
                request.setAttribute("listAll", listAll);
                request.setAttribute("listD", listD);
                request.setAttribute("listUD", listUD);
                request.setAttribute("month", month);
                target = "Schedule.jsp";
            }
            case "ViewDoneMachine" -> {
                ArrayList<Sample> listD = listDAO.getDoneMachine();
                request.setAttribute("listD", listD);
                target = "DoneList.jsp";
            }
            case "ViewUnDoneMachine" -> {
                ArrayList<History> list = listDAO.getUnDoneMachine();
                request.setAttribute("listUD", list);
                target = "UndoneList.jsp";
            }
            case "ViewScheduleStatus" -> {
                String text1 = request.getParameter("assetNo");
                Machine machine = machineDAO.getMachineByAssetNo(text1);
                request.setAttribute("machine", machine);
                target = "ViewSchedule.jsp";
            }
            case "check" -> {
                String[] remark = new String[7];
                String text = request.getParameter("assetNo");
                account = (Account) session.getAttribute("account");
                String[] checkboxs = request.getParameterValues("checkedbox");
                String[] checked = new String[7];
                for (int i = 0; i < checked.length; i++) {
                    checked[i] = "";
                }

                try {
                    Machine machine = machineDAO.getMachineByAssetNo(text);
                    if (checkboxs != null) {
                        for (String checkbox : checkboxs) {
                            for (int i = 0; i < checked.length; i++) {
                                if (checkbox.matches("check" + (i + 1) + "[WMQBAD]")) {
                                    checked[i] += checkbox.charAt(checkbox.length() - 1);
                                }
                                if (checkbox.matches("checkedAll")) {
                                    listDAO.isChecked(text, "checklist_" + (i + 1), checked[i]);
                                }
                            }
                        }
                        for (int i = 0; i < checked.length; i++) {
                            listDAO.isChecked(text, "checklist_" + (i + 1), checked[i]);
                            if (account.getIsAdmin() == 1) {
                                listDAO.updateByCategory(machine.getCategory(), "checklist_" + (i + 1), checked[i]);
                            }
                        }
                        for (int i = 0; i < remark.length; i++) {
                            remark[i] = request.getParameter("remark" + (i + 1));
                            if (remark[i] != null) {
                                listDAO.updateRemarkHistory(text, "remark_" + (i + 1), remark[i]);
                            }
                        }
                        listDAO.insertHistory(machine.getName(), text, date, account.getAccountID(), checked[0],
                                checked[1], checked[2], checked[3], checked[4],
                                checked[5], checked[6], remark[0], remark[1], remark[2], remark[3],
                                remark[4], remark[5], remark[6]);
                        for (int i = 0; i < checked.length; i++) {
                            checked[i] = "";
                        }
                    }
                } catch (NullPointerException e) {
                    System.out.println(e);
                }
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
