package mx.edu.utez.RecuperaViajes.service.Usuarios;


import mx.edu.utez.RecuperaViajes.models.Usuarios.Usuarios;
import mx.edu.utez.RecuperaViajes.models.Usuarios.UsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class UsuariosServices {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<List<Usuarios>> getAll(){
        return new ResponseEntity<>(this.usuariosRepository.findAll(), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity getOne(Long id){
        return new ResponseEntity(this.usuariosRepository.findById(id),HttpStatus.OK);
    }
    @Transactional
    public Usuarios saveUsu(Usuarios usuarios)
    {
        return usuariosRepository.save(usuarios );
    }

    @Transactional
    public Usuarios
    updateUsu(Usuarios usuarios, Long Id) {
        Usuarios depDB = usuariosRepository.findById(Id).get();
        if (Objects.nonNull(usuarios.getName()) && !"".equalsIgnoreCase(usuarios.getName())) {
            depDB.setName(usuarios.getName());
        }
        if (Objects.nonNull(usuarios.getEmail()) && !"".equalsIgnoreCase(usuarios.getEmail())) {
            depDB.setEmail(usuarios.getEmail());
        }

        return usuariosRepository.save(depDB);
    }
    @Transactional
    public void deleteById(Long Id)
    {
        usuariosRepository.deleteById(Id);
    }
}