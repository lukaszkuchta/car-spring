package pl.sda.j133.springcar.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarRequest {
    private String nrRejestracyjny;
    private LocalDate dataPierwszejRejestracji;
    private Integer iloscDrzwi;
    private Double pojemnoscSilnika;
}
