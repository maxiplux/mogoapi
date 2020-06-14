package api.mongodb.livemarket.business.mogoapi.services.impl;

import api.mongodb.livemarket.business.mogoapi.models.users.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public interface UserDetailsServiceExtra extends UserDetailsService {
    @Transactional
    User findByUsername(String username) throws UsernameNotFoundException;
}
