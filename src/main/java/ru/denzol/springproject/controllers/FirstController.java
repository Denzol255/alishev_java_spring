package ru.denzol.springproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.denzol.springproject.enums.ActionType;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String getHelloPage(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname,
            Model model
    ) {
        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String getGoodbyePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String getCalculatorPage(@RequestParam("first") int first,
                                    @RequestParam("second") int second,
                                    @RequestParam("action") ActionType action,
                                    Model model) {
        model.addAttribute("first", first);
        model.addAttribute("second", second);
        double result = 0;
        String actionMark = "+";
        switch (action) {
            case MULTIPLICATION:
                result = first * second;
                actionMark = "*";
                break;
            case DIVISION:
                if (second != 0) {
                    result = (double) first / second;
                    actionMark = "/";
                }
                break;
            case ADDITION:
                result = first + second;
                actionMark = "+";
                break;
            case SUBTRACTION:
                result = first - second;
                actionMark = "-";
                break;
            default:
                break;
        }
        model.addAttribute("action", actionMark);
        model.addAttribute("result", result);
        return "first/calculator";
    }
}
