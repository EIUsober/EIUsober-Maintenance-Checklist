/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.History;
import entity.Machine;
import entity.Sample;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class CheckListDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public CheckListDAO() {
    }

    public ArrayList<Sample> getSampleSchedule() {
        ArrayList<Sample> list = new ArrayList<>();
        try {
            String query = "select * from schedule_sample";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                Sample status = new Sample(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                );
                list.add(status);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public ArrayList<History> getUnDoneMachine() {
        ArrayList<History> list = new ArrayList<>();
        try {
            String query = "select * from maintained_history where status = 'Undone' ";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                History status = new History(rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16),
                        rs.getString(17),
                        rs.getString(18),
                        rs.getString(19)
                );
                list.add(status);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public ArrayList<History> getUnDone(String month) {
        ArrayList<History> list = new ArrayList<>();
        try {
            String query = "select * from maintained_history where status != 'Done' and date like '%" + month + "-%'";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                History status = new History(rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16),
                        rs.getString(17),
                        rs.getString(18),
                        rs.getString(19)
                );
                list.add(status);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public ArrayList<History> getDoneMachine(String month) {
        ArrayList<History> list = new ArrayList<>();
        try {
            String query = "select * from maintained_history where status = 'Done' and date like '%" + month + "-%'";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                History status = new History(rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16),
                        rs.getString(17),
                        rs.getString(18),
                        rs.getString(19)
                );
                list.add(status);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public ArrayList<History> getHistoryByMonth(String month) {
        ArrayList<History> list = new ArrayList<>();
        try {
            String query = "select * from maintained_history where date like '" + month + "-%'";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                History history = new History(rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16),
                        rs.getString(17),
                        rs.getString(18),
                        rs.getString(19)
                );
                list.add(history);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    //get more history
    public ArrayList<History> getAllHistory() {
        ArrayList<History> list = new ArrayList<>();
        try {
            String query = "select * from maintained_history";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                History history = new History(rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getString(13),
                        rs.getString(14),
                        rs.getString(15),
                        rs.getString(16),
                        rs.getString(17),
                        rs.getString(18),
                        rs.getString(19)
                );
                list.add(history);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void isChecked(String getAssetNo, String check, String c1) {
        String query = "update machine set " + check + " = '" + c1 + "' where asset_no = '" + getAssetNo + "'";
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert(String assetNo, LocalDate date, String getPerformedBy, String getChecklist_1, String getChecklist_2, String getChecklist_3, String getChecklist_4,
            String getChecklist_5, String getChecklist_6, String getChecklist_7,String getChecklist_d, String getRemark_1, String getRemark_2,
            String getRemark_3, String getRemark_4, String getRemark_5, String getRemark_6, String getRemark_7, String status) {
        String query = "update maintained_history set date = '" + date + "', performed_by = '" + getPerformedBy + "', checklist_1 = '" + getChecklist_1 + "',checklist_2 = '" + getChecklist_2 + "',checklist_3 = '" + getChecklist_3 + "',checklist_4 = '" + getChecklist_4 + "',checklist_5 = '" + getChecklist_5 + "',checklist_6 = '" + getChecklist_6 + "',checklist_7 = '" + getChecklist_7 + "',checklist_d = '" + getChecklist_d + "', remark_1 = '" + getRemark_1 + "', remark_2 = '" + getRemark_2 + "', remark_3 = '" + getRemark_3 + "', remark_4 = '" + getRemark_4 + "', remark_5 = '" + getRemark_5 + "', remark_6 = '" + getRemark_6 + "', remark_7 = '" + getRemark_7 + "', status ='" + status + "' where asset_no = '" + assetNo + "'";
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertHistory(String name, String assetNo, LocalDate date, String getPerformedBy, String getChecklist_1, String getChecklist_2, String getChecklist_3, String getChecklist_4,
            String getChecklist_5, String getChecklist_6, String getChecklist_7,String getChecklist_d, String getRemark_1, String getRemark_2,
            String getRemark_3, String getRemark_4, String getRemark_5, String getRemark_6, String getRemark_7, String status) {
        String query = "insert into maintained_history(machine_name, asset_no, date, performed_by, checklist_1,checklist_2,checklist_3,checklist_4,checklist_5,checklist_6,checklist_7,checklist_d,remark_1,remark_2,remark_3,remark_4,remark_5,remark_6,remark_7,status) values ('" + name + "','" + assetNo + "','" + date + "','" + getPerformedBy + "', '" + getChecklist_1 + "','" + getChecklist_2 + "','" + getChecklist_3 + "','" + getChecklist_4 + "','" + getChecklist_5 + "','" + getChecklist_6 + "','" + getChecklist_7 + "','" + getChecklist_d + "','" + getRemark_1 + "','" + getRemark_2 + "','" + getRemark_3 + "','" + getRemark_4 + "','" + getRemark_5 + "','" + getRemark_6 + "','" + getRemark_7 + "','done')";
        try {
            System.out.println(query);
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateRemark(String assetNo, String remark, String text) {
        String query = "update machine set " + remark + " = '" + text + "' where asset_no = '" + assetNo + "'";
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
