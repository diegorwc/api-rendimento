package com.dio.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.model.Indice;
import com.dio.repository.IndiceRepository;
import com.dio.service.BrasilAPIService;
import com.dio.service.IndiceService;

@Service
public class ServiceImpl implements IndiceService {
	
	@Autowired
	private IndiceRepository indiceRepository;
	@Autowired
	private BrasilAPIService brasilApiService;
	
	@Override
	public Iterable<Indice> buscarTodos() {
		return indiceRepository.findAll();
	}

	@Override
	public Optional<Indice> buscarPorIndice(String indice) {
		Optional<Indice> indiceRecuperado = Optional.of(indiceRepository.findById(indice).orElseGet(() -> {
			return buscaIndiceNaApi(indice);
		}));
		return indiceRecuperado;
	}

	@Override
	public Indice inserir(String nomeIndice) {				
		return buscaIndiceNaApi(nomeIndice);
	}

	@Override
	public boolean deletar(String id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private Indice buscaIndiceNaApi(String nomeIndice) {
		Indice novoIndice = brasilApiService.consultarIndice(nomeIndice.replaceAll("\"", ""));
		indiceRepository.save(novoIndice);
		return novoIndice;
	}
}
