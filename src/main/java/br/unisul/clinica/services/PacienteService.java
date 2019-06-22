package br.unisul.clinica.services;

import java.util.List;

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

}
