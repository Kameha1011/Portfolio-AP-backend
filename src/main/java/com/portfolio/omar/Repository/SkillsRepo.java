
package com.portfolio.omar.Repository;

import com.portfolio.omar.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author omrfl
 */
public interface SkillsRepo extends JpaRepository<Skills, Integer>{
    Optional<Skills> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
