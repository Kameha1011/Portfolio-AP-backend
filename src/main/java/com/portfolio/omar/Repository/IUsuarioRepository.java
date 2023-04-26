
package com.portfolio.omar.Repository;

import com.portfolio.omar.Entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    public Optional<Usuario> findByNombre(String nombre);

    public boolean existsByNombre(String nombre);
}
