package com.mumin.crud.controller;

import com.mumin.crud.Staff;
import com.mumin.crud.service.StaffService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StaffController
{
    StaffService staffService = new StaffService();

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
        model.addAttribute("staff", staffService.getStaffById(id));

        return "addstaff";
    }

    @PostMapping("/submitformdata")
    public String submitForm(@Valid @ModelAttribute("staff") Staff staff, BindingResult result)
    {
        if (result.hasErrors()) {
            return "addstaff";
        }

        staffService.submitStaff(staff);

        return "redirect:/staffdetails";
    }

    @GetMapping("/staffdetails")
    public String getStaffDetails(Model model)
    {
        model.addAttribute("staffList", staffService.getAllStaff());

        return "staffdetails";
    }
}
