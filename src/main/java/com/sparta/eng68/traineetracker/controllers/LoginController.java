package com.sparta.eng68.traineetracker.controllers;

import com.sparta.eng68.traineetracker.utilities.Pages;
import com.sparta.eng68.traineetracker.utilities.Roles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String getLogin(ModelMap modelMap,
                           @ModelAttribute("loginResult") final Object loginResult) {

        modelMap.addAttribute("showError", loginResult);


        return Pages.accessPage(Roles.ANY, Pages.LOGIN_PAGE);
    }

    @GetMapping("/loginFailure")
    public ModelAndView getLoginFailure(ModelMap modelMap,
                                        RedirectAttributes redirectAttributes,
                                        HttpServletRequest request) {

        redirectAttributes.addFlashAttribute("loginResult", "true");

        return new ModelAndView("redirect:/login", modelMap);
    }

    @PostMapping
    public ModelAndView postLoginFailure(ModelMap modelMap,
                                         RedirectAttributes redirectAttributes,
                                         HttpServletRequest request) {



        return new ModelAndView("redirect:/login", modelMap);
    }

}
