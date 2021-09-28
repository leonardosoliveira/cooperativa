package br.com.cooperativa.sessao.gerenciador.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cooperativa.sessao.gerenciador.dto.RequisicaoNovaPauta;
import br.com.cooperativa.sessao.gerenciador.model.Pauta;
import br.com.cooperativa.sessao.gerenciador.repository.PautaRepository;

@Controller
@RequestMapping("pauta")
public class PautaController {
	
	@Autowired
	private PautaRepository pautaRepository;

	@GetMapping("formulario")
	public String formulario(RequisicaoNovaPauta requisicao) {
		return "pauta/formulario";
	}
	
	@PostMapping("nova")
	public String nova(@Valid RequisicaoNovaPauta requisicao, BindingResult result) {
		
		if(result.hasErrors()) {
			return "pauta/formulario";
		}
		Pauta pauta = requisicao.toPauta();
		pautaRepository.save(pauta);
		return "redirect:/home";
	}
}
