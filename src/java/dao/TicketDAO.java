/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Account;
import entity.Ticket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class TicketDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public TicketDAO() {
    }
    
    public ArrayList<Ticket> getTotalUndone() {
        ArrayList<Ticket> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM ticket where status != 'Done'";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                Ticket ticket = new Ticket(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                        
                );
                list.add(ticket);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

     public ArrayList<Ticket> getUndone(String staffID) {
        ArrayList<Ticket> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM ticket where status != 'Done' and maintenance = '"+staffID+"'";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                Ticket ticket = new Ticket(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                );
                list.add(ticket);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void deleteTicket(String id) {
        String query = "delete from ticket where ticket_id = '" + id + "'";
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Account> getAllAccount() {
        ArrayList<Account> list = new ArrayList<>();
        String query = "select * from account_tb";
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                Account acc = new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)
                );
                list.add(acc);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public Ticket getTicket(String id) {
        try {
            String query = "select * from ticket where ticket_id = '" + id + "'";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                return new Ticket(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                );
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public ArrayList<Ticket> viewTicketByDepartment(String id) {
        ArrayList<Ticket> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM ticket where staff_name = '" + id + "'";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                Ticket ticket = new Ticket(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                );
                list.add(ticket);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public ArrayList<Ticket> getTicketByStaff(String staff) {
        ArrayList<Ticket> list = new ArrayList<>();
        String query = "select * from ticket where maintenance = '" + staff + "'";
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                Ticket ticket = new Ticket(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                );
                list.add(ticket);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public ArrayList<Ticket> getAllTicket() {
        ArrayList<Ticket> list = new ArrayList<>();
        String query = "select * from ticket";

        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                Ticket ticket = new Ticket(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8)
                );
                list.add(ticket);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void addTicketRemark(String r, String id) {
        String query = "update ticket set remark = '" + r + "' where ticket_id = '" + id + "'";
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void editTicket(Ticket t) {
        String query = "update ticket set description = '" + t.getDescription() + "' where ticket_id = '" + t.getTicketID() + "'";
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateExecute(String staff, String tickID) {
        String query = "update ticket set maintenance = '" + staff + "' where ticket_id = '" + tickID + "'";
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateStatus(String status, String tickID, LocalDate date) {
        String query = "update ticket set status = '" + status + "', date_complete = '"+date+"' where ticket_id = '" + tickID + "'";
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addTicket(Ticket t) {
        String query = "insert into ticket (staff_name, date, status, description) "
                + "values ('" + t.getStaffID() + "','" + t.getDateTicket() + "',"
                + "'Undone','" + t.getDescription() + "')";
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
