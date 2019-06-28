package br.unisul.clinica.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.clinica.domain.Paciente;
import br.unisul.clinica.repositories.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository rep;

	@Autowired
	private MedicamentoService medicamentoService;

	@Autowired
	private MedicoService medicoService;

	public Paciente find(Integer id) {
		Optional<Paciente> obj = rep.findById(id);
		return obj.orElse(null);
	}

	public List<Paciente> findByMedicamento(Integer medicamentoId) {
		return rep.findMedicamentoPaciente(medicamentoId);
	}

	public List<Paciente> findByMedico(Integer medicoId) {
		return rep.findMedicoPaciente(medicoId);
	}

	public Paciente insert(Paciente obj) {
		obj.setId(null);
		obj.setMedicamento(medicamentoService.find(obj.getMedicamento().getId()));
		obj.setMedico(medicoService.find(obj.getMedico().getId()));
		obj = rep.save(obj);
		return obj;
	}

	public List<Paciente> findAll() {
		return rep.findAll();
	}

	public Paciente update(Paciente obj) {
		find(obj.getId());
		return rep.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		rep.deleteById(id);
	}

	public List<Paciente> findByNome(String nome) {
		return rep.findByPacienteContaining(nome);
	}

}
