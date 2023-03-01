package com.brokis.banco.servicios;
import com.brokis.banco.modelo.Cuenta;
import java.util.Optional;

public interface ServicioCuenta {
    Cuenta crearCuenta(Cuenta cuenta);
    Optional<Cuenta> consultarSaldo(Long numeroCuneta); //El optional es para que no se rompa si no encuentra ninguna cuenta
    Cuenta realizarDeposito(Long numeroCuenta, double monto);

    String hacerTransferencia(Long numeroCuentaOrigen, Long numeroCuentaDestino, double monto);

}
