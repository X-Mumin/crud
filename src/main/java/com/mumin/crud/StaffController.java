package com.mumin.crud;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaffController {

    /**
     * This controller method is used to handle GET requests to the "/staffdetails"
     * endpoint. It creates a new instance of the {@link Staff} class and adds it
     * to the model. The model is then passed to the "staffdetails" view.
     *
     * @param model The model that is passed to the view.
     * @return The name of the view that is rendered.
     */
    @GetMapping("/staffdetails")
    public String getStaffDetails(Model model) {
        Staff staff1 = new Staff("Mumin", "Developer", 10000);
        model.addAttribute("staff", staff1);

        return "staffdetails";
    }
}
