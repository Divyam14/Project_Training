package com.divyam.rest.webservices.restfulwebservices.controllers;

import com.divyam.rest.webservices.restfulwebservices.dao.UserDaoService;
import com.divyam.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.divyam.rest.webservices.restfulwebservices.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    @Autowired
    UserDaoService userDao;
    //retrieveAllUsers

    @GetMapping(path = "/users")
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public EntityModel<User> findUser(@PathVariable int id) {
        User user = userDao.findOne(id);
        if (user == null) {
            throw new UserNotFoundException("id = " + id);
        }
        EntityModel<User> model = EntityModel.of(user);

        WebMvcLinkBuilder linkToUsers = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllUsers());

        model.add(linkToUsers.withRel("all_users"));

        return model;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userDao.saveUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        //Uri can be seen in headers of response with name Location
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "users/{id}")
    public User deleteById(@PathVariable Integer id) {
        User deletedUser = userDao.deleteById(id);
        if (deletedUser == null) {
            throw new UserNotFoundException("id = " + id);
        }
        return deletedUser;
    }
}
