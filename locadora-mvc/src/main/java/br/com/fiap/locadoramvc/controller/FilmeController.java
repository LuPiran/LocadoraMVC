package br.com.fiap.locadoramvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import br.com.fiap.locadoramvc.model.Filme;
import br.com.fiap.locadoramvc.repository.FilmeRepository;
import jakarta.validation.Valid;

@Controller
public class FilmeController {
	
	@Autowired
	private FilmeRepository repository;
	
	// Acessa o formulario
	@GetMapping("/form")
	public String filmeForm(Filme filme) {
		return "addFilme";
	}
	
	//Adiciona novo filme
	@PostMapping("/add")
	public String novo(@Valid Filme filme, BindingResult result) {
		
		if(result.hasFieldErrors()) {
			return "redirect:/form";
		}
		
		repository.save(filme);
		return "redirect:/home";
	}
	
	//Acessa o formulario de edicao
	@GetMapping("form/{id}")
	public String updateForm(Model model, @PathVariable(name = "id") int id) {
		
		Filme filme = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid film id:" +id));
		
		model.addAttribute("filme", filme);
		
		return "editForm";
	}
	
	//Atualiza o filme
	@PostMapping("update/{id}")
	public String alterarFilme(@Valid Filme filme, BindingResult result, @PathVariable int id) {
		if(result.hasErrors()) {
			return "redirect:/form";
		}
		
		repository.save(filme);
		return "redirect:/home";
	}
	
	@GetMapping("delete/{id}")
    @CacheEvict(value = "filme", allEntries = true)
	public String delete(@PathVariable(name = "id") int id, Model model) {
		Filme filme = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid film id:" +id));
		
		repository.delete(filme);
		return "redirect:/home";
	}
	
	
}
