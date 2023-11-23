package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model;

import jakarta.persistence.*;

@Entity(name = "Exemplares")
@Table(name = "exemplares")
@Inheritance(strategy = InheritanceType.JOINED)
public class Exemplares {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exemplar")
    private Long id;

    @Column(name = "nome_exemplar", nullable = false)
    private String nome;

    @Column(name = "tipo_exemplar", nullable = false)
    private int tipoExemplar;

}
