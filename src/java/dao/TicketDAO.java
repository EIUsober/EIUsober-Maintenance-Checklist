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
public ArrayList<Account> getAllAccount() {
        ArrayList<Account> list = new ArrayList<>();
        String query = "select * from account_tb where active = '1'";
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
    public Ticket viewDescription(String id) {
        try {
            String query = "select description from ticket where ticket_id = '" + id + "'";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                return new Ticket(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                );
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public ArrayList<Ticket> getTicketByStaff(String staff) {
        ArrayList<Ticket> list = new ArrayList<>();
        String query = "select * from ticket where maintenance = '"+ staff +"'";
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
                        rs.getString(6)
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
                        rs.getString(6)
                );
                list.add(ticket);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public void updateExecute(String staff, String tickID) {
        String query = "update ticket set maintenance = '"+staff+"' where ticket_id = '"+tickID+"'";
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void updateStatus(String status, String tickID) {
        String query = "update ticket set status = '"+status+"' where ticket_id = '"+tickID+"'";
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void addTicket(Ticket t) {
        String query = "insert into ticket (staff_name, date, maintenance, status, description) "
                + "values ('" + t.getStaffID() + "','" + t.getDateTicket() + "','Select Staff',"
                + "'Undone','" + t.getDescription() + "')";
        try {
            System.out.println(query);
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
