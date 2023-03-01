package com.brokis.banco.modelo;
import lombok.*;
import javax.persistence.*;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cuenta {
    @Id // Asigno numero de cuenta como clave primaria
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental si se requiere
    private Long numeroCuenta;
    @Column(nullable = false) // No puede ser nulo
    private String nombreTitular;
    @Column(nullable = false, length = 10) // Maximo de tamaño =10
    private int documentoTitular;
    @Column(nullable = false)
    private String fechaCreacion;
    private double saldo;


}
