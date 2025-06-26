package techin.lt.CarService.dto.Mechanic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import techin.lt.CarService.dto.mechanic.MechanicRequestDTO;
import techin.lt.CarService.dto.mechanic.MechanicResponseDTO;
import techin.lt.CarService.model.Mechanic;
import techin.lt.CarService.model.CarService;
import techin.lt.CarService.service.CarServiceService;

@Component
public class MechanicMapper {

    private final CarServiceService carServiceService;

    @Autowired
    public MechanicMapper(CarServiceService carServiceService) {
        this.carServiceService = carServiceService;
    }

    // Convert MechanicRequestDTO to Mechanic entity
    public Mechanic toEntity(MechanicRequestDTO mechanicRequestDTO) {
        Mechanic mechanic = new Mechanic();
        mechanic.setFirstName(mechanicRequestDTO.firstName());
        mechanic.setLastName(mechanicRequestDTO.lastName());
        mechanic.setSpecialization(mechanicRequestDTO.specialization());
        mechanic.setCity(mechanicRequestDTO.city());

        // Fetch the CarService entity using serviceId
        CarService carService = carServiceService.getCarServiceById(mechanicRequestDTO.serviceId());
        mechanic.setService(carService);

        return mechanic;
    }

    // Convert Mechanic entity to MechanicResponseDTO
    public MechanicResponseDTO toDTO(Mechanic mechanic) {
        return new MechanicResponseDTO(
                mechanic.getId(),
                mechanic.getFirstName(),
                mechanic.getLastName(),
                mechanic.getSpecialization(),
                mechanic.getCity(),
                mechanic.getService().getId()
        );
    }
}
