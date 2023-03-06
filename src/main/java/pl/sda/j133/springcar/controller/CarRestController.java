package pl.sda.j133.springcar.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.j133.springcar.model.dto.CarResponse;
import pl.sda.j133.springcar.model.dto.CreateCarRequest;
import pl.sda.j133.springcar.model.dto.UpdateCarRequest;
import pl.sda.j133.springcar.model.dto.UpdateCarResponse;
import pl.sda.j133.springcar.service.CarService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest/car")
public class CarRestController {
    private final CarService carService;

    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CarResponse add(@RequestBody CreateCarRequest request) {
        return carService.add(request);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<CarResponse> list() {
        return carService.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        carService.delete(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UpdateCarResponse update(@PathVariable Long id, @RequestBody UpdateCarRequest request){
        return carService.update(id, request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarResponse getCarById(@PathVariable Long id){
        return carService.findById(id);
    }
}
