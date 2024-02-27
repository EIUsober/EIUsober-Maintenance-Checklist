package control;

import dao.CheckListDAO;
import dao.MachineDAO;
import entity.Account;
import entity.CategoryChecklist;
import entity.History;
import entity.Machine;
import entity.Sample;
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

public class MainControl extends HttpServlet {
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

        switch (mode) {
            case "search" -> {
                String text1 = request.getParameter("search");
                Machine machine = machineDAO.getMachineByAssetNo(text1);
                CategoryChecklist machine1 = machineDAO.getChecklistByCategory(machine.getCategory());
                request.setAttribute("machine", machine);
                request.setAttribute("categoryChecklist", machine1);
                System.out.println(machine1);
            }
            case "history" -> {
                ArrayList<History> listAll = listDAO.getAllHistory();
                ArrayList<History> list = listDAO.getHistoryByMonth(month);
                request.setAttribute("listAll", listAll);
                request.setAttribute("listH", list);

                target = "History.jsp";
            }
            case "viewSchedule" -> {

                ArrayList<History> list = listDAO.getHistoryByMonth(month);
                ArrayList<History> listAll = listDAO.getAllHistory();
                ArrayList<History> listD = listDAO.getDoneMachine(month);
                ArrayList<History> listUD = listDAO.getUnDoneMachine();
                ArrayList<Sample> listSamp = listDAO.getSampleSchedule();
                int count = listSamp.size();
                int pageSize = 10;
                int endPage = 0;
                endPage = count / pageSize;
                if (count % pageSize != 0) {
                    endPage++;
                }
                request.setAttribute("endPage", endPage);
                request.setAttribute("listH", list);
                request.setAttribute("listSamp", listSamp);
                request.setAttribute("listAll", listAll);
                request.setAttribute("listD", listD);
                request.setAttribute("listUD", listUD);
                request.setAttribute("month", month);

                target = "Schedule.jsp";
            }
            case "ViewDoneMachine" -> {
                month = date.format(formatter);
                ArrayList<History> listD = listDAO.getDoneMachine(month);
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
                String[] remark = new String[8];
                String text = request.getParameter("assetNo");
                Account account = (Account) session.getAttribute("account");
                String[] checkboxs = request.getParameterValues("checkedbox");
                String[] checked = new String[8];
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
                            listDAO.updateByCategory(machine.getCategory(), "checklist_" + (i + 1), checked[i]);
                        }
                        for (int i = 0; i < remark.length; i++) {
                            remark[i] = request.getParameter("remark" + (i + 1));
                            if (remark[i] != null) {
                                listDAO.updateRemark(text, "remark_" + (i + 1), remark[i]);
                            }
                        }
                        listDAO.insertHistory(machine.getName(), text, date, account.getAccountID(), checked[0],
                                checked[1], checked[2], checked[3], checked[4],
                                checked[5], checked[6], checked[7], remark[0], remark[1], remark[2], remark[3],
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
