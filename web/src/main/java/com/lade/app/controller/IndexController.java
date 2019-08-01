package com.lade.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

  @GetMapping({"/index", "/"})
  public String index() {
    return "views/index";
  }


  @GetMapping("/coco")
  public String commentaire() {
    return "views/creationCommentaire";
  }

  @GetMapping("/coco1")
  public String creationSiteEscalade() {
    return "views/requeteLocationTopos";
  }

}
