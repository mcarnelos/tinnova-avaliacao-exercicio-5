package br.com.avaliacao.tinnova.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.avaliacao.tinnova.domain.Veiculos;
import br.com.avaliacao.tinnova.dto.VeiculosDTO;
import br.com.avaliacao.tinnova.services.VeiculosService;

@RestController
@RequestMapping(value="/veiculos")
public class VeiculosResource {
	
	@Autowired
	private VeiculosService service;
	
	//Endpoint /veiculos Get
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<VeiculosDTO>> findAll(){
		List<Veiculos> list = service.findAll();
		List<VeiculosDTO> listDto = list.stream().map(x -> new VeiculosDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	//Endpoint /id Get
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<VeiculosDTO> findById(@PathVariable String id){
		Veiculos obj = service.findById(id);
		return ResponseEntity.ok().body(new VeiculosDTO(obj));
	}
	
	//Endpoint Post
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody VeiculosDTO objDto){
		Veiculos obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//Endpoint /id Delete
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	//Endpoint /id Put
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody VeiculosDTO objDto, @PathVariable String id){
		Veiculos obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	}
	

