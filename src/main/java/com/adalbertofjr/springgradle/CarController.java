package com.adalbertofjr.springgradle;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostMapping
    @ResponseBody
    public Car create(@RequestBody Car car){
        return this.carRepository.save(car);
    }
}
