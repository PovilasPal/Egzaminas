package techin.lt.CarService.service;

import org.springframework.stereotype.Service;
import techin.lt.CarService.model.User;
import techin.lt.CarService.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findUserById(long id) {
        return this.userRepository.findById(id);
    }

    public boolean existsUserByUsername(String username) {
        return this.userRepository.existsByUsername(username);
    }

    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    public void deleteUser(long id) {
        this.userRepository.deleteById(id);
    }
}
