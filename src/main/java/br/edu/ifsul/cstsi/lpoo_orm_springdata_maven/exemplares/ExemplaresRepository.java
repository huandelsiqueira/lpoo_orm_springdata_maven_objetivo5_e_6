package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.exemplares;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExemplaresRepository extends JpaRepository<Exemplares, Long> {
    @Query(value = "SELECT c FROM Exemplares c where c.nome like ?1")
    List<Exemplares> findByNome(String nome);
}
