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

    public Livros() {
    }

    public Livros(Long id, String nome, int tipoExemplar, String autor, String editora, int edicao) {
        super(id, nome, tipoExemplar);
        this.autor = autor;
        this.editora = editora;
        this.edicao = edicao;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public void verificarLivros() {

    }

    @Override
    public String toString() {
        return "\nLivros{" +
                "autor='" + autor + '\'' +
                ", editora='" + editora + '\'' +
                ", edicao=" + edicao +
                '}';
    }

}
