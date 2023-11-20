package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity(name = "Emprestimo")
@Table(name = "emprestimo")
public class Emprestimo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dt_emprestimo", nullable = false)
    private LocalDate dataEmprestimo;

    @Column(name = "dt_devolucao", nullable = false)
    private LocalDate dataDevolucao;

    @OneToOne
    private Clientes cliente;

    @OneToOne
    private Exemplares exemplar;

    public Emprestimo() {
    }

    public Emprestimo(Long id, LocalDate dataEmprestimo, LocalDate dataDevolucao, Clientes cliente, Exemplares exemplar) {
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

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
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
