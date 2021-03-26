package br.com.avaliacao.tinnova.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.avaliacao.tinnova.domain.Veiculos;
import br.com.avaliacao.tinnova.dto.VeiculosDTO;
import br.com.avaliacao.tinnova.repository.VeiculosRepository;
import br.com.avaliacao.tinnova.services.exception.ObjectNotFoundException;

@Service
public class VeiculosService {
	
	@Autowired
	private VeiculosRepository repo;

	//Retorna todos os dados do veiculo
	public List<Veiculos> findAll() {
		return repo.findAll();
	}
	
	//Retorna os dados do veiculo por id
	public Veiculos findById(String id) {
		Optional<Veiculos> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	//Insere novo veiculo
	public Veiculos insert(Veiculos obj) {
		return repo.insert(obj);
	}
	
	//Deleta veiculo
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	//Atualiza o veiculo
	public Veiculos update(Veiculos obj) {
		Veiculos newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
		}
	
	
	//Insere os dados no obj
	private void updateData(Veiculos newObj, Veiculos obj) {
		newObj.setVeiculo(obj.getVeiculo());
		newObj.setMarca(obj.getMarca());
		newObj.setAno(obj.getAno());
		newObj.setDescricao(obj.getDescricao());
		newObj.setVendido(obj.isVendido());
		newObj.setCreated(obj.getCreated());
		newObj.setUpdated(obj.getUpdated());
		
		}

	
	public Veiculos fromDTO(VeiculosDTO objDto) {
		return new Veiculos(objDto.getId(), objDto.getVeiculo(), objDto.getMarca(), objDto.getAno(), objDto.getDescricao(), 
				objDto.isVendido(), objDto.getCreated(), objDto.getUpdated());
	}
	
	
	
}
