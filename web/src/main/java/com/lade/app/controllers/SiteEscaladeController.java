package com.lade.app.controllers;

import dao.SiteEscaladeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteEscaladeController {
  @Autowired
private SiteEscaladeDao siteEscaladeDao;
@GetMapping("/index")
  public String index() {

    return "index";
  }
}
