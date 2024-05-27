package com.nhan.demosecurity;

import com.nhan.demosecurity.entities.Role;
import com.nhan.demosecurity.entities.User;
import com.nhan.demosecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoSecurityApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoSecurityApplication.class, args);
    }
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User adminAccount = userRepository.findByRole(Role.ADMIN);
        if (adminAccount == null) {
            User admin = new User();
            admin.setEmail("admin@gmail.com");
            admin.setFirstName("Tran");
            admin.setLastName("Nhan");
            admin.setRole(Role.ADMIN);
            admin.setPhoneNumber("0123456789");
            admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepository.save(admin);
        }


    }
}
