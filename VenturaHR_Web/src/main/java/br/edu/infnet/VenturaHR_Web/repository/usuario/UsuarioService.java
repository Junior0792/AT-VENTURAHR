package br.edu.infnet.VenturaHR_Web.repository.usuario;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import br.edu.infnet.VenturaHR_Web.model.Usuario;

@FeignClient(url = "http://localhost:8081/usuarios", name = "usuarioService")
public interface UsuarioService {

	@GetMapping(path = {"/email/{email}"})
	Usuario obterPorEmail(@PathVariable String email);
	
	@PostMapping
	Usuario inserirUsuario(Usuario usuario);
		
	@PutMapping
	Usuario atualizarUsuario(Usuario usuario);
}