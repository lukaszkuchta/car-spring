package pl.sda.j133.springcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.j133.springcar.model.Car;
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
