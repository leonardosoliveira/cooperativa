package br.com.cooperativa.sessao.gerenciador.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cooperativa.sessao.gerenciador.model.Pauta;
import br.com.cooperativa.sessao.gerenciador.model.StatusPauta;
import br.com.cooperativa.sessao.gerenciador.repository.PautaRepository;

@RestController
@RequestMapping("/api/pautas")
public class PautasRest {
	
	@Autowired
	private PautaRepository pautarepository;

	@GetMapping("aguardando")
	public List<Pauta> getPautasAguardandoVoto(){
		
		Sort sort = Sort.by("dataDaPauta").descending();
		PageRequest paginacao = PageRequest.of(0,10, sort);
		
		return pautarepository.findByStatus(StatusPauta.AGUARDANDO, paginacao);
	}
	
}
