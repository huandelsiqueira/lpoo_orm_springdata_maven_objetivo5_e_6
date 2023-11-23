package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model;

import jakarta.persistence.*;

@Entity(name = "Livros")
@Table(name = "livros")
@PrimaryKeyJoinColumn(name = "exemplares_id")
public class Livros extends Exemplares {

    @Column(name = "autor_livro", nullable = false)
    private String autor;

    @Column(name = "editora_livro", nullable = false)
    private String editora;

    @Column(name = "edicao_livro", nullable = false)
    private int edicao;

}
