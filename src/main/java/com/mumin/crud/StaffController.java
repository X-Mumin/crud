package com.mumin.crud;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    @GetMapping("/")
    public String addStaff(Model model)
    {
        Staff staff = new Staff();
        model.addAttribute("staff", staff);

        return "addstaff";
    }

    @PostMapping("/submitformdata")
    public String submitForm(Staff staff)
    {
        staffList.add(staff);
        return "redirect:/staffdetails";
    }

    @GetMapping("/staffdetails")
    public String getStaffDetails(Model model)
    {
        model.addAttribute("staffList", staffList);

        return "staffdetails";
    }
}
