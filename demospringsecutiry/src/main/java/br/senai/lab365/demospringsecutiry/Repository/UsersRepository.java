package br.senai.lab365.demospringsecutiry.Repository;

import br.senai.lab365.demospringsecutiry.Entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {

    UsersEntity findByUsername(String username);

}
