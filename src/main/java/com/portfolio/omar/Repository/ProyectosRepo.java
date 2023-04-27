package com.portfolio.omar.Repository;

import com.portfolio.omar.Entity.Proyectos;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author omrfl
 */
@Repository
public interface ProyectosRepo extends JpaRepository<Proyectos, Integer> {

    public Optional<Proyectos> findByNombreProy(String nombreProy);

    public boolean existsByNombreProy(String nombreProy);
}
