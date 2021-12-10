package br.edu.infnet.VenturaHR_Web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.infnet.VenturaHR_Web.model.Usuario;
import br.edu.infnet.VenturaHR_Web.repository.usuario.UsuarioService;


@Controller
public class UsuarioController {
	

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value = "/")
	public String telaIndex( ) {
		return "index";
	}
	
	@GetMapping(value = "/candidato")
	public String telaCadastroC(Usuario usuario) {
		return "candidato/cadastrocandidato";
	}
	@GetMapping(value = "/empresa")
	public String telaCadastroE(Usuario usuario) {
		return "empresa/cadastroempresa";
	}
	
	@PostMapping(value = "/cadastro")
	public ModelAndView cadastrarConta(@Valid Usuario usuario, BindingResult br) {
		ModelAndView retorno = new ModelAndView("index");
		if (br.hasErrors()) {
			retorno.addObject("erros", br.getFieldErrors());
		} else {
			Usuario cadastrado = usuarioService.inserirUsuario(usuario);
			String rota = "";
			switch (usuario.getTipo()) {
				case 'E':
					rota = "index";
					break;
	
				case 'C':
					rota = "index";
					break;
			}
			retorno.setViewName(rota);
			retorno.addObject("usuario", cadastrado);
		}
		return retorno;
	}
	
	@PostMapping(value = "/login")
	public ModelAndView telaLogin(String email, String senha) {
		
		ModelAndView retorno = new ModelAndView("index");
		
		if (org.apache.commons.lang3.StringUtils.isNotBlank(email) && org.apache.commons.lang3.StringUtils.isNotBlank(senha)) {        
			Usuario usuario = new Usuario();
            try{
                usuario = usuarioService.obterPorEmail(email);
            }catch(Exception e){
            }
            String rota = "index";

			if (usuario != null && senha.equals(usuario.getSenha())) {
				switch (usuario.getTipo()) {
					case 'E':
						rota = "empresa/empresa";
						break;
					case 'C':
						rota = "candidato/usuario";
						break;
				}
				retorno.setViewName(rota);
				retorno.addObject("usuario", usuario);
			} else {
				retorno.addObject("erro", "O login esta inválido porfavor verifique novamente!");
			}
		} else {
			retorno.addObject("erro", "Os campos são obrigatórios porfavor digite novamente");
		}	
		return retorno;
	}
	
	@GetMapping(value = "/login/autenticacaoC")
	public String telaRetornoCandidato( ) {
		return "index";
	}
	@GetMapping(value = "/login/autenticacaoE")
	public String telaRetornoEmpresa( ) {
		return "index";
	}
}
