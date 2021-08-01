package br.edu.ifpb.gps.planner.Planner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.gps.planner.Planner.model.Usuario;
import br.edu.ifpb.gps.planner.Planner.service.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
    private UsuarioService usuarioService;

	@RequestMapping(value = "/usuario/info", method = RequestMethod.GET)
	public String info() {
		return "App is up...";
	}

    @RequestMapping(value = "/usuario/createusuario", method = RequestMethod.POST)
    public String createUsuario(@RequestBody Usuario usuario){
        return usuarioService.createUsuario(usuario);
    }

    @RequestMapping(value = "/usuario/readusuarios", method = RequestMethod.GET)
    public List<Usuario> readUsuarios(){
        return usuarioService.readUsuarios();
    }

    @RequestMapping(value = "/usuario/updateusuario", method = RequestMethod.PUT)
    public String updateUsuario(@RequestBody Usuario usuario){
        return usuarioService.updateUsuario(usuario);
    }

    @RequestMapping(value = "/usuario/deleteusuario", method = RequestMethod.DELETE)
    public String deleteUsuario(@RequestBody Usuario usuario){
        return usuarioService.deleteUsuario(usuario);
    }
    
    @RequestMapping(value = "/usuario/deleteallusuario", method = RequestMethod.DELETE)
    public String deleteAllUsuario(){
        return usuarioService.deleteAllUsuario();
    }
}
