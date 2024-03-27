/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Schedule {

    private int id;
    private String name;
    private String assetNo;
    private String status;
    private String performedBy;
    private Date datePlan;
    private Date dateComplete;
    private int dateGap;
    private String checklist_1;
    private String checklist_2;
    private String checklist_3;
    private String checklist_4;
    private String checklist_5;
    private String checklist_6;
    private String checklist_7;
    private String remark_1;
    private String remark_2;
    private String remark_3;
    private String remark_4;
    private String remark_5;
    private String remark_6;
    private String remark_7;
    private String category;

    public Schedule(int id, String name, String assetNo, String status, String performedBy, Date datePlan, Date dateComplete, int dateGap, String checklist_1, String checklist_2, String checklist_3, String checklist_4, String checklist_5, String checklist_6, String checklist_7, String remark_1, String remark_2, String remark_3, String remark_4, String remark_5, String remark_6, String remark_7, String category) {
        this.id = id;
        this.name = name;
        this.assetNo = assetNo;
        this.status = status;
        this.performedBy = performedBy;
        this.datePlan = datePlan;
        this.dateComplete = dateComplete;
        this.dateGap = dateGap;
        this.checklist_1 = checklist_1;
        this.checklist_2 = checklist_2;
        this.checklist_3 = checklist_3;
        this.checklist_4 = checklist_4;
        this.checklist_5 = checklist_5;
        this.checklist_6 = checklist_6;
        this.checklist_7 = checklist_7;
        this.remark_1 = remark_1;
        this.remark_2 = remark_2;
        this.remark_3 = remark_3;
        this.remark_4 = remark_4;
        this.remark_5 = remark_5;
        this.remark_6 = remark_6;
        this.remark_7 = remark_7;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssetNo() {
        return assetNo;
    }

    public void setAssetNo(String assetNo) {
        this.assetNo = assetNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPerformedBy() {
        return performedBy;
    }

    public void setPerformedBy(String performedBy) {
        this.performedBy = performedBy;
    }

    public Date getDatePlan() {
        return datePlan;
    }

    public void setDatePlan(Date datePlan) {
        this.datePlan = datePlan;
    }

    public Date getDateComplete() {
        return dateComplete;
    }

    public void setDateComplete(Date dateComplete) {
        this.dateComplete = dateComplete;
    }

    public int getDateGap() {
        return dateGap;
    }

    public void setDateGap(int dateGap) {
        this.dateGap = dateGap;
    }

    public String getChecklist_1() {
        return checklist_1;
    }

    public void setChecklist_1(String checklist_1) {
        this.checklist_1 = checklist_1;
    }

    public String getChecklist_2() {
        return checklist_2;
    }

    public void setChecklist_2(String checklist_2) {
        this.checklist_2 = checklist_2;
    }

    public String getChecklist_3() {
        return checklist_3;
    }

    public void setChecklist_3(String checklist_3) {
        this.checklist_3 = checklist_3;
    }

    public String getChecklist_4() {
        return checklist_4;
    }

    public void setChecklist_4(String checklist_4) {
        this.checklist_4 = checklist_4;
    }

    public String getChecklist_5() {
        return checklist_5;
    }

    public void setChecklist_5(String checklist_5) {
        this.checklist_5 = checklist_5;
    }

    public String getChecklist_6() {
        return checklist_6;
    }

    public void setChecklist_6(String checklist_6) {
        this.checklist_6 = checklist_6;
    }

    public String getChecklist_7() {
        return checklist_7;
    }

    public void setChecklist_7(String checklist_7) {
        this.checklist_7 = checklist_7;
    }

    public String getRemark_1() {
        return remark_1;
    }

    public void setRemark_1(String remark_1) {
        this.remark_1 = remark_1;
    }

    public String getRemark_2() {
        return remark_2;
    }

    public void setRemark_2(String remark_2) {
        this.remark_2 = remark_2;
    }

    public String getRemark_3() {
        return remark_3;
    }

    public void setRemark_3(String remark_3) {
        this.remark_3 = remark_3;
    }

    public String getRemark_4() {
        return remark_4;
    }

    public void setRemark_4(String remark_4) {
        this.remark_4 = remark_4;
    }

    public String getRemark_5() {
        return remark_5;
    }

    public void setRemark_5(String remark_5) {
        this.remark_5 = remark_5;
    }

    public String getRemark_6() {
        return remark_6;
    }

    public void setRemark_6(String remark_6) {
        this.remark_6 = remark_6;
    }

    public String getRemark_7() {
        return remark_7;
    }

    public void setRemark_7(String remark_7) {
        this.remark_7 = remark_7;
    }
    
    
}
