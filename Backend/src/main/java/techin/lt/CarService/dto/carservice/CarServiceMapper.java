package techin.lt.CarService.dto.carservice;

import techin.lt.CarService.model.CarService;

public class CarServiceMapper {

    public static CarService toEntity(CarServiceRequestDTO carServiceRequestDTO) {
        CarService carService = new CarService();
        carService.setName(carServiceRequestDTO.name());
        carService.setAddress(carServiceRequestDTO.address());
        carService.setManager(carServiceRequestDTO.manager());
        return carService;
    }

    public CarServiceResponseDTO toDTO(CarService carService) {
        return new CarServiceResponseDTO(
                carService.getId(),
                carService.getName(),
                carService.getAddress(),
                carService.getManager()
        );
    }
}
