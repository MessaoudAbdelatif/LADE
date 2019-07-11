package com.lade.app.controller;

import dao.SiteEscaladeDao;
import entities.SiteEscalade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SiteEscaladeController {

  @Autowired
  private SiteEscaladeDao siteEscaladeDao;

  @GetMapping("/siteEscalade")
  public String siteEscalade(Model model,
      @RequestParam(name="numPages", defaultValue="0") int numPages) {
    Page<SiteEscalade> pagesiteEscalade = siteEscaladeDao.findAll(PageRequest.of(numPages, 6));
    model.addAttribute("listSiteEscalade", pagesiteEscalade.getContent());
    model.addAttribute("pages", new int[pagesiteEscalade.getTotalPages()]);
    model.addAttribute("currentPage", numPages);

    return "views/siteEscalade";
  }
}
