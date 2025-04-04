package br.edu.ifsp.user_api.service;

import br.edu.ifsp.user_api.repository.UserRepository;
import br.edu.ifsp.user_api.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    // Casos de uso de usuário

    @Autowired
    UserRepository userRepository;

    public List<User> getUserList() {
        return userRepository.getAllUsers();
    }

    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }
}
