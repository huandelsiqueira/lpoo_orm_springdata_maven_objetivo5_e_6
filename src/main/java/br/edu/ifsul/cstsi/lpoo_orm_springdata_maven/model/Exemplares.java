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

    @OneToOne
    @JoinColumn(name = "id_exemplar")
    private Clientes cliente;

    public Exemplares() {
    }

    public Exemplares(Long id, String nome, int tipoExemplar) {
        this.id = id;
        this.nome = nome;
        this.tipoExemplar = tipoExemplar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTipoExemplar() {
        return tipoExemplar;
    }

    public void setTipoExemplar(int tipoExemplar) {
        this.tipoExemplar = tipoExemplar;
    }

    public void manterExemplares() {

    }

    @Override
    public String toString() {
        return "\nExemplares{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipoExemplar=" + tipoExemplar +
                '}';
    }

}
