package com.dio.controller;

import java.text.DecimalFormat;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.model.Indice;
import com.dio.service.IndiceService;

@RestController
@RequestMapping("indices")
public class IndiceRestController {

	@Autowired
	private IndiceService indiceService;
	
	@GetMapping
	public ResponseEntity<Iterable<Indice>> buscarTodos() {
		return ResponseEntity.ok(indiceService.buscarTodos());
	}
	
	@GetMapping("/{indice}")
	public ResponseEntity<Optional<Indice>> retornaIndice(@PathVariable String indice) {
		return ResponseEntity.ok(indiceService.buscarPorIndice(indice));
	}
	
	@PostMapping("/rendimento")
	public ResponseEntity<Double> retornaRendimento(@RequestBody String indice, double valor) {		
		Indice taxa = indiceService.buscarPorIndice(indice).get();		
		double calculo = valor * (taxa.getValor() / 100);
		DecimalFormat df = new DecimalFormat("0.00");		
		return ResponseEntity.ok(Double.valueOf(df.format(calculo).replace(",", ".")));
	}
	
	@PostMapping
	public ResponseEntity<Indice> inserir(@RequestBody String indice) {
		Indice novoIndice = indiceService.inserir(indice);
		return ResponseEntity.ok(novoIndice);
	}
	
}
