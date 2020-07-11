package com.br.bb.beleza.model.repository;

import com.br.bb.beleza.model.entity.Person;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
    Optional<Person> findByIdentifier(String id);
    boolean existsByEmail(String email);

/*
    @Query( value =
            "select sum(l.valor)" +
                    "from Lancamento l " +
                    "join l.usuario u " +
                    "where u.id = :idUsuario " +
                    "and l.tipo =:tipo " +
                    "and l.status = :status group by u " )
    BigDecimal obterSaldoPorTipoLancamentoEUsuarioEStatus(
            @Param("name") TipoLancamento tipo,
            @Param("status") StatusLancamento status); */

}
