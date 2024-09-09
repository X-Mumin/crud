package com.mumin.crud;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class Staff {
    @NotBlank(message = "Staff Name cannot be blank")
    private String staffName;
    @NotBlank(message = "Staff Title cannot be blank")
    private String staffTitle;
    private double staffSalary;
    private String staffId;

    public Staff() {
        this.staffId = UUID.randomUUID().toString();
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffTitle() {
        return staffTitle;
    }

    public void setStaffTitle(String staffTitle) {
        this.staffTitle = staffTitle;
    }

    public double getStaffSalary() {
        return staffSalary;
    }

    public void setStaffSalary(double staffSalary) {
        this.staffSalary = staffSalary;
    }

    public String getStaffId()
    {
        return staffId;
    }

    public void setStaffId(String staffId)
    {
        this.staffId = staffId;
    }
}
