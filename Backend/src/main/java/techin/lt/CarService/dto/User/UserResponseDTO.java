package techin.lt.CarService.dto.User;

import techin.lt.CarService.model.Roles;

import java.util.List;

public record UserResponseDTO(

        long id,
        String username,
        List<Roles> roles

) {
}
