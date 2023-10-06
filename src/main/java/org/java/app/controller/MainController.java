package org.java.app.controller;


import java.util.List;
import org.java.app.pojo.Pizza;
import org.java.app.serve.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/pizze")
	public String getIndex(Model model, 
						   @RequestParam(required = false) String name) {
		
		List<Pizza> pizze = name == null 
							? pizzaService.findAll()
							: pizzaService.searchPizzaByNameOrOverview(name, name);
		
		
		model.addAttribute("pizze", pizze);
		
		return "index";
	}
	
	@GetMapping("/pizza/{id}")
    public String getMovieDetails(@PathVariable int id, Model model) {
			Pizza pizza = pizzaService.findById(id);
        
            model.addAttribute("pizza", pizza);
            return "show";
    }
	
	@GetMapping("/create")
	public String getCreate(Model model) {
		
		model.addAttribute("pizza", new Pizza());
		
		return "create";
	}
	
	@PostMapping("/create")
	public String storePizza(@Valid @ModelAttribute Pizza pizza,
							BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			bindingResult.getAllErrors().forEach(System.out::println);
			
			return "create";
		}
		
		pizzaService.save(pizza);
		
		return "redirect:/pizze";
	}

}
