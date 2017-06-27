package com.example.fitpal.controllers;

import com.example.fitpal.dtos.LoginDto;
import com.example.fitpal.dtos.NewUserDto;
import com.example.fitpal.dtos.UserDto;
import com.example.fitpal.exceptions.EntityNotFoundException;
import com.example.fitpal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> findAll() { return userService.findAll(); }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserDto findOne(@PathVariable("id") Long id) { return userService.findOne(id); }

    @RequestMapping(value = "/by-login/{login}", method = RequestMethod.GET)
    public UserDto findByLogin(@PathVariable String login) { return userService.findByLogin(login); }

    @RequestMapping(method = RequestMethod.POST)
    public UserDto create(@RequestBody NewUserDto newUserDto) { return userService.save(newUserDto); }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public UserDto edit(@PathVariable("id") Long id, @RequestBody UserDto userDto)
            throws EntityNotFoundException
    { return userService.edit(userDto); }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable("id") Long id)
            throws EntityNotFoundException
    { userService.remove(id); }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public boolean authUser(@RequestBody LoginDto loginDto) {
        try {
            return userService.authenticate(loginDto);
        } catch (EntityNotFoundException e) {
            throw e;
        }
    }
}
