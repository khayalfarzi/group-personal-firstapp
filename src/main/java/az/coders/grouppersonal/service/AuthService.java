package az.coders.grouppersonal.service;

import az.coders.grouppersonal.model.JwtResponse;
import az.coders.grouppersonal.model.LoginRequest;
import az.coders.grouppersonal.model.MessageResponse;
import az.coders.grouppersonal.model.SignupRequest;

public interface AuthService {

    JwtResponse authenticate(LoginRequest loginRequest);

    MessageResponse register(SignupRequest signUpRequest);
}
