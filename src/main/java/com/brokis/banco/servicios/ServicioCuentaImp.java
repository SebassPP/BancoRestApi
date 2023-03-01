package com.brokis.banco.servicios;

import com.brokis.banco.modelo.Cuenta;
import com.brokis.banco.repocitorios.RepCuenta;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ServicioCuentaImp implements ServicioCuenta {

    private final RepCuenta repCuenta;

    @Override
    public Cuenta crearCuenta(Cuenta cuenta) {

        return repCuenta.save(cuenta);
    }

    @Override
    public Optional<Cuenta> consultarSaldo(Long numeroCuenta) {
        return Optional.ofNullable(repCuenta.findById(numeroCuenta).orElseThrow(() ->
                new IllegalStateException("No se encontro ninguna cuenta con ese saldo")));
    }

    @Override
    public Cuenta realizarDeposito(Long numeroCuenta, double monto) {
        Cuenta cuentaBuscada = repCuenta.findById(numeroCuenta).orElseThrow(() ->
                new RuntimeException("Cuenta no encontrada"));
        cuentaBuscada.setSaldo(cuentaBuscada.getSaldo() + monto);
        return repCuenta.save(cuentaBuscada);
    }

    @Override
    public String hacerTransferencia(Long numeroCuentaOrigen, Long numeroCuentaDestino, double monto) {
        Cuenta cuentaOrigen = repCuenta.findById(numeroCuentaOrigen).orElseThrow(() ->
                new RuntimeException("Cuenta origen no encontrada"));
        Cuenta cuentaDestino = repCuenta.findById(numeroCuentaDestino).orElseThrow(() ->
                new RuntimeException("Cuenta destino no encontrada"));

        if (cuentaOrigen.getSaldo() < monto) {
            throw new RuntimeException("Saldo insuficiente");
        }
        cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - monto);
        cuentaDestino.setSaldo(cuentaDestino.getSaldo() + monto);
        repCuenta.save(cuentaOrigen);
        repCuenta.save(cuentaDestino);

        return "Transferencia realizada con exito";
    }

}