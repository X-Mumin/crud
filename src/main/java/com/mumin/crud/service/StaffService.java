package com.mumin.crud.service;

import com.mumin.crud.Constants;
import com.mumin.crud.Staff;
import com.mumin.crud.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService
{
    StaffRepository staffRepository;

    public StaffService(StaffRepository staffRepository)
    {
        this.staffRepository = staffRepository;
    }

    public Staff getStaffByIndex(int index)
    {
        return staffRepository.getStaffByIndex(index);
    }

    public Staff getStaffById(String id)
    {
        Staff staff = new Staff();

        int index = getStaffIndex(id);

        if (index != Constants.NO_MATCH) {
            staff = getStaffByIndex(index);
        }
        return staff;
    }

    public int getStaffIndex(String staffId)
    {
        for (int i = 0; i < getAllStaff().size(); i++) {
            if (getStaffByIndex(i).getStaffId().equals(staffId)) {
                return i;
            }
        }
        return Constants.NO_MATCH;
    }

    public void addStaff(Staff staff)
    {
        staffRepository.addStaff(staff);
    }

    public void updateStaff(Staff staff, int index)
    {
        staffRepository.updateStaff(staff, index);
    }

    public List<Staff> getAllStaff()
    {
        return staffRepository.getAllStaff();
    }

    public void submitStaff(Staff staff)
    {
        int index = getStaffIndex(staff.getStaffId());

        if (index == Constants.NO_MATCH) {
            addStaff(staff);
        } else {
            updateStaff(staff, index);
        }
    }
}
