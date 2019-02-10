package coop.tecso.examen.repository;

import coop.tecso.examen.model.PersonaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaFisicaRepository extends JpaRepository<PersonaFisica, Long> {
}
