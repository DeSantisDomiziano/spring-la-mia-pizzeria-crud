package org.java.app.controller;


import java.util.List;
import org.java.app.pojo.Pizza;
import org.java.app.serve.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

}
