package br.senai.lab365.demospringsecutiry.Repository;

import br.senai.lab365.demospringsecutiry.Entity.TutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<TutorEntity, Long> {
}
