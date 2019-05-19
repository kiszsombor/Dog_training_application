package hu.elte.DogTrainingApplication.config;

import hu.elte.DogTrainingApplication.entities.Trainer;
import hu.elte.DogTrainingApplication.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private TrainerRepository repository;

    @Autowired
    private AutenticatedTrainer authenticated;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<Trainer> oUser = repository.findByName(name);
        if (!oUser.isPresent()) {
            throw new UsernameNotFoundException(name);
        }
        Trainer owner = oUser.get();
        authenticated.setTrainer(owner);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(owner.getRole().toString()));

        return new org.springframework.security.core.userdetails.User(owner.getName(), owner.getPassword(),
                grantedAuthorities);
    }
}
