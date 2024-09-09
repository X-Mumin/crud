package com.mumin.crud;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StaffController
{

    List<Staff> staffList = new ArrayList<>();

    /**
     * This controller method is used to handle GET requests to the "/staffdetails"
     * endpoint. It creates a new instance of the {@link Staff} class and adds it
     * to the model. The model is then passed to the "staffdetails" view.
     *
     * @param model The model that is passed to the view.
     * @return The name of the view that is rendered.
     */

    // id comes from <td><a th:href="@{/(id=${staff.staffId})}">Edit</a></td>
    @GetMapping("/")
    public String addStaff(Model model, @RequestParam(required = false) String id)
    {
        Staff staff = new Staff();

        int index = getStaffIndex(id);

        if (index != Constants.NO_MATCH) {
            staff = staffList.get(index);
        }

        model.addAttribute("staff", staff);

        return "addstaff";
    }

    private int getStaffIndex(String staffId)
    {
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i).getStaffId().equals(staffId)) {
                return i;
            }
        }
        return Constants.NO_MATCH;
    }

    @PostMapping("/submitformdata")
    public String submitForm(@Valid @ModelAttribute("staff") Staff staff, BindingResult result)
    {
        if (result.hasErrors()) {
            return "addstaff";
        }

        int index = getStaffIndex(staff.getStaffId());

        if (index == Constants.NO_MATCH) {
            staffList.add(staff);
        } else {
            staffList.set(index, staff);
        }

        return "redirect:/staffdetails";
    }

    @GetMapping("/staffdetails")
    public String getStaffDetails(Model model)
    {
        model.addAttribute("staffList", staffList);

        return "staffdetails";
    }
}
