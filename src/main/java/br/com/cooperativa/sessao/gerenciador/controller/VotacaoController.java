package br.com.cooperativa.sessao.gerenciador.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cooperativa.sessao.gerenciador.dto.RequisicaoNovoVoto;
import br.com.cooperativa.sessao.gerenciador.model.Pauta;
import br.com.cooperativa.sessao.gerenciador.model.StatusPauta;
import br.com.cooperativa.sessao.gerenciador.model.Votos;
import br.com.cooperativa.sessao.gerenciador.repository.PautaRepository;

@Controller
@RequestMapping("voto")
public class VotacaoController {
	
	@Autowired
	private PautaRepository pautaRepository;

	@GetMapping
	public String getFormularioParaVoto(Model model) {
		Sort sort = Sort.by("dataDaPauta").descending();
		PageRequest paginacao = PageRequest.of(0,40, sort);
		List<Pauta> pautas = pautaRepository.findByStatus(StatusPauta.AGUARDANDO, paginacao);
		model.addAttribute("pautas", pautas);
		return "voto/home";
	}
	
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoVoto requisicao, BindingResult result) {
		
		if(result.hasErrors()) {
			return "voto";
		}
		
		System.out.print(requisicao.getPautaId() +" " + requisicao.getVoto());
		Pauta pauta = new Pauta();
		
		Votos voto =requisicao.toVoto();
		
		//pautaRepository.save(pauta);
		return "redirect:/home";
	}
	

}
