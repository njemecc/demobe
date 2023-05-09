package rs.ac.singidunum.controllers;


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
    @CrossOrigin()
    public List<UserModel> getAll()
    {
        return iUserService.getAll();
    }

    @PostMapping("create")
    public UserModel Create(String firstName,String lastName,String email)
    {
        UserModel model = new UserModel();
        model.setFirstName(firstName);
        model.setLastName(lastName);
        model.setEmail(email);
        return iUserService.Create(model);
    }
}
