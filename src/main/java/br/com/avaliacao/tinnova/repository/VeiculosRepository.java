package br.com.avaliacao.tinnova.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.avaliacao.tinnova.domain.Veiculos;

@Repository
public interface VeiculosRepository extends MongoRepository<Veiculos, String>{
		
}
