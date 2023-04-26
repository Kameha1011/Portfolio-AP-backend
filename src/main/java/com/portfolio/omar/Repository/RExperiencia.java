
package com.portfolio.omar.Repository;

import com.portfolio.omar.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author omrfl
 */
@Repository
public interface RExperiencia extends JpaRepository<Experiencia, Integer> {
    public Optional<Experiencia> findByNombreEmpresa(String nombreEmpresa);
    public boolean existsByNombreEmpresa(String nombreEmpresa);
}
