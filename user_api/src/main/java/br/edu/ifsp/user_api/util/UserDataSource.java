package br.edu.ifsp.user_api.util;

import java.util.*;
import org.springframework.stereotype.Component;
import br.edu.ifsp.user_api.model.User;

@Component
public class UserDataSource {
    // Simula fonte de dados da aplicação
    private List<User> dataSource;

    public UserDataSource() {
        dataSource = new ArrayList<>();
    }

    public List<User> getDataSource() {
        return dataSource;
    }

    public void add(User iUser) {
        dataSource.add(iUser);
    }
}
