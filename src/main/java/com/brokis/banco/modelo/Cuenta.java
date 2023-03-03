package com.brokis.banco.modelo;
import lombok.*;
import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Deprecated
    private Long numeroCuenta;
    @Column(nullable = false)
    private String nombreTitular;
    @Column(nullable = false, length = 10)
    private int documentoTitular;
    @Column(nullable = false)
    private String fechaCreacion;
    @Deprecated
    private double saldo = 0;


}
