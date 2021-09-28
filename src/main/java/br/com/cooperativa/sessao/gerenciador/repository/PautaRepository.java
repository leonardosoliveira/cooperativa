package br.com.cooperativa.sessao.gerenciador.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cooperativa.sessao.gerenciador.model.Pauta;
import br.com.cooperativa.sessao.gerenciador.model.StatusPauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long>{
	@Cacheable("books")
	List<Pauta> findByStatus(StatusPauta status, Pageable sort);


}
