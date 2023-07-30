package br.senai.lab365.demospringsecutiry.Controller;

import br.senai.lab365.demospringsecutiry.DTO.TutorDto;
import br.senai.lab365.demospringsecutiry.Entity.TutorEntity;
import br.senai.lab365.demospringsecutiry.Service.TutorService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TutorController {
// Atributos
    private TutorService tutorService;



// Constructor
    @Autowired
    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

// Métodos
// Cadastro de Tutor
@PostMapping("/tutor")
    public ResponseEntity<?> cadastrarTutor(@RequestBody List<TutorEntity> tutor) {
        try {
            List<TutorEntity> tutorNovo = tutorService.cadastrarTutor(tutor);
            return ResponseEntity.status(HttpStatus.CREATED).body(tutorNovo);
        } catch (ConstraintViolationException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }


// Atualização de Tutor
    @PutMapping("/tutor/{id}")
    public TutorEntity atualizarTutor(@PathVariable Long id, @RequestBody TutorDto tutorDto) {
        return tutorService.atualizarTutor(id, tutorDto).getBody();
    }




// FIM da classe TutorController
}
