package br.com.avaliacao.tinnova.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.avaliacao.tinnova.domain.Veiculos;
import br.com.avaliacao.tinnova.repository.VeiculosRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private VeiculosRepository veiculosRepository;

	@Override
	public void run(String... args) throws Exception {
		
		veiculosRepository.deleteAll();
		
		Veiculos v1 = new Veiculos(null, "HB20", "Hyundai", 2014, "Hyundai HB20 2014" , false, null, null);
		Veiculos v2 = new Veiculos(null, "i30", "Hyundai", 2017, "Hyundai i30 2017" , true, null, null);
		Veiculos v3 = new Veiculos(null, "ix35", "Hyundai", 2016, "Hyundai ix35 2016" , false, null, null);
		
		veiculosRepository.saveAll(Arrays.asList(v1, v2, v3));
		
		
		
		
	}

	
}
