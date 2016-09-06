package com.hmw;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hmw.model.Exame;
import com.hmw.model.Usuario;
import com.hmw.repository.UsuarioRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Derms4Application.class)
@WebAppConfiguration
public class Derms4ApplicationTests {
	@Autowired
	UsuarioRepository repositorio;
	
	@Test
	public void inserirExame() {
		try {
			Usuario usuario = new Usuario();
			usuario.setNome("testando exames");
			Exame exame1 = new Exame();
			exame1.setDescricao("teste 1");
			exame1.setRequisitante(usuario);
//			exame1.setLaudador(usuario);
			Exame exame2 = new Exame();
			exame2.setDescricao("teste 2");
			exame2.setRequisitante(usuario);
			usuario.getExames().add(exame1);
			usuario.getExames().add(exame2);
			repositorio.save(usuario);
			
			System.out.println("foi");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
