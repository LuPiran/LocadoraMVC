package br.com.fiap.locadoramvc.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Filme {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	private String nomeFilme;
	private BigDecimal valorFilme;
	@NotBlank
	private String quantidade;
	@NotBlank
	private String urlFilme;
	@NotBlank
	private String urlImage;
	@NotBlank
	private String descricao;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeFilme() {
		return nomeFilme;
	}
	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}
	public BigDecimal getValorFilme() {
		return valorFilme;
	}
	public void setValorFilme(BigDecimal valorFilme) {
		this.valorFilme = valorFilme;
	}
	public String getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getUrlFilme() {
		return urlFilme;
	}
	public void setUrlFilme(String urlFilme) {
		this.urlFilme = urlFilme;
	}
	public String getUrlImage() {
		return urlImage;
	}
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
