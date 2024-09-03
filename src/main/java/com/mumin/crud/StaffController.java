package com.mumin.crud;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StaffController
{
    // class level list to be not recreated every time getStaffDetails is called.
    List<Staff> staffList = new ArrayList<>(List.of(
            new Staff("Mumin", "Developer", 15000),
            new Staff("Muhammad", "Developer", 10000),
            new Staff("Ahmad", "Developer", 20000)
    ));

    /**
     * This controller method is used to handle GET requests to the "/staffdetails"
     * endpoint. It creates a new instance of the {@link Staff} class and adds it
     * to the model. The model is then passed to the "staffdetails" view.
     *
     * @param model The model that is passed to the view.
     * @return The name of the view that is rendered.
     */
    @GetMapping("/staffdetails")
    public String getStaffDetails(Model model)
    {

        model.addAttribute("staffList", staffList);

        return "staffdetails";
    }
}
