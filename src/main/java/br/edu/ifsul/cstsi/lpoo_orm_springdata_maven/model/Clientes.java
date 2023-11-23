package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model;

import jakarta.persistence.*;

@Entity(name = "Clientes")
@Table(name = "clientes")
public class Clientes {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column(name = "nome_cliente", nullable = false)
    private String nome;

    @Column(name = "idade_cliente")
    private int idade;

    @Column(name = "tel_cliente", nullable = false)
    private int telefone;

    @Column(name = "end_cliente")
    private String endereco;

    @Column(name = "tipo_cliente")
    private int tipoCliente;

}
