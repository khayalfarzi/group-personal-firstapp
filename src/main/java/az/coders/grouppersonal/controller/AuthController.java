package az.coders.grouppersonal.controller;

import az.coders.grouppersonal.model.JwtResponse;
import az.coders.grouppersonal.model.LoginRequest;
import az.coders.grouppersonal.model.MessageResponse;
import az.coders.grouppersonal.model.SignupRequest;
import az.coders.grouppersonal.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/signin")
    public JwtResponse authenticate(@Valid @RequestBody LoginRequest loginRequest) {
        return service.authenticate(loginRequest);
    }

    @PostMapping("/signup")
    public MessageResponse register(@Valid @RequestBody SignupRequest signUpRequest) {
        return service.register(signUpRequest);
    }
}