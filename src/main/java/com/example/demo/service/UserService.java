package com.example.demo.service;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Kayıt işlemi
    public User registerUser(User user) throws Exception {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new Exception("Bu email zaten kayıtlı!");
        }
        return userRepository.save(user);
    }

    // Giriş işlemi
    public User loginUser(String email, String password) throws Exception {
        System.out.println("Login email: " + email);
        User user = userRepository.findByEmail(email);
        if (user == null || !user.getPassword().equals(password)) {
            throw new Exception("Email veya şifre hatalı!");
        }
        return user;
    }
}
