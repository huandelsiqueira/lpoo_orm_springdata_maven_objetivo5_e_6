package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.exemplares;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Exemplares")
@Table(name = "exemplares")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exemplares {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exemplar")
    private Long id;

    @Column(name = "nome_exemplar", nullable = false)
    private String nome;

    @Column(name = "tipo_exemplar", nullable = false)
    private String tipoExemplar;

}
