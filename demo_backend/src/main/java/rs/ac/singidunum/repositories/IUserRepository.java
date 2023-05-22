package rs.ac.singidunum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.models.UserModel;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, Integer> {

}
