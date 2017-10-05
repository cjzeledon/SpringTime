package com.theironyard.charlotte.SpringTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    List<Grade> grade = new ArrayList<>(Arrays.asList(Grade.values()));

    /*
    NOTE from StackOverflow:
    RequestMethod.GET is a method that should be used to retrieve data from the server. Multiple get requests to the
    same URL should be valid and no data should be changed on the server side.
    */
    @RequestMapping(path = "/new_student", method = RequestMethod.GET)
    public String newStudent(Model model) {
        model.addAttribute("grades", grade);
        return "new_student";
    }

    /*
    NOTE from StackOverflow:
    RequestMethod.POST is a method that should be used when you need to create, update or delete data on the server
    side. Making the same POST request multiple times may not be safe and may result in inconsistent data. The content
    of a POST request is sent in the request body. Hence, you don't see the parameters in your browser, but it is easy
    to see them if you wanted to (Even using the browser developer tools) so it is no more safe than a GET request.

    With the /create_student path combined with RequestParam, it will look like this:
    /create_student?first_name=firstName&last_name=lastName&grade=grade

    QUESTION 1: What is RequestParam? What is the purpose of it? What do you do with it?
        A RequestParam is a method that binds the parameter to a web request parameter
    */
    @RequestMapping(path = "/create_student", method = RequestMethod.POST)
    public String createStudent(Student student, Model model) {

        /* add the student to the model that will be used by the view_student html file */
        model.addAttribute("student", student);

        // When you return "view_student", Spring will look to the "view_student.html" file and compile the information
        // provided by the user in accordance to the field sets
        return "view_student";
    }
}
