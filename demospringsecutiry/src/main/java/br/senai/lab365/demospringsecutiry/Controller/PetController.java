package br.senai.lab365.demospringsecutiry.Controller;

import br.senai.lab365.demospringsecutiry.Entity.PetEntity;
import br.senai.lab365.demospringsecutiry.Service.PetService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PetController {
// Atributos
    private PetService petService;

// Constructor
    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }

// Métodos

//Cadastro de Pets
    @PostMapping("/pets")
    public ResponseEntity<?> cadastrarPet(@RequestBody List<PetEntity> pet) {
        try {
            List<PetEntity> petNovo = petService.cadastrarPet(pet);
            return ResponseEntity.status(HttpStatus.CREATED).body(petNovo);
        } catch (ConstraintViolationException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }


// Listagem de Pets
    @GetMapping("/pets")
    public List<PetEntity> getAll() {
        return this.petService.getAll();
    }


    // FIM da classe PetController
}
