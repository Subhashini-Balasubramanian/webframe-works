package com.example.signin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.signin.model.Signin;
import com.example.signin.service.SigninService;

@RestController
@RequestMapping("/api")
public class SigninController {
    @Autowired
    private final SigninService signinService;

    public SigninController(SigninService signinService) {
        this.signinService = signinService;
    }

    @PostMapping("/signin")
    // insert the data
    public ResponseEntity<Signin> createSignin(@RequestBody Signin signin) {
        Signin createSignin = signinService.createSignin(signin);
        return new ResponseEntity<>(createSignin, HttpStatus.CREATED);
    }

    @GetMapping("/signin")
    public ResponseEntity<List<Signin>> getAllSignin() {
        List<Signin> signin = signinService.getAllSignin();
        return new ResponseEntity<>(signin, HttpStatus.OK);
    }

    @GetMapping("/signin/{signinId}")
    public ResponseEntity<Signin> getById(@PathVariable int signinId) {
        Signin signin = signinService.getSigninId(signinId);
        if (signin != null) {
            return new ResponseEntity<>(signin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

@PutMapping("/signin/{id}")
    public ResponseEntity<Signin> update(@PathVariable int id, @RequestBody Signin signin) {
        return new ResponseEntity<>(signinService.update(id, signin), HttpStatus.OK);
    }

    @DeleteMapping("/signin/{signinId}")
    public ResponseEntity<Void> delete(@PathVariable int signinId) {
        signinService.delete(signinId);
        return ResponseEntity.noContent().build();
    }


}
@GetMapping("/{signinName}")
    public ResponseEntity<List<Signin>> sortTheRecords(@PathVariable String signinName) {
        List<Signin> field = signinService.sortTheRecords(signinName);
        return new ResponseEntity<>(field, HttpStatus.OK);
    }