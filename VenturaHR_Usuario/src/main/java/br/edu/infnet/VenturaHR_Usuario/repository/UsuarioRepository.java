package br.edu.infnet.VenturaHR_Usuario.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.VenturaHR_Usuario.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
    
//	 @Query("from Usuario u where u.email = :email and u.senha = :senha")
//	    public Usuario user(String email, String senha);

	 @Query("from Usuario usuarios where usuarios.email =:email")
		public Usuario findByEmail(String email);
	    
	 
}
