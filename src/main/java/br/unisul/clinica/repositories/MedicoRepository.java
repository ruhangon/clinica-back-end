package br.unisul.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unisul.clinica.domain.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
