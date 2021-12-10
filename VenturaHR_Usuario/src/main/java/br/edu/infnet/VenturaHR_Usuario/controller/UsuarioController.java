package br.edu.infnet.VenturaHR_Usuario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.VenturaHR_Usuario.model.Usuario;
import br.edu.infnet.VenturaHR_Usuario.repository.UsuarioRepository;



@RestController
@RequestMapping(path = {"/usuarios"})
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private Usuario findById(int id) {
		
		Usuario retorno = null;
		try {
			retorno = usuarioRepository.findById(id).get();
		} catch (Exception e) {
		}
		
		return retorno;
	}
	
	
	@GetMapping(path = {"/{id}"})
	public ResponseEntity<Usuario> obterPorId(@PathVariable int id) {
		
		ResponseEntity<Usuario> retorno = ResponseEntity.notFound().build();
		Usuario usuario = this.findById(id);
		if (usuario != null) {
			retorno = ResponseEntity.ok().body(usuario);
		}
		return retorno;
	}
	
	@GetMapping(path = {"/email/{email}"})
	public ResponseEntity<Usuario> obterPorEmail(@PathVariable String email) {
		
		ResponseEntity<Usuario> retorno = ResponseEntity.notFound().build();
		try {
			Usuario usuario = usuarioRepository.findByEmail(email);
			if (usuario != null) {
				retorno = ResponseEntity.ok().body(usuario);
			}		
		} catch (Exception e) {
		}
		return retorno;
	}
	
	@PostMapping
	public ResponseEntity<Usuario> adicionarUsuario(@RequestBody Usuario usuario) {
		
		ResponseEntity<Usuario> retorno = ResponseEntity.badRequest().build();
		if (usuario != null && usuario.getId() == null) {
			
			Usuario usuarioAdicionado = usuarioRepository.save(usuario);
			retorno = ResponseEntity.ok().body(usuarioAdicionado);
		}
		return retorno;
	}
	
	@PutMapping
	public ResponseEntity<Usuario> atualizarUsuario(@RequestBody Usuario usuario) {
		
		ResponseEntity<Usuario> retorno = ResponseEntity.badRequest().build();
		if (usuario != null && usuario.getId() != null) {
			
			Usuario usuarioGravado = this.findById(usuario.getId());
			if (usuarioGravado != null) {
				
				try {
					usuarioGravado = usuarioRepository.save(usuario);
					retorno = ResponseEntity.ok().body(usuarioGravado);
					
				} catch (Exception e) {
				}	
			}
		}		
        if (usuario != null && usuario.getId() == null) {
            Usuario usuarioInserido = usuarioRepository.save(usuario);
            retorno = ResponseEntity.ok().body(usuarioInserido);
        }		
		return retorno;
	}
    
}