package br.com.cooperativa.sessao.gerenciador.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pauta {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomePauta;
	private LocalDate dataDaPauta;
	private String duracaoDaPauta;
	
	private String resultadoDaPauta;
	private String descricaoDaPauta;
	private Integer votoDaPauta;
	
	@Enumerated(EnumType.STRING)
	private StatusPauta status;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pauta", fetch = FetchType.LAZY)
	@JsonIgnore
	private List <Votos> votos;
	
	public String getNomePauta() {
		return nomePauta;
	}
	public void setNomePauta(String nomePauta) {
		this.nomePauta = nomePauta;
	}
	public LocalDate getDataDaPauta() {
		return dataDaPauta;
	}
	public void setDataDaPauta(LocalDate dataDaPauta) {
		this.dataDaPauta = dataDaPauta;
	}
	public String getDuracaoDaPauta() {
		return duracaoDaPauta;
	}
	public void setDuracaoDaPauta(String duracaoDaPauta) {
		this.duracaoDaPauta = duracaoDaPauta;
	}

	public String getResultadoDaPauta() {
		return resultadoDaPauta;
	}
	public void setResultadoDaPauta(String resultadoDaPauta) {
		this.resultadoDaPauta = resultadoDaPauta;
	}
	public String getDescricaoDaPauta() {
		return descricaoDaPauta;
	}
	public void setDescricaoDaPauta(String descricaoDaPauta) {
		this.descricaoDaPauta = descricaoDaPauta;
	}
	public Integer getVotoDaPauta() {
		return votoDaPauta;
	}
	public void setVotoDaPauta(Integer votoDaPauta) {
		this.votoDaPauta = votoDaPauta;
	}
	public StatusPauta getStatusDaPauta() {
		return status;
	}
	public void setStatusDaPauta(StatusPauta statusDaPauta) {
		this.status = statusDaPauta;
	}
	public List<Votos> getVotos() {
		return votos;
	}
	public void setVotos(List<Votos> votos) {
		this.votos = votos;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public StatusPauta getStatus() {
		return status;
	}
	public void setStatus(StatusPauta status) {
		this.status = status;
	}
	
	
}
