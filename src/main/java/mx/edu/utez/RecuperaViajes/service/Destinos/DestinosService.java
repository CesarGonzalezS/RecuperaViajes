package mx.edu.utez.RecuperaViajes.service.Destinos;



import mx.edu.utez.RecuperaViajes.models.Destinos.Destinos;
import mx.edu.utez.RecuperaViajes.models.Destinos.DestinosRepository;
import mx.edu.utez.RecuperaViajes.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class DestinosService {
    @Autowired
    private DestinosRepository destinosRepository;


    @Transactional(readOnly = true)
    public ResponseEntity<List<Destinos>> getAll(){
        return new ResponseEntity<>(this.destinosRepository.findAll(), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity getOne(Long id){
        return new ResponseEntity(this.destinosRepository.findById(id),HttpStatus.OK);
    }
    @Transactional
    public Destinos saveDestino(Destinos destinos)
    {
        return destinosRepository.save(destinos);
    }

    @Transactional
    public Destinos
    updateDestino(Destinos destinos, Long Id) {
        Destinos depDB = destinosRepository.findById(Id).get();
        if (Objects.nonNull(destinos.getName()) && !"".equalsIgnoreCase(destinos.getName())) {
            depDB.setName(destinos.getName());
        }
        return destinosRepository.save(depDB);
    }

    @Transactional
    public void deleteById(Long Id)
    {
        destinosRepository.deleteById(Id);
    }
}


