package br.com.appointment.appointment.controller;


import br.com.appointment.appointment.controller.dto.TopicoDto;
import br.com.appointment.appointment.model.Curso;
import br.com.appointment.appointment.model.Topico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicosController {

    @RequestMapping("/topicos")
    public List<TopicoDto> lista() {
        Topico topico = new Topico("Dúvida teste ", "Curosfdfsdf", new Curso("Spring", "Programação"));
        return TopicoDto.converter(Arrays.asList(topico, topico, topico));
    }

}