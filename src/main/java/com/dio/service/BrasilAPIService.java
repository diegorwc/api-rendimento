package com.dio.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dio.model.Indice;

@FeignClient(name = "brasilApiIndices", url = "https://brasilapi.com.br/api/taxas/v1")
public interface BrasilAPIService {

	@GetMapping("/{indice}")
	Indice consultarIndice(@PathVariable("indice") String indice);
}
