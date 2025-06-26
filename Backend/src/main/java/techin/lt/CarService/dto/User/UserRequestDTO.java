package techin.lt.CarService.dto.User;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import techin.lt.CarService.model.Roles;

import java.util.List;

public record UserRequestDTO(


        @NotNull
        @Size(min = 2, max = 50, message = "Name needs to be minumum 1 and maximum 50 symbols")
        String username,

        @NotNull
        @Pattern(
                regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,16}$",
                message = "Password must contain one digit, one lowercase, one uppercase, one special character (!@#$%^&*), and be 8–16 characters long"
        )
        String password,

        List<Roles> roles

) {
}
