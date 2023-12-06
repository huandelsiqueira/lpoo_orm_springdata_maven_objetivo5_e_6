package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model;

import br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.exemplares.Exemplares;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity(name = "Emprestimo")
@Table(name = "emprestimo")
public class Emprestimo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_emprestimo")
    private Long id;

    @Column(name = "dt_emprestimo", nullable = false)
    private LocalDate dataEmprestimo;

    @Column(name = "dt_devolucao", nullable = false)
    private LocalDate dataDevolucao;

    @OneToOne
    private Clientes cliente;

    @OneToOne
    private Exemplares exemplar;

}
