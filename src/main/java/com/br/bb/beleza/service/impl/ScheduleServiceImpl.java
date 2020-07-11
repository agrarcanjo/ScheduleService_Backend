package com.br.bb.beleza.service.impl;

import com.br.bb.beleza.model.entity.Schedule;
import com.br.bb.beleza.model.repository.ScheduleRepository;
import com.br.bb.beleza.service.ScheduleService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	
	private ScheduleRepository repository;
	
	public ScheduleServiceImpl(ScheduleRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public Schedule save(Schedule schedule) {
		verify(schedule);
		//schedule.setStatus(StatusLancamento.PENDENTE);
		return repository.save(schedule);
	}

	@Override
	@Transactional
	public Schedule update(Schedule schedule) {
		Objects.requireNonNull(schedule.getId());
		verify(schedule);
		return repository.save(schedule);
	}

	@Override
	@Transactional
	public void delete(Schedule schedule) {
		Objects.requireNonNull(schedule.getId());
		repository.delete(schedule);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Schedule> find(Schedule schedule) {
		Example example = Example.of( schedule,
				ExampleMatcher.matching()
					.withIgnoreCase()
					.withStringMatcher(StringMatcher.CONTAINING) );
		
		return repository.findAll(example);
	}

	@Override
	public void updateStatus(Schedule schedule) {
		//schedule.setStatus(status);
		update(schedule);
	}

	@Override
	public void verify(Schedule schedule) {
		
		/*if(schedule.getDescricao() == null || lancamento.getDescricao().trim().equals("")) {
			throw new RegraNegocioException("Informe uma Descrição válida.");
		}

		if(lancamento.getMes() == null || lancamento.getMes() < 1 || lancamento.getMes() > 12) {
			throw new RegraNegocioException("Informe um Mês válido.");
		}

		if(lancamento.getAno() == null || lancamento.getAno().toString().length() != 4 ) {
			throw new RegraNegocioException("Informe um Ano válido.");
		}

		if(lancamento.getUsuario() == null || lancamento.getUsuario().getId() == null) {
			throw new RegraNegocioException("Informe um Usuário.");
		}

		if(lancamento.getValor() == null || lancamento.getValor().compareTo(BigDecimal.ZERO) < 1 ) {
			throw new RegraNegocioException("Informe um Valor válido.");
		}

		if(lancamento.getTipo() == null) {
			throw new RegraNegocioException("Informe um tipo de Lançamento.");
		}*/
	}

	@Override
	public Optional<Schedule> findById(Long id) {
		return repository.findById(id);
	}

	/*@Transactional(readOnly = true)
	public BigDecimal obterSaldoPorUsuario(Long id) {
		
		//BigDecimal receitas = repository.obterSaldoPorTipoLancamentoEUsuarioEStatus(id, TipoLancamento.RECEITA, StatusLancamento.EFETIVADO);
		//BigDecimal despesas = repository.obterSaldoPorTipoLancamentoEUsuarioEStatus(id, TipoLancamento.DESPESA, StatusLancamento.EFETIVADO);
		
		if(receitas == null) {
			receitas = BigDecimal.ZERO;
		}
		
		if(despesas == null) {
			despesas = BigDecimal.ZERO;
		}
		
		return receitas.subtract(despesas);
	}*/

}
