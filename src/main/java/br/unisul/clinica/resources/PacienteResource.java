package br.unisul.clinica.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unisul.clinica.domain.Paciente;
import br.unisul.clinica.dto.PacienteDto;
import br.unisul.clinica.resources.utils.URL;
import br.unisul.clinica.services.PacienteService;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteResource {
	@Autowired
	private PacienteService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<PacienteDto>> findAll() {
		List<Paciente> lista = service.findAll();
		List<PacienteDto> listDto = new ArrayList<PacienteDto>();
		for (Paciente p : lista) {
			listDto.add(new PacienteDto(p));
		}
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Paciente obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Paciente> find(@PathVariable Integer id) {
		Paciente obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Paciente obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/filtro", method = RequestMethod.GET)
	public ResponseEntity<List<PacienteDto>> filtrarPorNome(@RequestParam(value = "nome", defaultValue = "") String nome) {
		List<PacienteDto> listaDto = new ArrayList<PacienteDto>();
		String nomeDecoded = URL.decodeParam(nome);
		List<Paciente> lista = service.findByNome(nomeDecoded);
		for (Paciente p : lista) {
			listaDto.add(new PacienteDto(p));
		}
		return ResponseEntity.ok().body(listaDto);
	}

}
