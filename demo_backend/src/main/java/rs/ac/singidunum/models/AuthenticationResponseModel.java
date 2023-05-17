package rs.ac.singidunum.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponseModel {
    @JsonProperty("acces_token")
    private String accessToken;

    @JsonProperty("refresh_token")
    private String refreshToken;
}
