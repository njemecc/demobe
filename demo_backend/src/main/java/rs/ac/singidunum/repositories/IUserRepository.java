package rs.ac.singidunum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rs.ac.singidunum.models.UserModel;

public interface IUserRepository extends JpaRepository<UserModel, Integer> {

}
