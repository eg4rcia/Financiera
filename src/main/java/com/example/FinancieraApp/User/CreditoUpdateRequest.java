package com.example.FinancieraApp.User;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class CreditoUpdateRequest {
  
 

    private Double monto;
    
    private Integer numeroPagos;
    private String frecuenciaPagos;
 
    private Long asesorId; // ID del asesor


    private String estatus;

    @ManyToOne // Relación muchos a uno (muchos créditos pueden tener un asesor)
   @JoinColumn(name = "asesor_id", nullable = false)
    private asesor asesor; // Cambiamos de String a Usuario

    // Getters y Setters

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }


    public Integer getNumeroPagos() {
        return numeroPagos;
    }

    public void setNumeroPagos(Integer numeroPagos) {
        this.numeroPagos = numeroPagos;
    }

    public String getFrecuenciaPagos() {
        return frecuenciaPagos;
    }

    public void setFrecuenciaPagos(String frecuenciaPagos) {
        this.frecuenciaPagos = frecuenciaPagos;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

  
    // Método setter para el campo 'asesor'
    public void setAsesor(asesor asesor) {
        this.asesor = asesor;
    }
 

    public asesor getAsesor() {
        return asesor;
    }
    public Long getAsesorId() {
        return asesorId;
    }

    // Método setter para asesorId
    public void setAsesorId(Long asesorId) {
        this.asesorId = asesorId;
    }
   
}