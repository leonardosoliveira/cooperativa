package br.com.cooperativa.sessao.gerenciador.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import br.com.cooperativa.sessao.gerenciador.model.Pauta;
import br.com.cooperativa.sessao.gerenciador.model.StatusPauta;

public class RequisicaoNovaPauta {
	@NotBlank
	private String nomePauta;
	
	@NotBlank
	private String duracaoPauta;
	
	@NotBlank 
	private String descricaoPauta;
	
	
	public String getNomePauta() {
		return nomePauta;
	}
	public void setNomePauta(String nomePauta) {
		this.nomePauta = nomePauta;
	}
	public String getDuracaoPauta() {
		return duracaoPauta;
	}
	public void setDuracaoPauta(String duracaoPauta) {
		this.duracaoPauta = duracaoPauta;
	}
	public String getDescricaoPauta() {
		return descricaoPauta;
	}
	public void setDescricaoPauta(String descricaoPauta) {
		this.descricaoPauta = descricaoPauta;
	}
	
	public Pauta toPauta() {
		Pauta pauta = new Pauta();
		pauta.setNomePauta(nomePauta);
		pauta.setDuracaoDaPauta(duracaoPauta);
		pauta.setDescricaoDaPauta(descricaoPauta);
		pauta.setStatusDaPauta(StatusPauta.VOTADAS);
		pauta.setDataDaPauta(LocalDate.now());
		return pauta;
	}
	
	

}
