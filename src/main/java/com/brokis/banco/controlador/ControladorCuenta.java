package com.brokis.banco.controlador;

import com.brokis.banco.modelo.Cuenta;
import com.brokis.banco.servicio.CreadorCuenta;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cuenta")
@AllArgsConstructor
public class ControladorCuenta {
    private final CreadorCuenta creadorCuenta;
    @PostMapping("/crear")
    public ResponseEntity crearCuenta(@RequestBody Cuenta cuenta) {
        return new ResponseEntity(creadorCuenta.crearCuenta(cuenta), HttpStatus.CREATED);
    }
}
