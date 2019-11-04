package br.com.appointment.appointment.controller.dto;

import br.com.appointment.appointment.model.Topico;

public class AtividadeDto {
    private String nomeProjeto;
    private String fase;
    private String atividade;

    public AtividadeDto(AtividadeDto atividade) {
        this.nomeProjeto = atividade.getNomeProjeto();
        this.atividade = atividade.getAtividade();
        this.fase = atividade.getFase();
    }


    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }


}
