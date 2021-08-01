package br.edu.ifpb.gps.planner.Planner.service;

import java.io.Console;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.gps.planner.Planner.model.Usuario;
import br.edu.ifpb.gps.planner.Planner.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public String createUsuario(Usuario Usuario){
        try {
            if (!usuarioRepository.existsByEmail(Usuario.getEmail())){
                Usuario.setId(null == usuarioRepository.findMaxId()? 0 : usuarioRepository.findMaxId() + 1);
                usuarioRepository.save(Usuario);
                return "Usuario record created successfully.";
            }else {
                return "Usuario already exists in the database.";
            }
        }catch (Exception e){
            throw e;
        }

    }

    public List<Usuario> readUsuarios(){
        return usuarioRepository.findAll();
    }

    @Transactional
    public String updateUsuario(Usuario Usuario){
        if (usuarioRepository.existsByEmail(Usuario.getEmail())){
            try {
                List<Usuario> Usuarios = usuarioRepository.findByEmail(Usuario.getEmail());
                Usuarios.stream().forEach(s -> {
                    Usuario UsuarioToBeUpdate = usuarioRepository.findById(s.getId()).get();
                    UsuarioToBeUpdate.setName(Usuario.getName());
                    UsuarioToBeUpdate.setEmail(Usuario.getEmail());
                    UsuarioToBeUpdate.setPassword(Usuario.getPassword());
                    usuarioRepository.save(UsuarioToBeUpdate);
                });
                return "Usuario record updated.";
            }catch (Exception e){
                throw e;
            }
        }else {
            return "Usuario does not exists in the database.";
        }
    }

    @Transactional
    public String deleteUsuario(Usuario Usuario){
        if (usuarioRepository.existsByEmail(Usuario.getEmail())){
            try {
                List<Usuario> Usuarios = usuarioRepository.findByEmail(Usuario.getEmail());
                Usuarios.stream().forEach(s -> {
                    usuarioRepository.delete(s);
                });
                return "Usuario record deleted successfully.";
            }catch (Exception e){
                throw e;
            }

        }else {
            return "Usuario does not exist";
        }
    }
    
    @Transactional
    public String deleteAllUsuario(){

                List<Usuario> Usuarios = usuarioRepository.findAll();
                Usuarios.stream().forEach(s -> {
                    usuarioRepository.delete(s);
                });
                return "All Usuario record deleted successfully.";
                
    }
}

