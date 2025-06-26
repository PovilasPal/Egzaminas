package techin.lt.CarService.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import techin.lt.CarService.model.CarService;
import techin.lt.CarService.model.Mechanic;
import techin.lt.CarService.service.MechanicService;

import java.util.List;

@RestController
@RequestMapping("/api/mechanics")
public class MechanicController {

    private final MechanicService mechanicService;
    private final CarService carService;

    public MechanicController(MechanicService mechanicService, CarService carService) {
        this.mechanicService = mechanicService;
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<Mechanic> getMechanic() {

        List<Mechanic> mechanic = this.mechanicService.findAllMechanics();

        return ResponseEntity.ok(techin.lt.CarService.dto.Mechanic.MechanicMapper);

    }

}
