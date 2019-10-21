package br.com.appointment.appointment.repository;

import br.com.appointment.appointment.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    /* padrão do JPA*/
    List<Topico> findByCurso_Nome(String nomeCurso);

    /*customizada*/
    @Query("select t from  Topico t where  t.curso.nome= :nomeCurso2")
    List<Topico> carregarPelonomeDoCurso(@Param("nomeCurso2") String nomeCurso);
}
