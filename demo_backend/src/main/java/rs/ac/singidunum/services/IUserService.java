package rs.ac.singidunum.services;

import rs.ac.singidunum.models.UserModel;

import java.util.List;

public interface IUserService {

     List<UserModel> getAll();


     UserModel findByEmail(String email);

    UserModel Create(UserModel model);
}
