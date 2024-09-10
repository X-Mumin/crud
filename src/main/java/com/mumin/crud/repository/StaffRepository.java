package com.mumin.crud.repository;

import com.mumin.crud.Staff;

import java.util.ArrayList;
import java.util.List;

public class StaffRepository
{
    private List<Staff> staffList = new ArrayList<>();

    public Staff getStaffByIndex(int index)
    {
        return staffList.get(index);
    }

    public void addStaff(Staff staff)
    {
        staffList.add(staff);
    }

    public void updateStaff(Staff staff, int index)
    {
        staffList.set(index, staff);
    }

    public List<Staff> getAllStaff()
    {
        return staffList;
    }
}
