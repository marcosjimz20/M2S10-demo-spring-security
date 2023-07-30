package br.senai.lab365.demospringsecutiry.Service;

import br.senai.lab365.demospringsecutiry.Entity.UsersEntity;
import br.senai.lab365.demospringsecutiry.Repository.UsersRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements UserDetailsService {
    private UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsersEntity byUsername = this.usersRepository.findByUsername(username);
        if (byUsername == null) {
            throw new UsernameNotFoundException("Nao existe esse usuário!");
        }
        return new User(byUsername.getUsername(), byUsername.getPassword(), byUsername.getAuthorities());
    }
}
