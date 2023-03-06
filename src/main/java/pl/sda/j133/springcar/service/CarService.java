package pl.sda.j133.springcar.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.j133.springcar.model.Car;
import pl.sda.j133.springcar.model.dto.CarResponse;
import pl.sda.j133.springcar.model.dto.CreateCarRequest;
import pl.sda.j133.springcar.model.dto.UpdateCarRequest;
import pl.sda.j133.springcar.model.dto.UpdateCarResponse;
import pl.sda.j133.springcar.repository.CarRepository;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public CarResponse add(CreateCarRequest request) {
        Car car = Car.builder()
                .reg(request.getNrRejestracyjny())
                .engineCap((request.getPojemnoscSilnika()))
                .registrationDate(request.getDataPierwszejRejestracji())
                .doors(request.getIloscDrzwi())
                .build();

        car = carRepository.save(car);

        return mapujCarNaCarResponse(car);
    }

    public List<CarResponse> getAll() {
        return carRepository.findAll()
                .stream().map(this::mapujCarNaCarResponse)
                .toList();
    }

    private CarResponse mapujCarNaCarResponse(Car car) {
        return new CarResponse(
                car.getId(),
                car.getReg(),
                car.getRegistrationDate(),
                car.getDoors(),
                car.getEngineCap()
        );
    }

    public void delete(Long id) {
        carRepository.deleteById(id);
    }

    public UpdateCarResponse update(Long id, UpdateCarRequest request) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("nie znaleziona samochodu o id: " + id));
        if(request.getNrRejestracyjny() != null){
            car.setReg(request.getNrRejestracyjny());
        }
        if(request.getIloscDrzwi() != null){
            car.setDoors(request.getIloscDrzwi());
        }
        if(request.getPojemnoscSilnika() != null){
            car.setEngineCap(request.getPojemnoscSilnika());
        }

        car = carRepository.save(car);

        return mapujCarNaUpdateCarResponse(car);
    }

    private UpdateCarResponse mapujCarNaUpdateCarResponse(Car car) {
        return new UpdateCarResponse(
                car.getId(),
                car.getReg(),
                car.getRegistrationDate(),
                car.getDoors(),
                car.getEngineCap()
        );
    }

    public CarResponse findById(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("nie znaleziono samochodu o id: " + id));
        return mapujCarNaCarResponse(car);
    }
}
