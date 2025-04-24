package br.edu.ifsp.user_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import br.edu.ifsp.user_api.model.User;
import br.edu.ifsp.user_api.service.UserService;


@RestController
@RequestMapping("api")
public class UserController {
    // Definição da API REST

    @Autowired
    UserService userService;

    @GetMapping("user")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getUserList();
        return ResponseEntity.ok().body(users);
    }    

    @GetMapping("user/{id}")
    public ResponseEntity<User> getOneUser(
        @PathVariable int id
    ) {
        User user = userService.getUserById(id);
        if(user != null)
            return ResponseEntity.ok().body(user); // Status 200
        return ResponseEntity.notFound().build(); // Status 404
    }

    @PutMapping("user/{id}") //MÉTODO PUT
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
      User userToUpdate = userService.getUserById(id);
      if(userToUpdate == null) {
        return ResponseEntity.notFound().build(); //404
      }
      userService.updateUser(id, user);
      return ResponseEntity.ok().body(user); //200
    }

    @DeleteMapping("user/{id}") //MÉTODO DELETE
    public ResponseEntity<Void> deleteUser(@PathVariable int id) {
      User user = userService.getUserById(id);
      if(user == null) {
        return ResponseEntity.notFound().build(); //400
      }
      userService.deleteUser(id);
      return ResponseEntity.noContent().build(); //204 not found pro excluído
    }
}
