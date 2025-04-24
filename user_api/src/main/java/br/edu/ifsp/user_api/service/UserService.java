package br.edu.ifsp.user_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifsp.user_api.model.User;
import br.edu.ifsp.user_api.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService {

    // Casos de uso de usuário

  private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    public List<User> getUserList(){
        return userRepository.getAllUsers();
    }

    public User getUserById(int id){
        return userRepository.getUserById(id);
    }

    public void updateUser(int id, User user) {
        User existingUser = userRepository.getUserById(id);
        if (existingUser == null) {
          logger.error("Usuário com id {} não encontrado para atualização.", id);
          return;
        }
        userRepository.updateUser(id, user);
    }

    public void deleteUser(int id) {
        userRepository.deleteUserById(id);
    }
}