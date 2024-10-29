package com.MyCRM.MyCRM.controllers.Implements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.MyCRM.MyCRM.models.User;
import com.MyCRM.MyCRM.repositories.IUserRepository;

@RestController
@RequestMapping("/api/users")
public class UserControllerImpl {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Qeydiyyat Metodu
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Şifrəni şifrələyin
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    // Giriş Metodu 
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) throws RuntimeException {
        User existingUser = userRepository.findByEmail(user.getEmail())
            .orElseThrow(() -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
            return ResponseEntity.ok("Giriş uğurlu");
        } else {
            return ResponseEntity.status(401).body("Yanlış şifrə");
        }
    }
}