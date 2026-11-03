package hh.backend.boulderbuddy.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hh.backend.boulderbuddy.domain.AppUser;
import hh.backend.boulderbuddy.domain.AppUserRepository;

@Service 
public class UserService implements UserDetailsService {

    private final AppUserRepository repository;

    public UserService(AppUserRepository appUserRepository) {
        this.repository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser currentUser = repository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.
                           User(
                           username, 
                           currentUser.getPassword(), 
                           AuthorityUtils.createAuthorityList(currentUser.getRole()));
        
        return user;
    }


}
