package api.mongodb.livemarket.business.mogoapi.config;

import api.mongodb.livemarket.business.mogoapi.models.users.Role;
import api.mongodb.livemarket.business.mogoapi.models.users.RoleName;
import api.mongodb.livemarket.business.mogoapi.models.users.User;
import api.mongodb.livemarket.business.mogoapi.repository.RoleRepository;
import api.mongodb.livemarket.business.mogoapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Component
@Transactional
public class DataLoader implements ApplicationRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;




    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.createUser();

    }

    private void createUser() {

        User user = new User();
        if (!this.userRepository.existsByUsername("admin"))
        {
            roleRepository.save(Role.builder().name(RoleName.ROLE_USER.name()).build());
            roleRepository.save(Role.builder().name(RoleName.ROLE_ADMIN.name()).build());
            roleRepository.save(Role.builder().name(RoleName.ROLE_MODERATOR.name()).build());
            user.setPassword(passwordEncoder().encode("12345"));
            user.setUsername("admin");
            user.setEnabled(true);
            user.setRoles(this.roleRepository.findAll().stream().collect(Collectors.toSet()) );
            this.userRepository.save(user);

        }



    }

}
