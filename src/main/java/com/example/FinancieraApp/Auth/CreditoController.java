package com.example.FinancieraApp.Auth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import com.example.FinancieraApp.User.Cliente;
import com.example.FinancieraApp.User.Credito;
import com.example.FinancieraApp.User.CreditoService;
import com.example.FinancieraApp.User.CreditoUpdateRequest;


@RestController
@CrossOrigin(origins = "http://localhost:4200") // Permitir solo este origen
@RequestMapping("/api")
public class CreditoController {

    @Autowired
    private CreditoService creditoService;
    //@PreAuthorize("hasAuthority('USER')") // Ajusta según tus roles
    @PostMapping(value = "credito")
    public ResponseEntity<Credito> crearCredito(@RequestBody Credito credito) {
        Credito nuevoCredito = creditoService.guardarCredito(credito);
        return new ResponseEntity<>(nuevoCredito, HttpStatus.CREATED);
    }



   @GetMapping(value = "Vercreditos")
    public ResponseEntity<List<Credito>> obtenerCreditos() {
        List<Credito> credito = creditoService.obtenerTodosLosCreditos();
        return new ResponseEntity<>(credito, HttpStatus.OK);
    }
    
    @GetMapping("/credito/{id}")
    public ResponseEntity<Credito> obtenerCreditoPorId(@PathVariable Long id) {
        try {
            Optional<Credito> creditoOptional = creditoService.obtenerCreditoPorId(id);
 
            if (creditoOptional.isPresent()) {
                return ResponseEntity.ok(creditoOptional.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Crédito no encontrado
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/update/credito/{id}")
    public Credito actualizarCredito(
            @PathVariable Long id,
            @RequestParam Long asesorId,
            @RequestParam Long clienteId,
            @RequestParam String estatus) {
        return creditoService.actualizarAsesorYCliente(id, asesorId, clienteId,estatus);
    }

}

