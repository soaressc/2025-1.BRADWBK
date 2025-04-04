package br.edu.ifsp.user_api.repository;

import br.edu.ifsp.user_api.util.UserDataSource;
import br.edu.ifsp.user_api.model.User;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {
    // Operações a fonte de dados
    @Autowired
    UserDataSource uDataSource;

    public List<User> getAllUsers() {
        return uDataSource.getDataSource();
    }

    public User getUserById(int id) {
        List<User> lUsers = getAllUsers();
        return lUsers.stream()
                    .filter(t -> t.getId() == id)
                    .findFirst()
                    .orElse(null);
    }
}
