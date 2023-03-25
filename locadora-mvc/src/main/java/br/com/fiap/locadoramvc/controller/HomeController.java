package br.com.fiap.locadoramvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.fiap.locadoramvc.model.Filme;
import br.com.fiap.locadoramvc.repository.FilmeRepository;

@Controller
public class HomeController {

	@Autowired
	private FilmeRepository repository;

	@GetMapping("/home")
	public String home(Model model) {
		List<Filme> filme = repository.findAll();

		model.addAttribute("filme", filme);
		return "home";
	}
}
