package br.unisul.clinica.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.clinica.domain.Medicamento;
import br.unisul.clinica.domain.Medico;
import br.unisul.clinica.repositories.MedicamentoRepository;
import br.unisul.clinica.repositories.MedicoRepository;

@Service
public class DbService {
	@Autowired
	private MedicamentoRepository medicamentoRep;

	@Autowired
	private MedicoRepository medicoRep;

	public void inicializaBancoDeDados() throws ParseException {

		Medicamento medicamento1 = new Medicamento(null, "Diamox", "para coração", 50);
		Medicamento medicamento2 = new Medicamento(null, "Neuleptil", "para dar sono", 30);
		Medicamento medicamento3 = new Medicamento(null, "Dorflex", "para dor", 10);
		Medicamento medicamento4 = new Medicamento(null, "Dipirona", "para dor", 15);
		Medicamento medicamento5 = new Medicamento(null, "Ibuprofeno", "Para dor", 20);

		Medico medico1 = new Medico(null, "Paulo da Silva", "cardiologista");
		Medico medico2 = new Medico(null, "Luiz Dias", "ortopedista");
		Medico medico3 = new Medico(null, "Osvaldo Rodrigues", "pediatra");

		medicamentoRep.saveAll(Arrays.asList(medicamento1, medicamento2, medicamento3, medicamento4, medicamento5));
		medicoRep.saveAll(Arrays.asList(medico1, medico2, medico3));

	}

}
