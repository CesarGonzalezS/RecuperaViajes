package mx.edu.utez.RecuperaViajes.service.Viajes;


import mx.edu.utez.RecuperaViajes.models.Viajes.Viajes;
import mx.edu.utez.RecuperaViajes.models.Viajes.ViajesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Transactional
@Service
public class ViajesServices {
    @Autowired
    private ViajesRepository viajesRepository;
    @Transactional(readOnly = true)
    public ResponseEntity<List<Viajes>> getAll(){
        return new ResponseEntity<>(this.viajesRepository.findAll(), HttpStatus.OK);
    }
    @Transactional(readOnly = true)
    public ResponseEntity getOne(Long id){
        return new ResponseEntity<Object>(this.viajesRepository.findById(id), HttpStatus.OK);
    }

    @Transactional
    public Viajes saveVi(Viajes viajes) {
        return viajesRepository.save(viajes);
    }

    @Transactional
    public Viajes
    updateVi(Viajes viajes, Long Id) {
        Viajes depDB = viajesRepository.findById(Id).get();
        if (Objects.nonNull(viajes.getArrival()) && !"".equalsIgnoreCase(viajes.getArrival())) {
            depDB.setArrival(viajes.getArrival());
        }
        if (Objects.nonNull(viajes.getDesparture()) && !"".equalsIgnoreCase(viajes.getDesparture())) {
            depDB.setDesparture(viajes.getDesparture());
        }
        return viajesRepository.save(depDB);
    }

    @Transactional
    public void deleteById(Long Id) {
        viajesRepository.deleteById(Id);
    }

}






