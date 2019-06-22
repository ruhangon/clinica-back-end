package br.unisul.clinica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unisul.clinica.domain.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
	@Transactional(readOnly = true)
	@Query("select obj from Paciente obj where obj.medicamento.id = :medicamentoId")
	public List<Paciente> findMedicamentoPaciente(@Param("medicamentoId") Integer medicamento_id);

	@Transactional(readOnly = true)
	@Query("select obj from Paciente obj where obj.medico.id = :medicoId")
	public List<Paciente> findMedicoPaciente(@Param("medicoId") Integer medico_id);

}
