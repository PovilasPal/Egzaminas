package techin.lt.CarService.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import techin.lt.CarService.dto.User.UserMapper;
import techin.lt.CarService.dto.User.UserRequestDTO;
import techin.lt.CarService.dto.User.UserResponseDTO;
import techin.lt.CarService.dto.login.UserLoginResponseDTO;
import techin.lt.CarService.model.User;
import techin.lt.CarService.service.UserService;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5223/")
@Validated
@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("users/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable long id) {

        Optional<User> findUser = this.userService.findUserById(id);

        if (findUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(UserMapper.toDTO(findUser.get()));

    }

    @PostMapping("/users")
    public ResponseEntity<Object> saveUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {

        if (this.userService.existsUserByUsername(userRequestDTO.username())) {

            return ResponseEntity.badRequest().body("This user already exists");

        }

        User user = UserMapper.toUser(userRequestDTO);

        user.setPassword((this.passwordEncoder.encode(userRequestDTO.password())));

        User savedUser = this.userService.saveUser(user);

        return ResponseEntity.created(
                        ServletUriComponentsBuilder.fromCurrentRequest()
                                .path("/{id}")
                                .buildAndExpand(savedUser.getId())
                                .toUri())
                .body(UserMapper.toDTO(savedUser));

    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable("id") long id, @Valid @RequestBody UserRequestDTO userRequestDTO) {

        Optional<User> findUser = this.userService.findUserById(id);

        if (findUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User updateUser = findUser.get();

        updateUser.setUsername(userRequestDTO.username());
        updateUser.setRoles(userRequestDTO.roles());

        if (userRequestDTO.password() != null && !userRequestDTO.password().isBlank()) {
            updateUser.setPassword(passwordEncoder.encode(userRequestDTO.password()));
        }

        User savedUser = this.userService.saveUser(updateUser);

        return ResponseEntity.ok(UserMapper.toDTO(savedUser));
    }


    @DeleteMapping("/users/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {

        Optional<User> findUser = this.userService.findUserById(id);

        if (findUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        this.userService.deleteUser(id);

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/login/client")
    public ResponseEntity<UserLoginResponseDTO> client(Authentication authentication) {
        User user = (User) authentication.getPrincipal();

        return ResponseEntity.ok(UserMapper.toLoginClientResponseDTO(user));
    }

}