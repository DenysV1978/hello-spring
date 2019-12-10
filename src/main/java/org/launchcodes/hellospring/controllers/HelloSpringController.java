package org.launchcodes.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "hello")
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
    @ResponseBody

    public String helloWithQueryParam(@RequestParam String name, @RequestParam String choice) {
        //System.out.println(name + "    " + choice);
        if(choice.contains("first")) {
            //System.out.println("Stop");
            return "<head>" +
                    "<style>" +
                    "body {background-color: red}" +
                    "</style>" +
                    "Hello, "  +
                    name +
                    "!" +
                    "</head>"; // here we input /hello/anotherHello?name=Denys

        } else if(choice.equals("second")) {
            return "Privet, " + name + "!";
        } else if(choice.equals("third")) {
            return "Bonjur, " + name + "!";
        } else if(choice.equals("fourth")) {
            return "Guten morgen, " + name + "!";
        } else {
            return "Nihau, " + name + "!";
        }

    }

    // handles requests of the form /hello/LaunchCode

    @GetMapping("{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!"; // here we input /hello/Denys

    }

    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='anotherHello' method='post'>" +  //submit a request to /hello
                "<input type='text' name='name'>"+
                "<input type='submit' value='Greet me!'>" +
                "<select name='choice'>" +
                "<option value='first'>English</option>" +
                "<option value='second'>Russian</option>" +
                "<option value='third'>French</option>" +
                "<option value='fourth'>German</option>" +
                "<option value='fifth'>Chinese</option>" +
                 "</select>" +
                "</form>" +
                "</body" +
                "</html>"; // here we input /hello/form and submit Denys

    }


}
