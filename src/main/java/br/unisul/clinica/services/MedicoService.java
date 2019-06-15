package br.unisul.clinica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.clinica.domain.Medico;
import br.unisul.clinica.repositories.MedicoRepository;

@Service
public class MedicoService {
	@Autowired
	private MedicoRepository rep;

	public Medico find(Integer id) {
		Optional<Medico> obj = rep.findById(id);
		return obj.orElse(null);
	}

	public Medico insert(Medico obj) {
		obj.setId(null);
		return rep.save(obj);
	}

	public Medico update(Medico obj) {
		find(obj.getId());
		return rep.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		rep.deleteById(id);
	}

	public List<Medico> findAll() {
		return rep.findAll();
	}

}
