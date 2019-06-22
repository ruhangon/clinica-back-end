package br.unisul.clinica.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.clinica.domain.Medicamento;
import br.unisul.clinica.domain.Medico;
import br.unisul.clinica.domain.Paciente;
import br.unisul.clinica.repositories.MedicamentoRepository;
import br.unisul.clinica.repositories.MedicoRepository;
import br.unisul.clinica.repositories.PacienteRepository;

@Service
public class DbService {
	@Autowired
	private MedicamentoRepository medicamentoRep;

	@Autowired
	private MedicoRepository medicoRep;

	@Autowired
	private PacienteRepository pacienteRep;

	public void inicializaBancoDeDados() throws ParseException {

		Medicamento medicamento1 = new Medicamento(null, "Diamox", "para coração", 50);
		Medicamento medicamento2 = new Medicamento(null, "Neuleptil", "para dar sono", 30);
		Medicamento medicamento3 = new Medicamento(null, "Dorflex", "para dor", 10);
		Medicamento medicamento4 = new Medicamento(null, "Dipirona", "para dor", 15);
		Medicamento medicamento5 = new Medicamento(null, "Ibuprofeno", "Para dor", 20);

		Medico medico1 = new Medico(null, "Paulo da Silva", "cardiologista");
		Medico medico2 = new Medico(null, "Luiz Dias", "ortopedista");
		Medico medico3 = new Medico(null, "Osvaldo Rodrigues", "pediatra");

		Paciente p1 = new Paciente(null, "Claudio da Silva", "Masculino", medicamento1, medico1);
		Paciente p2 = new Paciente(null, "Bruna Souza", "Feminino", medicamento3, medico2);
		medicamento1.getPacientes().addAll(Arrays.asList(p1));
		medico1.getPacientes().addAll(Arrays.asList(p1));
		medicamento3.getPacientes().addAll(Arrays.asList(p2));
		medico2.getPacientes().addAll(Arrays.asList(p2));

		medicamentoRep.saveAll(Arrays.asList(medicamento1, medicamento2, medicamento3, medicamento4, medicamento5));
		medicoRep.saveAll(Arrays.asList(medico1, medico2, medico3));
		pacienteRep.saveAll(Arrays.asList(p1, p2));

	}

}
