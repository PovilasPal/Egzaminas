package techin.lt.CarService.dto.User;

import techin.lt.CarService.dto.login.UserLoginResponseDTO;
import techin.lt.CarService.model.Roles;
import techin.lt.CarService.model.User;

import java.util.List;

public class UserMapper {

    public static User toUser(UserRequestDTO userRequestDTO) {
        return new User(
                userRequestDTO.username(),
                userRequestDTO.password(),
                userRequestDTO.roles()
        );
    }

    public static UserResponseDTO toDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getRoles()
        );
    }

    public static List<UserResponseDTO> toListDTO(List<User> users) {
        return users.stream()
                .map(u -> new UserResponseDTO(
                        u.getId(),
                        u.getUsername(),
                        u.getRoles()))
                .toList();
    }

    public static UserLoginResponseDTO toLoginClientResponseDTO(User user) {
        return new UserLoginResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getRoles()
                        .stream()
                        .map(Roles::getName)
                        .toList()
        );
    }

}
