package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.exemplares;

import br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.exemplares.ExemplaresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExemplaresService {

    @Autowired
    private ExemplaresRepository rep;

    public List<Exemplares> getExemplares() {
        return rep.findAll();
    }

    public Exemplares getExemplaresById(Long id) {
        Optional<Exemplares> optional = rep.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public List<Exemplares> getExemplaresByNome(String nome) {
        return new ArrayList<>(rep.findByNome(nome + "%"));
    }

    public Exemplares getExemplarById(Long id) {
        Optional<Exemplares> optional = rep.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public Exemplares insert(Exemplares exemplares) {
        Assert.isNull(exemplares.getId(), "Não foi possível inserir o registro.");
        return rep.save(exemplares);
    }

    public Exemplares update(Exemplares exemplar) {
        Assert.notNull(exemplar.getId(),"Não foi possível atualizar o registro");

        // Busca o produto no banco de dados
        Optional<Exemplares> optional = rep.findById(exemplar.getId());
        if(optional.isPresent()) {
            Exemplares db = optional.get();
            // Copiar as propriedades
            db.setNome(exemplar.getNome());
            db.setTipoExemplar(exemplar.getTipoExemplar());
            // Atualiza o produto
            rep.save(db);

            return db;

        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }
    public void delete(Long id) {
        rep.deleteById(id);
    }

}
