package br.com.cooperativa.sessao.gerenciador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cooperativa.sessao.gerenciador.model.Pauta;
import br.com.cooperativa.sessao.gerenciador.model.StatusPauta;
import br.com.cooperativa.sessao.gerenciador.repository.PautaRepository;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	@Autowired
	private PautaRepository pautaRepository;
	
	@GetMapping("/pauta")
	public String home(Model model) {
		List<Pauta> pautas = pautaRepository.findAll();
		model.addAttribute("pautas", pautas);
		return "usuario/home";
	}
	
	//recebe por parametro da requisição o status
	@GetMapping("/pauta/{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {
		Sort sort = Sort.by("dataDaPauta").descending();
		PageRequest paginacao = PageRequest.of(0,40, sort);
		List<Pauta> pautas = pautaRepository.findByStatus(StatusPauta.valueOf(status.toUpperCase()), paginacao);
		model.addAttribute("pautas", pautas);
		return "usuario/home";
	}
	
	//metodo utilizado para tratamento de erro, caso o usuario tente acessar uma URL invalida irá direcionar para a home
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:usuario/home";
	}

}



