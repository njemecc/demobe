package rs.ac.singidunum.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @GetMapping
    public String get() {
        return "get employee method";
    }

    @PostMapping
    public String post() {
        return "post";
    }

    @PutMapping
    public String put() {
        return "put";
    }

    @DeleteMapping
    public String delete() {
        return "delete";
    }
}
