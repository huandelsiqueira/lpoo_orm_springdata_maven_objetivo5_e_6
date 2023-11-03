package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "Emprestimo")
@Table(name = "emprestimo")
public class Emprestimo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dt_emprestimo", nullable = false)
    private Date dataEmprestimo;

    @Column(name = "dt_devolucao", nullable = false)
    private Date dataDevolucao;

    @OneToOne
    private Clientes cliente;

    @OneToOne
    private Exemplares exemplar;

    public Emprestimo() {
    }

    public Emprestimo(Long id, Date dataEmprestimo, Date dataDevolucao, Clientes cliente, Exemplares exemplar) {
        this.id = id;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.cliente = cliente;
        this.exemplar = exemplar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Exemplares getExemplar() {
        return exemplar;
    }

    public void setExemplar(Exemplares exemplar) {
        this.exemplar = exemplar;
    }

    public void realizarEmprestimo() {

    }

    public void realizarDevolucao() {

    }

    @Override
    public String toString() {
        return "\nEmprestimo{" +
                "id=" + id +
                ", dataEmprestimo=" + dataEmprestimo +
                ", dataDevolucao=" + dataDevolucao +
                ", cliente=" + cliente +
                ", exemplar=" + exemplar +
                '}';
    }
}
