package techin.lt.CarService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import techin.lt.CarService.model.Mechanic;

@Repository
public interface MechanicRepository extends JpaRepository<Mechanic, Long> {
}

