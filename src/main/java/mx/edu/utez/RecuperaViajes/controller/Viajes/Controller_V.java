package mx.edu.utez.RecuperaViajes.controller.Viajes;


import mx.edu.utez.RecuperaViajes.models.Viajes.Viajes;
import mx.edu.utez.RecuperaViajes.service.Viajes.ViajesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api-recupera/viajes")
@CrossOrigin(origins = {"*"})
public class Controller_V {
    @Autowired
    private ViajesServices viajesServices ;


    @GetMapping("/")
    public ResponseEntity<List<Viajes>> getAll(){
        return this.viajesServices.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id") Long id){
        return this.viajesServices.getOne(id);
    }

    @PostMapping("/")
    public  Viajes savePoke(
            @Valid @RequestBody Viajes viajes) {
        return viajesServices.saveVi(viajes);
    }
    @PutMapping("/{id}")
    public Viajes
    update(@RequestBody Viajes viajes, @PathVariable("id") Long Id) {
        return viajesServices.updateVi(viajes, Id);
    }


    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long Id) {
        viajesServices.deleteById(Id);
        return "Deleted Successfully";
    }
}
