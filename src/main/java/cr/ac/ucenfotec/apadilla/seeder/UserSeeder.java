package cr.ac.ucenfotec.apadilla.seeder;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import cr.ac.ucenfotec.apadilla.logic.entity.rol.Role;
import cr.ac.ucenfotec.apadilla.logic.entity.rol.RoleEnum;
import cr.ac.ucenfotec.apadilla.logic.entity.rol.RoleRepository;
import cr.ac.ucenfotec.apadilla.logic.entity.user.User;
import cr.ac.ucenfotec.apadilla.logic.entity.user.UserRepository;

import java.util.Optional;

@Component
@DependsOn("roleSeeder")
public class UserSeeder implements ApplicationListener<ContextRefreshedEvent> {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


    public UserSeeder(
            RoleRepository roleRepository,
            UserRepository  userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.createUser();
    }

    private void createUser() {
        User commonUser = new User();
        commonUser.setName("Normal");
        commonUser.setLastname("User");
        commonUser.setEmail("no.user@gmail.com");
        commonUser.setPassword("normaluser123");

        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.USER);
        Optional<User> optionalUser = userRepository.findByEmail(commonUser.getEmail());

        if (optionalRole.isEmpty() || optionalUser.isPresent()) {
            return;
        }

        User user = new User();
        user.setName(commonUser.getName());
        user.setLastname(commonUser.getLastname());
        user.setEmail(commonUser.getEmail());
        user.setPassword(passwordEncoder.encode(commonUser.getPassword()));
        user.setRole(optionalRole.get());

        userRepository.save(user);
    }
}
