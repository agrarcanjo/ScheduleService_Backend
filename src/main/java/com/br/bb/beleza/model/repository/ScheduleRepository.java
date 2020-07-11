package com.br.bb.beleza.model.repository;

import com.br.bb.beleza.model.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
//    @Query( value =
//            " select sum(l.valor) from Lancamento l join l.usuario u "
//                    + " where u.id = :idUsuario and l.tipo =:tipo and l.status = :status group by u " )
//    BigDecimal obterSaldoPorTipoLancamentoEUsuarioEStatus(
//            @Param("idUsuario") Long idUsuario,
//            @Param("tipo") TipoLancamento tipo,
//            @Param("status") StatusLancamento status);


}
