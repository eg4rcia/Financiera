package com.example.FinancieraApp.User;
import com.example.FinancieraApp.User.CreditoUpdateRequest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditoService {

    @Autowired
    private CreditoRepository creditoRepository;


    public Credito guardarCredito(Credito credito) {
        return creditoRepository.save(credito);
    }
    public List<Credito> obtenerTodosLosCreditos() {
        return creditoRepository.findAll();
    }

   
    public Optional<Credito> obtenerCreditoPorId(Long id) {
        return creditoRepository.findById(id);
    }
    @Autowired
    private AsesorRepository asesorRepository;
  
    @Autowired
    private ClienteRepository clienteRepository;

    public Credito actualizarAsesorYCliente(Long creditoId, Long asesorId, Long clienteId,String estatus) {
        // Buscar el crédito por ID
        Credito credito = creditoRepository.findById(creditoId).orElseThrow(() -> new RuntimeException("Crédito no encontrado"));

        // Buscar el asesor y cliente por sus IDs
        asesor nuevoAsesor = asesorRepository.findById(asesorId).orElseThrow(() -> new RuntimeException("Asesor no encontrado"));
        Cliente nuevoCliente = clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // Actualizar los campos asesor y cliente
        credito.setAsesor(nuevoAsesor);
        credito.setCliente(nuevoCliente);
        credito.setEstatus(estatus);
        // Guardar los cambios
        return creditoRepository.save(credito);
    }
    



}
