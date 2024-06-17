package com.gdw888.nbastatstrackerserver.controller;

import com.gdw888.nbastatstrackerserver.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");

        String token;
        if ("admin".equals(username) && "admin".equals(password)) {
            token = jwtUtil.generateToken(username, "ADMIN");
        } else {
            token = jwtUtil.generateToken(username, "");
        }

        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return ResponseEntity.ok(response);
    }
}
