package com.proyecto.crud.dao;

import com.proyecto.crud.DTO.UserDTO;
import com.proyecto.crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private RestTemplate restTemplate;
    private final String URL_API = "https://jsonplaceholder.typicode.com/users";


    @Override
    public List<User> getAllUsers() {
        ResponseEntity<List<User>> responseEntity =  restTemplate.exchange(URL_API,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {
                });
        return responseEntity.getBody();
    }
}
