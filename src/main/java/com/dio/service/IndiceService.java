package com.dio.service;

import java.util.Optional;

import com.dio.model.Indice;

public interface IndiceService {

	Iterable<Indice> buscarTodos();
	Optional<Indice> buscarPorIndice(String indice);
	
	Indice inserir(String indice);
	boolean deletar(String id);
}
