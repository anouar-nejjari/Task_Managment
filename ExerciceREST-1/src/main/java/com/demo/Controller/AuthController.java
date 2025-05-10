package com.demo.Controller;

import org.hibernate.Session.LockRequest;
import org.springframework.aot.hint.annotation.RegisterReflection;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterReflection req) {
		return null;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@SuppressWarnings("deprecation") @RequestBody LockRequest req) {
		return null;
    }
}
