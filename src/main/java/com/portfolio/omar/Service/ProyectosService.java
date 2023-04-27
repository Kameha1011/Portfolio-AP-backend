
package com.portfolio.omar.Service;

import com.portfolio.omar.Entity.Proyectos;
import com.portfolio.omar.Repository.ProyectosRepo;
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
public class ProyectosService {
     @Autowired
    ProyectosRepo proyectosRepo;

    public List<Proyectos> list() {
        return proyectosRepo.findAll();
    }

    public Optional<Proyectos> getOne(int id) {
        return proyectosRepo.findById(id);
    }

    public Optional<Proyectos> getByNombreProy(String nombreProy) {
        return proyectosRepo.findByNombreProy(nombreProy);
    }

    public void save(Proyectos proy) {
        proyectosRepo.save(proy);
    }

    public void delete(int id) {
        proyectosRepo.deleteById(id);
    }

    public boolean existsById(int id) {
        return proyectosRepo.existsById(id);
    }

    public boolean existsByNombreProy(String NombreProy) {
        return proyectosRepo.existsByNombreProy(NombreProy);
    }
}
