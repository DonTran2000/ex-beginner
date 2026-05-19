package com.example.controller;

import com.example.domain.User;
import com.example.form.UserForm;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam04")
public class Exam04Controller {

    @GetMapping("")
    public String index(UserForm userForm) {
        return "exam04";
    }

    @PostMapping("/exam04Result")
    public String exam04Result(@Validated UserForm userForm, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "exam04";
        }

        User user = new User();
        BeanUtils.copyProperties(userForm, user);
//        user.setName(userForm.getName());
        user.setAge(Integer.parseInt(userForm.getAge()));
//        user.setComment(userForm.getComment());

        model.addAttribute("user", user);

        return "exam04-result";
    }
}
