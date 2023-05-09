package rs.ac.singidunum.services;


import org.springframework.stereotype.Service;
import rs.ac.singidunum.models.UserModel;
import rs.ac.singidunum.repositories.IUserRepository;

import java.util.List;

@Service()
public class UserService implements IUserService{

    private IUserRepository iUserRepository;

    public UserService(IUserRepository iUserRepository){
        this.iUserRepository = iUserRepository;
    }
    @Override
    public List<UserModel> getAll() {

        return iUserRepository.findAll();
    }

    @Override
    public UserModel Create(UserModel model) {
        return iUserRepository.save(model);
    }
}
