
package com.portfolio.omar.Controller;

import com.portfolio.omar.Dto.DtoUsuario;
import com.portfolio.omar.Entity.Usuario;
import com.portfolio.omar.Security.Controller.Mensaje;
import com.portfolio.omar.Service.ImpUsuarioService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 @RestController
 @RequestMapping("/usuarios")
 @CrossOrigin(origins = "http://localhost:4200")

public class UsuarioController {
    @Autowired ImpUsuarioService usuarioService;
    @GetMapping("/lista")
    public ResponseEntity<List<Usuario>> list(){
        List<Usuario> list = usuarioService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
     @GetMapping("/detail/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") int id){
        if(!usuarioService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Usuario usuario = usuarioService.getOne(id).get();
        return new ResponseEntity(usuario, HttpStatus.OK);
    }
    
  /*  @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!usuarioService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        usuarioService.delete(id);
        return new ResponseEntity(new Mensaje("Usuario eliminado"), HttpStatus.OK);
    } */

    
   /* @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoUsuario dtousuario){      
        if(StringUtils.isBlank(dtoedu.getNombreInstitucion()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(usuarioService.existsByNombreInstitucion(dtousuario.getNombreInstitucion()))
            return new ResponseEntity(new Mensaje("Ese Usuario existe"), HttpStatus.BAD_REQUEST);
        
        Usuario usuario = new Usuario(dtousuario.getNombre() ,dtousuario.getApellido(),
        dtousuario.getCargoActual(), dtousuario.getPhotoUrl,dtousuario.getBannerUrl(), dtousuario.getDescripcion());
        usuarioService.save(usuario);
        
        return new ResponseEntity(new Mensaje("Usuario agregada"), HttpStatus.OK);
    }*/
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoUsuario dtousuario){
        //Validamos si existe el ID
        if(!usuarioService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de usuarios
        if(usuarioService.existsByNombre(dtousuario.getNombre()) && usuarioService.getByNombre(dtousuario.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese Usuario ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtousuario.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Usuario usuario = usuarioService.getOne(id).get();
        usuario.setNombre(dtousuario.getNombre());
        usuario.setApellido(dtousuario.getApellido());
        usuario.setCargoActual(dtousuario.getCargoActual());
        usuario.setPhotoUrl(dtousuario.getPhotoUrl());
        usuario.setBannerUrl(dtousuario.getBannerUrl());
        usuario.setDescripcion(dtousuario.getDescripcion());
        
        usuarioService.save(usuario);
        return new ResponseEntity(new Mensaje("Usuario actualizado"), HttpStatus.OK);
             
    }
}
