/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Admin
 */
public class Profile{

    private String name;
    private String img;
    private String email;
    private String phone;
    private String accountID;

    public Profile(String name, String img, String email, String phone, String accountID) {
        this.name = name;
        this.img = img;
        this.email = email;
        this.phone = phone;
        this.accountID = accountID;

    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Profile{" + "name=" + name + ", img=" + img + ", email=" + email + ", phone=" + phone + ", accountID=" + accountID + '}';
    }

}
