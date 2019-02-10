package coop.tecso.examen.repository;

import coop.tecso.examen.model.PersonaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaJuridicaRepository extends JpaRepository<PersonaJuridica, Long> {
}
