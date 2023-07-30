package br.senai.lab365.demospringsecutiry.DTO;


import org.antlr.v4.runtime.misc.NotNull;

public class TutorDto {
// Atributos
    private String nomeTutor;
    private String telefone;

    @NotNull
    private Long petId;


// Getters e Setters
    public String getNomeTutor() {
        return nomeTutor;
    }

    public void setNomeTutor(String nomeTutor) {
        this.nomeTutor = nomeTutor;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }


// FIM da classe TutorDto
}
