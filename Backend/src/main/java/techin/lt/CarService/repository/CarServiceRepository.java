package techin.lt.CarService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import techin.lt.CarService.model.CarService;

@Repository
public interface CarServiceRepository extends JpaRepository<CarService, Long> {
}

