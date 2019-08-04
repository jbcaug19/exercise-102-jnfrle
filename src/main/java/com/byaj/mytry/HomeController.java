package com.byaj.mytry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
  @Autowired
  MovieRepository repository;

  @RequestMapping("/")
  public String dude(Model model){
    model.addAttribute("movies", repository.findAll());
    return "index";
  }

  @RequestMapping("/add")
  public String movieForm(Model model){
    model.addAttribute("movie", new Movie());
    return "movieform";
  }

  @RequestMapping("/process")
  public String processMovie(@ModelAttribute Movie movie)
  {
    repository.save(movie);
    return "redirect:/";
  }
}