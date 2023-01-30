package com.unir.busquedaunir.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Users")  //Keyword en H2 de User
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(indexes = { @Index(columnList = "userId", name = "index_userId", unique = true),@Index(columnList = "email", name = "index_email", unique = true)} )

public class UserEntity implements Serializable {

    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private String userId;
    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(nullable = false, length = 255)
    private String email;
    @Column(nullable = false)
    private String encryptPassword;

    @OneToMany(mappedBy = "usuario")
    List<CompraEntity> compras = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    List<VentaEntity> ventas = new ArrayList<>();
}
