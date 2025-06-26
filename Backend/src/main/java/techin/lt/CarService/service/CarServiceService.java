package techin.lt.CarService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import techin.lt.CarService.model.CarService;
import techin.lt.CarService.repository.CarServiceRepository;

@Service
public class CarServiceService {

    private final CarServiceRepository carServiceRepository;

    @Autowired
    public CarServiceService(CarServiceRepository carServiceRepository) {
        this.carServiceRepository = carServiceRepository;
    }

    public CarService createCarService(CarService carService) {
        return carServiceRepository.save(carService);
    }

    public CarService getCarServiceById(Long aLong) {
        return this.carServiceRepository.findById(aLong).orElse(null);
    }
}

