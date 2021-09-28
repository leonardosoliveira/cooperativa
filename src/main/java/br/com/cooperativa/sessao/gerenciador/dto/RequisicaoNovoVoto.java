package br.com.cooperativa.sessao.gerenciador.dto;

import org.springframework.boot.context.properties.source.ConfigurationPropertyName.Form;

import br.com.cooperativa.sessao.gerenciador.model.Pauta;
import br.com.cooperativa.sessao.gerenciador.model.Votos;

public class RequisicaoNovoVoto {
	
	private Long pautaId;
	
	private String voto;

	public Long getPautaId() {
		return pautaId;
	}

	public void setPautaId(Long pautaId) {
		this.pautaId = pautaId;
	}

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}
	
	public Votos toVoto() {
		
		
		Pauta pauta = new Pauta();
		Votos voto = new Votos();
		
		voto.setId(1L);
		voto.setVoto("voto");
		
		
		
		return voto;
	}
	
	

}
