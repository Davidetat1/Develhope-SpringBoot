package co.develhopr.eserciziohibernate.entites;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Classes")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

}
