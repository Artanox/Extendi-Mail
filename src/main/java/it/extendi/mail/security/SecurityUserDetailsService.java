package it.extendi.mail.security;

import it.extendi.mail.dao.UserDAO;
import it.extendi.mail.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    public SecurityUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDAO user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Email " + email +" not found"));
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                getGrantedAuthority(user));
    }

    private Collection<GrantedAuthority> getGrantedAuthority(UserDAO user){
        Collection<GrantedAuthority> grantedAuthorityCollection = new ArrayList<>();
        if(user.getRole().getName().equalsIgnoreCase("admin"))
            grantedAuthorityCollection.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        grantedAuthorityCollection.add((new SimpleGrantedAuthority("ROLE_USER")));
        return grantedAuthorityCollection;
    }
}
