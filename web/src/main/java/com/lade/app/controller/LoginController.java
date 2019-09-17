package com.lade.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

  @GetMapping("/login")
  public String login(Model model) {
    return "views/login";
  }


  @GetMapping("/loginConfirme")
  public String loginConfirme(Model model) {
    return "views/loginConfirme";
  }



  @GetMapping("/logout")
  public String logout(Model model) {
    return "views/logoutConfirme";
  }



  @GetMapping("/logoutConfirme")
  public String logoutConfirme(Model model) {
    return "views/logoutConfirme";
  }


  @GetMapping("/403")
  public String error403() {
    return "errors/403";
  }
}

