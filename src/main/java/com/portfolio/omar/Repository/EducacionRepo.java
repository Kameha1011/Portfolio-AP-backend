package com.portfolio.omar.Repository;

import com.portfolio.omar.Entity.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author omrfl
 */
@Repository
public interface EducacionRepo extends JpaRepository<Educacion, Integer> {

    public Optional<Educacion> findByNombreInstitucion(String nombreInstitucion);

    public boolean existsByNombreInstitucion(String nombreInstitucion);
}
