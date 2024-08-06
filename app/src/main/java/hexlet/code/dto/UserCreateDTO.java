package hexlet.code.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDTO {

    @NotNull
    @Column(unique = true)
    @Email
    private String email;

    private String firstName;

    private String lastName;

    @NotNull
    @Size(min = 3, max = 100)
    private String password;
}
