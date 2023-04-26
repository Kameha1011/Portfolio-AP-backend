
package com.portfolio.omar.Security.Service;

import com.portfolio.omar.Security.Entity.User;
import com.portfolio.omar.Security.Entity.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author omrfl
 */
@Service
public class UserDetailsImpl implements UserDetailsService{
    @Autowired
    UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        User user = usuarioService.getByUsuario(usuario).get();
        return UserPrincipal.build(user);
    }
     
}
