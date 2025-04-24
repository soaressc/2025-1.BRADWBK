package br.edu.ifsp.user_api.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import br.edu.ifsp.user_api.model.User;
import br.edu.ifsp.user_api.util.UserDataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class UserRepository {
    // Operações a fonte de dados 

  private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);

    @Autowired
    UserDataSource uDataSource;

    public List<User> getAllUsers(){
        return uDataSource.getDataSource();
    }

    public User getUserById(int id){
        List<User> users = getAllUsers();
        return users.stream()
                    .filter(t -> t.getId() == id)
                    .findFirst()
                    .orElse(null);
    }

    public void updateUser(int id, User userData) {
      try {
        if (userData == null) {
            logger.warn("Dados de atualização nulos para usuário com id {}", id);
            return;
        }

        User userToUpdate = getUserById(id);
        if (userToUpdate == null) {
            logger.warn("Usuário com id {} não encontrado para atualização.", id);
            return;
        }
      userToUpdate.setLogin(userData.getLogin());
      userToUpdate.setPassword(userData.getPassword());
      } catch(Exception e) {
        logger.error("Erro ao atualizar o usuário com id {}: {}", id, e.getMessage());
        throw e;
      }
    }

    public void deleteUserById(int id) {
      try {
        User userToRemove = getUserById(id);
        if (userToRemove == null) {
    logger.warn("Tentativa de deletar usuário inexistente com id {}", id);
    return;
}
        uDataSource.getDataSource().remove(userToRemove);
      } catch(Exception e) {
        logger.error("Erro ao excluir o usuário com id {}: {}", id, e.getMessage());
      }
    }
}