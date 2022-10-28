package com.dio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dio.model.Indice;

@Repository
public interface IndiceRepository extends CrudRepository<Indice, String>{

}
