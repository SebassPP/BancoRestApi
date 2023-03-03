package com.brokis.banco.servicio;

import com.brokis.banco.modelo.Cuenta;
import com.brokis.banco.repositorio.RepCuenta;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreadorCuentaImp implements CreadorCuenta{
    private final RepCuenta repCuenta;

    @Override
    public Cuenta crearCuenta(Cuenta cuenta) {

        return repCuenta.save(cuenta);
    }
}
