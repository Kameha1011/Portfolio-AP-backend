
package com.portfolio.omar.Security.Service;

import com.portfolio.omar.Security.Entity.Rol;
import com.portfolio.omar.Security.Enums.RolNombre;
import com.portfolio.omar.Security.Repository.iRolRepository;
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
public class RolService {
    @Autowired
     iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol){
        irolRepository.save(rol);
    }
}
