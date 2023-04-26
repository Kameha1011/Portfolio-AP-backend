
package com.portfolio.omar.Security.Repository;

import com.portfolio.omar.Security.Entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author omrfl
 */
@Repository
public interface iUsuarioRepository extends JpaRepository<User, Integer>{
    Optional<User> findByUsuario(String usuario);
    
    boolean existsByUsuario(String usuario);
    boolean existsByEmail(String email);
}
