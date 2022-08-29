package com.tilmeez.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
public class HelloWorldController {

    // need a controller method to show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // need a controller method tp Process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }
    // new controller method to read form data and
    // add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letShowDude(HttpServletRequest request, Model model) {

        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the msg
        String result = "Yo! " + theName;

        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

}































