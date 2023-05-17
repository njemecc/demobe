package rs.ac.singidunum.repositories;

import org.apache.el.parser.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import rs.ac.singidunum.models.TokenModel;

import java.util.List;
import java.util.Optional;

public class ITokenRepository  extends JpaRepository<TokenModel,Integer> {


    @Query(value = """

select t from TokenModel t inner join UserModel u\s 
on t.user.id = u.id\s 
where u.id = :id and (t.expired = false or t.revoked = false)\s 
""")
    List<TokenModel> findAllByValidTokenByUser(Integer id);

    public Optional<TokenModel> findByToken(String token);

}
