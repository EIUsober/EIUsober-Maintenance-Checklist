/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Account;
import entity.CategoryChecklist;
import entity.Machine;
import entity.Schedule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class MachineDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public MachineDAO() {
    }

    public CategoryChecklist getChecklistByCategory(String category) {
        try {
            String query = "select * from checklist_sample where category = '" + category + "'";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                return new CategoryChecklist(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
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
                        rs.getInt(16)
                );
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Machine> getAllCategory() {
        ArrayList<Machine> list = new ArrayList<Machine>();
        String query = "SELECT category FROM machine";
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                Machine category = new Machine(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
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
                list.add(category);
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public Schedule getMachine3ByAssetNo(String assetNo) {
        try {
            String query = "select * from schedule_3 where asset_no = '" + assetNo + "'";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                return new Schedule(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getDate(7),
                        rs.getInt(8),
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
                        rs.getString(20),
                        rs.getString(21),
                        rs.getString(22),
                        rs.getString(23)
                );
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
     public Machine getMachineByAssetNo(String asset) {
        try {
            String query = "select * from machine where asset_no = '" + asset + "'";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                return new Machine(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
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
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Machine getMachineByID(String id) {
        try {
            String query = "select * from maintained_history where id = '" + id + "'";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                return new Machine(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
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
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Machine> get1stPageMachine() {
        ArrayList<Machine> list = new ArrayList<>();
        try {
            String query = "select * from machine LIMIT 5";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                Machine machine = new Machine(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
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
                        rs.getString(19)                );
                list.add(machine);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public ArrayList<Machine> getNextPageMachine(int index) {
        ArrayList<Machine> list = new ArrayList<>();
        try {
            int first = index * 10;
            int second = index * 10 + 10;
            String query = "select * from machine LIMIT " + first + " , " + second + "";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                Machine machine = new Machine(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
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
                        rs.getString(19)                );
                list.add(machine);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public ArrayList<Machine> getAllMachine() {
        ArrayList<Machine> list = new ArrayList<>();
        try {
            String query = "select * from machine";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                Machine machine = new Machine(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
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
                        rs.getString(19)                );
                list.add(machine);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public ArrayList<Machine> getMachineByDepartment(String a) {
        ArrayList<Machine> list = new ArrayList<>();
        try {
            String query = "select * from machine where department = '" + a + "'";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                Machine machine = new Machine(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
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
                        rs.getString(19)                );
                list.add(machine);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void addMachine(Machine m) {
        String query = "insert into machine (machine_name, asset_no, department, location,category) values ('" + m.getName() + "','" + m.getAssetNo() + "','" + m.getDepartment() + "','" + m.getLocation() + "', '"+ m.getCategory() +"')";
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void editMachine(Machine m) {
        String query = "update machine set machine_name = '" + m.getName() + "', asset_no = '" + m.getAssetNo() + "', department = '" + m.getDepartment() + "', location = '" + m.getLocation() + "', category = '"+m.getCategory()+"' where asset_no = '" + m.getAssetNo() + "';";
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteMachine(String assetNo) {
        String query = "delete from machine where asset_no = '" + assetNo + "'";
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Machine> searchByName(String name) {
        ArrayList<Machine> list = new ArrayList<>();
        String query = "select * from machine where machine_name like '%" + name + "%' or asset_no like '%" + name + "%' or department like '%" + name + "%'";
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                Machine machine = new Machine(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
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
                        rs.getString(19)                );
                list.add(machine);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public ArrayList<Machine> searchByStaff(String name, String department) {
        ArrayList<Machine> list = new ArrayList<>();
        String query = "select * from machine where (machine_name like '%" + name + "%' or asset_no like '%" + name + "%') and  department = '" + department + "'";
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                Machine machine = new Machine(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
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
                        rs.getString(19)                );
                list.add(machine);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
