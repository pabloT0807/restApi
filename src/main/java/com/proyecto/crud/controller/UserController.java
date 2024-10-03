package com.proyecto.crud.controller;

import com.proyecto.crud.dao.UserDao;
import com.proyecto.crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/obtenerListaUsuarios")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> userDTOS = userDao.getAllUsers();
        return ResponseEntity.ok(userDTOS);
    }


}
