package br.senai.lab365.demospringsecutiry.Entity;

import jakarta.persistence.*;

@Entity
public class TutorEntity {
// Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeTutor;
    private String telefone;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private PetEntity pet;

// Constructor
    public TutorEntity() {
    }

    public TutorEntity(Long id, String nomeTutor, String telefone, PetEntity pet) {
        this.id = id;
        this.nomeTutor = nomeTutor;
        this.telefone = telefone;
        this.pet = pet;
    }

// Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public PetEntity getPet() {
        return pet;
    }

    public void setPet(PetEntity pet) {
        this.pet = pet;
    }


// FIM da classe TutorEntity
}
