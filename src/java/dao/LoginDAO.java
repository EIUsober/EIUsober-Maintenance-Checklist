/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import context.DBContext;
import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class LoginDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public LoginDAO() {
    }

    public Account getAccountByID(String id){
        try {
            String query = "select * from account_tb where account_id = '" + id + "'";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
            while (rs.next()) {
                return new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)
                );
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public void disableUser(String id) {
        String query = "update account_tb set active = '0' where account_id = '" + id + "'";
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void editUser(Account m) {
        String query = "update account_tb set username = '" + m.getUsername() + "', password = '" + m.getPassword() + "', department = '" + m.getDepartment() + "' where account_id = '" + m.getAccountID() + "';";
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void addUser(String username, String password, String department, String id){
        String query = "";
        if(department.contains("account")){
             query = "insert into account_tb (username, password,isAccount, department, account_id, active) values ('" + username + "','" + password + "','1','" + department + "','" + id + "', '1')";
        }
        if(department.contains("it")){
             query = "insert into account_tb (username, password,isIT, department, account_id, active) values ('" + username + "','" + password + "','1','" + department + "','" + id + "', '1')";
        }
        if(department.contains("shipping")){
             query = "insert into account_tb (username, password,isShipping, department, account_id, active) values ('" + username + "','" + password + "','1','" + department + "','" + id + "', '1')";
        }
        if(department.contains("admin")){
             query = "insert into account_tb (username, password,isAdmin, department, account_id, active) values ('" + username + "','" + password + "','1','" + department + "','" + id + "', '1')";
        }
        try {
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Account login(String username, String password) {
        try {
            String query = "select * from account_tb where username = '" + username + "' and password = '" + password + "'";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                return new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)
                );
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Account getAccountDepartment(Account a) {
        try {
            String query = "select department from account_tb where username = '" + a.getUsername() + "'";
            con = DBContext.getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery(query);
            while (rs.next()) {
                return new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)
                );
            }
            con.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
