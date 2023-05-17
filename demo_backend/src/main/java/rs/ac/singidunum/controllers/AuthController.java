package rs.ac.singidunum.controllers;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.singidunum.models.AuthenticationRequestModel
import rs.ac.singidunum.models.RegisterRequestModel
import rs.ac.singidunum.models.AuthenticationResponseModel
import rs.ac.singidunum.services.AuthenticationService;

import java.io.IOException;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponseModel>register(
            @RequestBody RegisterRequestModel request ){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseModel> login(
            @RequestBody AuthenticationRequestModel request){
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refresh-token")

    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request,response);
    }


}
