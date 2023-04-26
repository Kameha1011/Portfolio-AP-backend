
package com.portfolio.omar.Controller;

import com.portfolio.omar.Dto.DtoExperiencia;
import com.portfolio.omar.Entity.Experiencia;
import com.portfolio.omar.Security.Controller.Mensaje;
import com.portfolio.omar.Service.SExperiencia;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("/explab")
@CrossOrigin(origins = {"https://portfolio-frontend-ap-70cb5.web.app","http://localhost:4200"})
public class CExperiencia {
    @Autowired
    SExperiencia sExperiencia;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
     @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = sExperiencia.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sExperiencia.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sExperiencia.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoexp){      
        if(StringUtils.isBlank(dtoexp.getNombreEmpresa()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sExperiencia.existsByNombreEmpresa(dtoexp.getNombreEmpresa()))
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = new Experiencia(dtoexp.getNombreEmpresa() ,dtoexp.getDescripcion());
        sExperiencia.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoexp){
        //Validamos si existe el ID
        if(!sExperiencia.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(sExperiencia.existsByNombreEmpresa(dtoexp.getNombreEmpresa()) && sExperiencia.getByNombreEmpresa(dtoexp.getNombreEmpresa()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoexp.getNombreEmpresa()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Experiencia experiencia = sExperiencia.getOne(id).get();
        experiencia.setNombreEmpresa(dtoexp.getNombreEmpresa());
        experiencia.setDescripcion((dtoexp.getDescripcion()));
        
        sExperiencia.save(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
             
    }
}
