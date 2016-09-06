package com.hmw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hmw.model.Imagem;
import com.hmw.service.ExameService;
import com.hmw.service.ImagemService;
import com.hmw.vo.ExameVO;
import com.hmw.vo.ImagemVO;
import com.hmw.vo.PacienteVO;

@Controller
public class ImagensController {
	@Autowired
	ImagemService imagemService;

	@Autowired
	ExameService exameService;

	@RequestMapping("/imagens")
	public String irParaUpload() {
		return "imagens";
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/imagens/{idExame}/{idFoto}", method = { RequestMethod.POST })
	public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile multipart, @PathVariable Integer idExame,
			@PathVariable Long idFoto) {
		try {
			Imagem imagem = new Imagem();
			imagem.setDetalheImagem(exameService.getDetalheImagem(idFoto));
			imagem.setImg(multipart.getBytes());
			imagem.setExame(exameService.localizarObj(idExame));

			imagemService.cadastrar(imagem);
			return new ResponseEntity<>("Imagem carregada com sucesso.", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
/*
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/imagens/{idExame}", method = { RequestMethod.GET })
	public ResponseEntity<ExameVO> getImgsExame(@PathVariable Integer idExame) {
		ExameVO exameComImagens = imagemService.getImgsExame(idExame);
		return new ResponseEntity<>(exameComImagens, HttpStatus.OK);
	}*/
}
