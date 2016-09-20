package com.hmw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmw.dao.LaudosDAO;
import com.hmw.model.DetalheLaudo;
import com.hmw.model.Laudo;
import com.hmw.model.LaudoDetalheLaudo;
import com.hmw.model.SecaoLaudo;
import com.hmw.repository.DetalheLaudoRepository;
import com.hmw.repository.LaudoRepository;
import com.hmw.repository.SecaoLaudoRepository;
import com.hmw.vo.DetalheLaudoVO;
import com.hmw.vo.LaudoVO;

@Service
public class LaudoService {
	@Autowired
	LaudosDAO laudosDAO;

	@Autowired
	SecaoLaudoRepository secaoLaudoRepository;

	@Autowired
	LaudoRepository laudoRepository;

	@Autowired
	ExameService exameService;

	@Autowired
	DetalheLaudoRepository detalheLaudoRepository;

	public void cadastrarSecaoLaudo(SecaoLaudo secao) {
		secaoLaudoRepository.save(secao);
	}

	public List<LaudoVO> getLaudo(Integer exameId, Integer laudoId) {
		return laudosDAO.getLaudo(exameId, laudoId);
	}

	public Laudo cadastrar(LaudoVO laudo) {
		Laudo laudoCadastrar = new Laudo();
		laudoCadastrar.setConclusao(laudo.getConclusao());
		laudoCadastrar.setDescricaoEstudo(laudo.getDescricaoEstudo());
		laudoCadastrar.setExame(exameService.getOne(laudo.getExame().getId()));
		laudoCadastrar.setOutrasInformacoes(laudo.getOutrasInformacoes());
		laudoCadastrar.setTamanho(10);
		List<DetalheLaudoVO> distribuicao = laudo.getDistribuicao();
		LaudoDetalheLaudo laudoDetalheLaudo;
		for (DetalheLaudoVO detalheLaudoVO : distribuicao) {
			if (detalheLaudoVO.getMarcado()) {
				laudoDetalheLaudo = new LaudoDetalheLaudo();
				laudoDetalheLaudo.setDetalhelaudo(detalheLaudoRepository.getOne(detalheLaudoVO.getId()));
				laudoCadastrar.getDetalhelaudo().add(laudoDetalheLaudo);
			}
		}

		return laudoRepository.save(laudoCadastrar);
	}
}
