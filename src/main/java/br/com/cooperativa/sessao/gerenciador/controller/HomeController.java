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
@RequestMapping("/home")
public class HomeController {

	//Para o Spring injetar uma dependencia deve colocar o “AutoWired”,
	@Autowired
	private PautaRepository pautaRepository;

	@GetMapping
	public String home(Model model) {
		
		Sort sort = Sort.by("dataDaPauta").descending();
		PageRequest paginacao = PageRequest.of(0,10, sort);
		List<Pauta> pautas = pautaRepository.findByStatus(StatusPauta.AGUARDANDO, paginacao);
		model.addAttribute("pautas", pautas);
		return "home";
	}
	

}
