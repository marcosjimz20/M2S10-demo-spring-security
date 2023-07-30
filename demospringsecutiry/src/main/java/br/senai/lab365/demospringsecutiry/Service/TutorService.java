package br.senai.lab365.demospringsecutiry.Service;

import br.senai.lab365.demospringsecutiry.DTO.TutorDto;
import br.senai.lab365.demospringsecutiry.Entity.PetEntity;
import br.senai.lab365.demospringsecutiry.Entity.TutorEntity;
import br.senai.lab365.demospringsecutiry.Repository.PetRepository;
import br.senai.lab365.demospringsecutiry.Repository.TutorRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TutorService {
// Atributos
    private TutorRepository tutorRepository;
    private PetRepository petRepository;

// Constructor
    @Autowired
    public TutorService(TutorRepository tutorRepository, PetRepository petRepository) {
        this.tutorRepository = tutorRepository;
        this.petRepository = petRepository;
    }


// Métodos
// Cadastro de Tutor
    public List<TutorEntity> cadastrarTutor(List<TutorEntity> tutor) {
        try {
            return tutorRepository.saveAll(tutor);
        } catch (ConstraintViolationException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }




// Atualização de Tutor
    public ResponseEntity<TutorEntity> atualizarTutor(Long id, TutorDto tutorDto) {

    PetEntity petAtual = petRepository.findById(tutorDto.getPetId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pet não registrado"));

    TutorEntity tutorAtual = tutorRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tutor não encontrado"));

    try {

        tutorAtual.setNomeTutor(tutorDto.getNomeTutor());
        tutorAtual.setTelefone(tutorDto.getTelefone());
        tutorAtual.setPet(petAtual);

        TutorEntity tutorAtualizado = tutorRepository.save(tutorAtual);
        return ResponseEntity.ok(tutorAtualizado);
    }  catch (ConstraintViolationException ex) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
}

// FIM da classe TutorService
}
