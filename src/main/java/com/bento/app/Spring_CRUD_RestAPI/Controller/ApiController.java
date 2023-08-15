package com.bento.app.Spring_CRUD_RestAPI.Controller;

import com.bento.app.Spring_CRUD_RestAPI.Model.User;
import com.bento.app.Spring_CRUD_RestAPI.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {
    @Autowired
    private UserRepo userRepo;
@GetMapping(value= "/")
    public String getPage(){

        return "Welcome";
    }

    @GetMapping(value= "/users")
    public List<User> getUsers(){

    return userRepo.findAll();
    }

    @PostMapping(value= "/save")
    public String saveUser(User user){
    userRepo.save(user);
    return "Saved...";
    }

    @PostMapping(value= "update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){

    User updatedUser = userRepo.findById(id).get();
    updatedUser.setFirstName(user.getFirstName());
    updatedUser.setLastName(user.getLastName());
    updatedUser.setOccupation(user.getOccupation());
    updatedUser.setAge(user.getAge());
    userRepo.save(updatedUser);
    return "Updated";
    }
    @DeleteMapping(value="update/{id}")

    public String deleteUser(@PathVariable long id){

        User deletetedUser = userRepo.findById(id).get();
        userRepo.delete(deletetedUser);
        return "Deleted user with id: " +id;

    }

}



