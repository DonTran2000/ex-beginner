package com.example.controller;

import com.example.form.CalculatorForm;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam02")
public class Exam02Controller {

    @Autowired
    private HttpSession session;

    @GetMapping("")
    public String exam02(CalculatorForm calculator) {
        return "exam02";
    }

    @PostMapping("/exam02Result")
    public String exam02Result(CalculatorForm calculator) {
        Integer number1 = Integer.parseInt(calculator.getNumber1());
        Integer number2 = Integer.parseInt(calculator.getNumber2());

        String result = String.valueOf(number1 + number2);
        calculator.setResult(result);

        session.setAttribute("calculator", calculator);

        return "exam02-result";
    }

    @PostMapping("/exam02Result2")
    public String exam02Result2() {
        return "exam02-result2";
    }
}
