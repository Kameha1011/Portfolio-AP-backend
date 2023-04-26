package com.portfolio.omar.Service;

import com.portfolio.omar.Entity.Educacion;
import com.portfolio.omar.Repository.EducacionRepo;
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
public class EducacionService {

    @Autowired
    EducacionRepo educacionRepo;

    public List<Educacion> list() {
        return educacionRepo.findAll();
    }

    public Optional<Educacion> getOne(int id) {
        return educacionRepo.findById(id);
    }

    public Optional<Educacion> getByNombreInstitucion(String nombreInstitucion) {
        return educacionRepo.findByNombreInstitucion(nombreInstitucion);
    }

    public void save(Educacion edu) {
        educacionRepo.save(edu);
    }

    public void delete(int id) {
        educacionRepo.deleteById(id);
    }

    public boolean existsById(int id) {
        return educacionRepo.existsById(id);
    }

    public boolean existsByNombreInstitucion(String NombreInstitucion) {
        return educacionRepo.existsByNombreInstitucion(NombreInstitucion);
    }
}
