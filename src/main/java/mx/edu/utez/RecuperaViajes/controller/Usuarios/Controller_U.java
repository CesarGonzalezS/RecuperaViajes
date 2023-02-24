package mx.edu.utez.RecuperaViajes.controller.Usuarios;


import mx.edu.utez.RecuperaViajes.models.Usuarios.Usuarios;
import mx.edu.utez.RecuperaViajes.service.Usuarios.UsuariosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-recupera/usuarios")
@CrossOrigin(origins = {"*"})
public class Controller_U {
    @Autowired
    private UsuariosServices services;


    @GetMapping("/")
    public ResponseEntity<List<Usuarios>> getAll(){
        return this.services.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id") Long id){
        return this.services.getOne(id);
    }

    @PostMapping("/")
    public Usuarios saveUsu(
            @Valid @RequestBody Usuarios usuarios)
    {
        return services.saveUsu(usuarios);
    }
    @PutMapping("/{id}")
    public Usuarios
    update(@RequestBody Usuarios usuarios,
           @PathVariable("id") Long Id)
    {
        return services.updateUsu(
                usuarios, Id);
    }

    // Delete operation
    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id")
                             Long Id)
    {
        services.deleteById(
                Id);
        return "Deleted Successfully";
    }


}


