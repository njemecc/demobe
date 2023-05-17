package rs.ac.singidunum.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.ac.singidunum.enums.TokenTypeEnum;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TokenModel {

    @Id
    @GeneratedValue
    public Integer id;

    @Column(unique = true)
    public String token;

    @Enumerated(EnumType.STRING)
    public TokenTypeEnum tokenType = TokenTypeEnum.BEARER;

    public boolean revoked;

    public boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public UserModel user;

}
