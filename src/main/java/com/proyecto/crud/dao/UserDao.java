package com.proyecto.crud.dao;

import com.proyecto.crud.DTO.UserDTO;
import com.proyecto.crud.entity.User;

import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();
 }
