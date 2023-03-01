package com.brokis.banco.repocitorios;

import com.brokis.banco.modelo.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepCuenta extends JpaRepository<Cuenta,Long> {
}
