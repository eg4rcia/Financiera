package com.example.FinancieraApp.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Puedes añadir métodos personalizados aquí si es necesario
}