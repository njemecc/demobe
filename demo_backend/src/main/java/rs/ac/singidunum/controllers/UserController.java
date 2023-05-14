package rs.ac.singidunum.controllers;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.models.UserModel;
import rs.ac.singidunum.services.IUserService;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private IUserService iUserService;

    public UserController(IUserService iUserService){
        this.iUserService = iUserService;
    }

    @GetMapping("home")
    public String Home()
    {
        return "Home page";
    }

    @GetMapping("getAllUsers")
    @CrossOrigin("*")
    public List<UserModel> getAll()
    {
        return iUserService.getAll();
    }

    @PostMapping("create")

    public ResponseEntity<?>Create(@RequestBody @Valid UserModel model, BindingResult result)
    {
        if (result.hasErrors())
        {
            return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(iUserService.Create(model),HttpStatus.OK);
    }

//   public UserModel Create(String firstName,String lastName,String email)
//    {
//
//
//       UserModel model = new UserModel();
//
//        model.setLastName(lastName);
//        model.setFirstName(firstName);
//        model.setEmail(email);
//
//
//
//
//        return iUserService.Create(model);
//    }
}
