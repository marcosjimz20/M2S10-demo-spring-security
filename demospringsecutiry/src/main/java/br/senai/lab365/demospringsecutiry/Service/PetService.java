package br.senai.lab365.demospringsecutiry.Service;

import br.senai.lab365.demospringsecutiry.Entity.PetEntity;
import br.senai.lab365.demospringsecutiry.Repository.PetRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
// Atributos
    private PetRepository petRepository;

// Construtor
    @Autowired

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

// Métodos

// Cadastro de Pets
    public List<PetEntity> cadastrarPet(List<PetEntity> pet) {
        try {
            return petRepository.saveAll(pet);
        } catch (ConstraintViolationException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

// Listagem de Pets
    public List<PetEntity> getAll() {
        Optional<PetEntity> by =
                this.petRepository.findById(1L);
        by.get();
        return this.petRepository.findAll();
    }


// FIM da classe PetService
}
