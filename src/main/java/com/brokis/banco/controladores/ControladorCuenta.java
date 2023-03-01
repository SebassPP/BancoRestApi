package com.brokis.banco.controladores;

import com.brokis.banco.modelo.Cuenta;
import com.brokis.banco.servicios.ServicioCuenta;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cuenta")
@AllArgsConstructor
public class ControladorCuenta {
    private final ServicioCuenta servicioCuenta;
    @PostMapping("/crear")
    public ResponseEntity crearCuenta(@RequestBody Cuenta cuenta) {
        return new ResponseEntity(servicioCuenta.crearCuenta(cuenta), HttpStatus.CREATED);
    }

    @GetMapping("/consultar/{numeroCuenta}")
    public ResponseEntity consultarSaldo(@PathVariable Long numeroCuenta) {
        return new ResponseEntity(servicioCuenta.consultarSaldo(numeroCuenta), HttpStatus.OK);
    }

    @PutMapping("/depositar/{numeroCuenta}/{monto}")
    public ResponseEntity realizarDeposito(@PathVariable Long numeroCuenta, @PathVariable double monto) {
        return new ResponseEntity(servicioCuenta.realizarDeposito(numeroCuenta, monto), HttpStatus.OK);
    }
    @PutMapping("transferencia/{numeroCuentaOrigen}/{numeroCuentaDestino}/{monto}")
    public ResponseEntity<String> transferir(
            @PathVariable Long numeroCuentaOrigen,
            @PathVariable Long numeroCuentaDestino,
            @PathVariable Double monto) {

        String resultadoTransferencia = servicioCuenta.hacerTransferencia(numeroCuentaOrigen, numeroCuentaDestino, monto);
        System.out.println(resultadoTransferencia);

        if (resultadoTransferencia.equals("Transferencia realizada con exito")) {
            return ResponseEntity.ok(resultadoTransferencia);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La transferencia no se pudo realizar");
        }
    }
}
