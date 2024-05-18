package co.develhope.esercizioOperazioni.Crud.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String modelName;

    @Column(nullable = false)
    private String carType;

    public String getCarType() {
        return carType;
    }

    // ho avuto problemi nel chiamare il metodo setCarType,
    // per risolvere ho inserito i getter & setter per l'attributo type.
    public void setCarType(String carType) {
        this.carType = carType;
    }
}
