package br.com.appointment.appointment.controller;


import br.com.appointment.appointment.controller.dto.TopicoDto;
import br.com.appointment.appointment.model.Curso;
import br.com.appointment.appointment.model.Topico;
import br.com.appointment.appointment.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @RequestMapping("/topicos")
    public List<TopicoDto> lista(String nomeCurso) {

        if (nomeCurso == null) {
            List<Topico> topicos = this.topicoRepository.findAll();
            return TopicoDto.converter(topicos);
        } else {
            List<Topico> topicos = this.topicoRepository.findByCurso_Nome(nomeCurso);
            return TopicoDto.converter(topicos);
        }

    }

}