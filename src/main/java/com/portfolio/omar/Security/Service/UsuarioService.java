
package com.portfolio.omar.Security.Service;

import com.portfolio.omar.Security.Entity.User;
import com.portfolio.omar.Security.Repository.iUsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author omrfl
 */
@Service
@Transactional
public class UsuarioService {
    @Autowired
    iUsuarioRepository iusuarioRepository;
    
    public Optional<User> getByUsuario(String usuario){
        return iusuarioRepository.findByUsuario(usuario);
    }
    
    public boolean existsByUsuario(String usuario){
        return iusuarioRepository.existsByUsuario(usuario);
    }
    
    public boolean existsByEmail(String email){
        return iusuarioRepository.existsByEmail(email);
    }
    
    public void save(User usuario){
        iusuarioRepository.save(usuario);
    }
}
