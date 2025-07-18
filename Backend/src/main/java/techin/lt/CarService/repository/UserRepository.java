package techin.lt.CarService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import techin.lt.CarService.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

}
