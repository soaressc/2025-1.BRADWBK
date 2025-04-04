package br.edu.ifsp.user_api.util;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import br.edu.ifsp.user_api.model.User;

@Component
public class UserInitDataSource implements CommandLineRunner {
    // lógica para inicializar o DataSource
    @Autowired
    UserDataSource uDataSource;
    
    int countId = 0;
    @Override
    public void run(String... args) throws Exception {
        Stream.generate(() -> {
            User iUser = new User();
            iUser.setId(++countId);
            iUser.setLogin("IFSP" + iUser.getId());
            iUser.setPassword("1234");
            uDataSource.add(iUser);
            return iUser;
        }).limit(10);
    }
}
