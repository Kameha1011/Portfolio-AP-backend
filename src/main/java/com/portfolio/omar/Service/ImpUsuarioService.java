
package com.portfolio.omar.Service;

import com.portfolio.omar.Entity.Usuario;
import com.portfolio.omar.Repository.IUsuarioRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpUsuarioService{
    @Autowired IUsuarioRepository iusuarioRepository;
   
     public List<Usuario> list() {
        return iusuarioRepository.findAll();
    }

    public Optional<Usuario> getOne(int id) {
        return iusuarioRepository.findById(id);
    }

    public Optional<Usuario> getByNombre(String nombre) {
        return iusuarioRepository.findByNombre(nombre);
    }

    public void save(Usuario usuario) {
        iusuarioRepository.save(usuario);
    }

    public void delete(int id) {
        iusuarioRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return iusuarioRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre) {
        return iusuarioRepository.existsByNombre(nombre);
    }
}
