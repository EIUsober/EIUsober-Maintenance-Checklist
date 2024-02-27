/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.History;
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
                        rs.getString(19),
                        rs.getString(20)
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
                        rs.getString(19),
                        rs.getString(20)
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
                        rs.getString(19),
                        rs.getString(20)
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
                        rs.getString(19),
                        rs.getString(20)
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
                        rs.getString(19),
                        rs.getString(20)
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

    public void updateByCategory(String category, String check, String text) {
        String query = "update checklist_sample set " + check + " = '" + text + "' where category = '" + category + "'";

        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void updateRemarkByCategory(String category, String remark, String text) {
        String query = "update checklist_sample set " + remark + " = '" + text + "' where category = '" + category + "'";

        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateRemarkHistory(String assetNo, LocalDate date, String getPerformedBy, String remark, String text) {
        String query = "update maintained_history set date = '" + date + "', performed_by = '"+ getPerformedBy +"'," + remark + " = '" + text + "' where assetNo = '" + assetNo + "'";
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void insert(String assetNo, LocalDate date, String getPerformedBy, String check, String text) {
        String query = "update maintained_history set date = '" + date + "', performed_by = '"+ getPerformedBy +"'," + check + " = '" + text + "', status = 'Done' where assetNo = '" + assetNo + "'";
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertRemarkHistory(String name, String assetNo, LocalDate date, String getPerformedBy, String remark, String text) {
        String query = "insert into maintained_history(machine_name, asset_no, date, performed_by,"+remark+",status) values ('" + name + "','" + assetNo + "','" + date + "','" + getPerformedBy + "', '" + text + "')";
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void insertHistory(String name, String assetNo, LocalDate date, String getPerformedBy, String checklist_1,String checklist_2,String checklist_3,String checklist_4,String checklist_5,String checklist_6,String checklist_7,String checklist_8,String remark_1,String remark_2,String remark_3,String remark_4,String remark_5,String remark_6,String remark_7) {
        String query = "insert into maintained_history(machine_name, asset_no, date, performed_by,checklist_1,checklist_2,checklist_3,checklist_4,checklist_5,checklist_6,checklist_7,checklist_8,remark_1,remark_2,remark_3,remark_4,remark_5,remark_6,remark_7,status) values ('" + name + "','" + assetNo + "','" + date + "','" + getPerformedBy + "', '" + checklist_1 + "','" + checklist_2 + "','" + checklist_3 + "','" + checklist_4 + "','" + checklist_5 + "','" + checklist_6 + "','" + checklist_7 + "','" + checklist_8 + "','"+remark_1+"','"+remark_2+"','"+remark_3+"','"+remark_4+"','"+remark_5+"','"+remark_6+"','"+remark_7+"','done')";
        try {
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
