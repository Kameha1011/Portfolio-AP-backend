package com.portfolio.omar.Service;

import com.portfolio.omar.Entity.Experiencia;
import com.portfolio.omar.Repository.RExperiencia;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author omrfl
 */
@Service
@Transactional
public class SExperiencia {

    @Autowired
    RExperiencia rExperiencia;

    public List<Experiencia> list() {
        return rExperiencia.findAll();
    }

    public Optional<Experiencia> getOne(int id) {
        return rExperiencia.findById(id);
    }

    public Optional<Experiencia> getByNombreEmpresa(String nombreEmpresa) {
        return rExperiencia.findByNombreEmpresa(nombreEmpresa);
    }

    public void save(Experiencia exp) {
        rExperiencia.save(exp);
    }

    public void delete(int id) {
        rExperiencia.deleteById(id);
    }

    public boolean existsById(int id) {
        return rExperiencia.existsById(id);
    }

    public boolean existsByNombreEmpresa(String NombreEmpresa) {
        return rExperiencia.existsByNombreEmpresa(NombreEmpresa);
    }
}
