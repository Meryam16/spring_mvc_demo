package org.example.Controlller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.ContextExposingHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    //Controller method to show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    //Controller method to process the HTML form
    @RequestMapping("processForm")
    public String processForm(){
        return "helloworld";
    }

    //new controller method to read form data and
    //add data to the model

       @RequestMapping("/processFromVersionTwo")
    public String makeUpperCase(HttpServletRequest request, Model model)
    {
        //read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

        //convert the data to upper case
        theName = theName.toUpperCase();

        //create the message
        String result = "Yo!" + theName;

        //add message to the model
        model.addAttribute("messagee", result);

        return "helloworld";
    }

    //use RequestParam annotation for the same method above
    @RequestMapping("/processFormVersionThree")
    public String makeUpperCaseTwo(
            @RequestParam("studentName") String theName,
            Model model )
    {
        //now we can use var theName
        theName = theName.toUpperCase();

        String result = "Hey My Friend!  " + theName;

        model.addAttribute("messagee" , result);

        return "helloworld";
    }
}

