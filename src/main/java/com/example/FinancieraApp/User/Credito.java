package com.example.FinancieraApp.User;
import com.example.FinancieraApp.User.asesor;

import jakarta.persistence.*;

@Entity
@Table(name = "credito")
public class Credito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double monto;
    
    private String fechaEntrega;
    
    @Column(name = "numero_pagos")
    private Integer numeroPagos; // 10, 12, 16, 24
    
    private String frecuenciaPagos; // semanal, quincenal, mensual
    
    private String estatus; // Pagado o Pendiente de Pago
    
    @ManyToOne // asumiendo que tienes una entidad Cliente
    private Cliente cliente;

    @ManyToOne // Relación muchos a uno (muchos créditos pueden tener un asesor)
   @JoinColumn(name = "asesor_id", nullable = false)
    private asesor asesor; // Cambiamos de String a Usuario


    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    public asesor getAsesor() {
        return asesor;
    }

    public void setAsesor(asesor asesor) {
        this.asesor = asesor;
    }

   
    
}


