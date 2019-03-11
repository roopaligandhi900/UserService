package com.stackroute.userservice.controller;


import com.stackroute.muzix.service.MusixService;
import com.stackroute.muzix.domain.Musix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class MusixController {


    private MusixService musixService;
    @Autowired

    public MusixController(MusixService musixService) {

        this.musixService = musixService;
    }

    @PostMapping("/musix")
    public ResponseEntity<Musix> savedUser(@RequestBody Musix user){

        Musix savedMusix = musixService.saveMusix(musix);
        return new ResponseEntity<Musix>(savedMusix, HttpStatus.OK);

    }

    @GetMapping("Musixs")

    public ResponseEntity<?>getAllMusix(){

        List<Musix> getUser=musixService.getAllUser();

        return new ResponseEntity<List<Musix>>(getUser,HttpStatus.OK);

    }

    @GetMapping("/user/{id}")

    public ResponseEntity<?>getUserById(@PathVariable("id") int id){

        User getId=userService.getUserById(id);

        return new ResponseEntity<User>(getId,HttpStatus.OK);

    }

    @PutMapping("user/{id}")

    public ResponseEntity<User>updateUser(@RequestBody User user,@PathVariable int id)

    {

        User updatedUser=userService.updateUser(user,id);

        return new ResponseEntity<User>(updatedUser, HttpStatus.OK);

    }

    @DeleteMapping("user/{id}")

    public ResponseEntity<?>deleteUser(@PathVariable("id") int id){

        userService.deleteUser(id);

        return new ResponseEntity<List<User>>(userService.getAllUser(),HttpStatus.OK);

    }
}
