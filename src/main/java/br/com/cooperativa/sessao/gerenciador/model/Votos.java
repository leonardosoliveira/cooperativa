package br.com.cooperativa.sessao.gerenciador.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Votos {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String voto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Pauta pauta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}
	
	
		

}
