package br.senai.lab365.demospringsecutiry.Repository;

import br.senai.lab365.demospringsecutiry.Entity.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Long> { }
