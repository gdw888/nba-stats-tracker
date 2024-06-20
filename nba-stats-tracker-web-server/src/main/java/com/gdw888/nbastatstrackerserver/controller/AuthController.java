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
        String token = "";
        // Check if the username and password are not "admin"
        if (!("admin".equalsIgnoreCase(username) && "admin".equalsIgnoreCase(password))) {
            token = jwtUtil.generateToken(username, "");
            // Return an unauthorized error response if the check fails
            //return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized: Incorrect username or password");
        }else{
            // If the credentials are correct, generate the token
            token = jwtUtil.generateToken(username, "ADMIN");
        }


        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        return ResponseEntity.ok(response);
    }
}
