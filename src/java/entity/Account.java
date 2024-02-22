/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Account {

    private String username;
    private String password;
    private int isAdmin;
    private int isIT;
    private int isAccount;
    private int isShipping;
    private String department;
    private String accountID;
    private int isActive;

    public Account(String username, String password, int isAdmin, int isIT, int isAccount, int isShipping, String department, String accountID, int isActive) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
        this.isIT = isIT;
        this.isAccount = isAccount;
        this.isShipping = isShipping;
        this.department = department;
        this.accountID = accountID;
        this.isActive = isActive;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getIsIT() {
        return isIT;
    }

    public void setIsIT(int isIT) {
        this.isIT = isIT;
    }

    public int getIsAccount() {
        return isAccount;
    }

    public void setIsAccount(int isAccount) {
        this.isAccount = isAccount;
    }

    public int getIsShipping() {
        return isShipping;
    }

    public void setIsShipping(int isShipping) {
        this.isShipping = isShipping;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", password=" + password + ", isAdmin=" + isAdmin + ", isIT=" + isIT + ", isAccount=" + isAccount + ", isShipping=" + isShipping + ", department=" + department + ", accountID=" + accountID + ", isActive=" + isActive + '}';
    }

}
