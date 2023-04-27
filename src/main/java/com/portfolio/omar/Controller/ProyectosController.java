
package com.portfolio.omar.Controller;

import com.portfolio.omar.Dto.DtoProyectos;
import com.portfolio.omar.Entity.Proyectos;
import com.portfolio.omar.Security.Controller.Mensaje;
import com.portfolio.omar.Service.ProyectosService;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author omrfl
 */
@RestController
@RequestMapping("proyectos")
@CrossOrigin(origins = {"https://portfolio-frontend-ap-70cb5.web.app","http://localhost:4200"})
public class ProyectosController {
     @Autowired
    ProyectosService proyectosService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = proyectosService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
     @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id){
        if(!proyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyectos proyecto = proyectosService.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!proyectosService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        proyectosService.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyectos dtoproy){      
        if(StringUtils.isBlank(dtoproy.getNombreProy()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(proyectosService.existsByNombreProy(dtoproy.getNombreProy()))
            return new ResponseEntity(new Mensaje("Ese Proyectos existe"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyecto = new Proyectos(dtoproy.getNombreProy() ,dtoproy.getDescripcion(),dtoproy.getImgUrl(),dtoproy.getGitHubUrl(), dtoproy.getProyectUrl());
        proyectosService.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyectos dtoproy){
        //Validamos si existe el ID
        if(!proyectosService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de educaciones
        if(proyectosService.existsByNombreProy(dtoproy.getNombreProy()) && proyectosService.getByNombreProy(dtoproy.getNombreProy()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese Proyecto ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoproy.getNombreProy()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyectos proyecto = proyectosService.getOne(id).get();
        proyecto.setNombreProy(dtoproy.getNombreProy());
        proyecto.setDescripcion(dtoproy.getDescripcion());
        proyecto.setImgUrl(dtoproy.getImgUrl());
        proyecto.setGitHubUrl(dtoproy.getGitHubUrl());
        proyecto.setProyectUrl(dtoproy.getProyectUrl());
        
        proyectosService.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
             
    }
}
