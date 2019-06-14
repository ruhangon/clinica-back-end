package br.unisul.clinica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.clinica.domain.Medicamento;
import br.unisul.clinica.repositories.MedicamentoRepository;

@Service
public class MedicamentoService {
	@Autowired
	private MedicamentoRepository rep;

	public Medicamento find(Integer id) {
		Optional<Medicamento> obj = rep.findById(id);
		return obj.orElse(null);
	}

	public Medicamento insert(Medicamento obj) {
		obj.setId(null);
		return rep.save(obj);
	}

	public Medicamento update(Medicamento obj) {
		find(obj.getId());
		return rep.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		rep.deleteById(id);
	}

	public List<Medicamento> findAll() {
		return rep.findAll();
	}

}
