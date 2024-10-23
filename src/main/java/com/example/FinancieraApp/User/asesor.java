package com.example.FinancieraApp.User;
import jakarta.persistence.*;

@Entity
@Table(name = "asesor")
public class asesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "asesor_id", nullable = false)
    private Long asesor_id;

    private String nombres;
  

    // Getters y Setters
    public Long getId() {
        return asesor_id;
    }

    public void setId(Long id) {
        this.asesor_id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

}
