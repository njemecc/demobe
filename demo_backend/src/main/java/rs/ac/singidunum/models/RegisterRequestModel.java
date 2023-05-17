package rs.ac.singidunum.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.ac.singidunum.enums.RoleEnum;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequestModel {


   private String firstName;
   private String lastName;
   private String email;
   private String password;
   private RoleEnum role;
}
