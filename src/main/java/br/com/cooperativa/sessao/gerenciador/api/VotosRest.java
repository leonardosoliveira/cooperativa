package br.com.cooperativa.sessao.gerenciador.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cooperativa.sessao.gerenciador.dto.RequisicaoNovoVoto;
import br.com.cooperativa.sessao.gerenciador.model.Pauta;
import br.com.cooperativa.sessao.gerenciador.model.Votos;
import br.com.cooperativa.sessao.gerenciador.repository.PautaRepository;

@RestController
@RequestMapping("/api/votos")
public class VotosRest {
	
	@Autowired
	private PautaRepository pautaRepository;
	
	@PostMapping
	public Votos criaVoto(@RequestBody RequisicaoNovoVoto requisicao) {
		Optional<Pauta> pautaBuscada = pautaRepository.findById(requisicao.getPautaId());
		if(!pautaBuscada.isPresent()) {
			return null;
		}
		
		Pauta pauta = pautaBuscada.get();
		
		Votos novo = requisicao.toVoto();
		novo.setPauta(pauta);
		pauta.getVotos().add(novo);
		
		pautaRepository.save(pauta);
		return novo;
		
		
	}
}
