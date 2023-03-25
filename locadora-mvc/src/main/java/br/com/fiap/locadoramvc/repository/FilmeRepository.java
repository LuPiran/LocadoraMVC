package br.com.fiap.locadoramvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.locadoramvc.model.Filme;


public interface FilmeRepository extends JpaRepository<Filme, Integer>{

}
