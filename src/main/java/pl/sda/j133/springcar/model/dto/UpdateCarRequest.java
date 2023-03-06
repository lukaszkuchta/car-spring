package pl.sda.j133.springcar.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {
    private String nrRejestracyjny;
    private Integer iloscDrzwi;
    private Double pojemnoscSilnika;

}
