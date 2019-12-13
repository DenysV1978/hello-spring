package org.launchcodes.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "hello") //class-level controller; so, all other guys go after /hello/
public class HelloSpringController {
    @GetMapping("hello")
    @ResponseBody
    public String hello1() {
        return "HelloAhhh, Spring"; //here we just input in html /hello/hello
    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring"; // here we input /hello/goodbye
    }

    //handles request of the form /hello?name=LaunchCode

    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value = "anotherHello")
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String choice, Model model) {
        //System.out.println(name + "    " + choice);
        String theGreeting;
        if(choice.contains("first")) {
            //System.out.println("Stop");
             theGreeting = "Hello, "  + name + "!" ; // here we input /hello/anotherHello?name=Denys

        } else if(choice.equals("second")) {
             theGreeting = "Privet, " + name + "!";
        } else if(choice.equals("third")) {
             theGreeting = "Bonjur, " + name + "!";
        } else if(choice.equals("fourth")) {
             theGreeting =  "Guten morgen, " + name + "!";
        } else {
             theGreeting =  "Nihau, " + name + "!";
        }

        model.addAttribute("greeting", theGreeting);

        return "hello";

    }

//    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST}, value = "anotherHello")
//    public String helloWithQueryParam(@RequestParam String name, Model model) {
//        String theGreeting = "Hello, " + name + "!";
//        model.addAttribute("greeting", theGreeting);
//
//        return "hello";
//        }



    // handles requests of the form /hello/LaunchCode

    @GetMapping("{name}")
    @ResponseBody // Response body menas Hey do not look for templates just return text
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!"; // here we input /hello/Denys

    }

    @GetMapping("form")
    //@ResponseBody //no ResponseBody - go and find template
    public String helloForm() {
        return "form";


        //String html =

//                "<html>" +
//                "<body>" +
//                "<form action='anotherHello' method='post'>" +  //submit a request to /hello
//                "<input type='text' name='name'>"+
//                "<input type='submit' value='Greet me!'>" +
//                "<select name='choice'>" +
//                "<option value='first'>English</option>" +
//                "<option value='second'>Russian</option>" +
//                "<option value='third'>French</option>" +
//                "<option value='fourth'>German</option>" +
//                "<option value='fifth'>Chinese</option>" +
//                 "</select>" +
//                "</form>" +
//                "</body" +
//                "</html>"; // here we input /hello/form and submit Denys
        //return html;

    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {

        ArrayList<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Denys");
        names.add("Olga");
        model.addAttribute("names", names);

        return "hello-list";
    }


}
