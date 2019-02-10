package coop.tecso.examen.repository;

import coop.tecso.examen.model.CuentaCorriente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaCorrienteRepository extends JpaRepository<CuentaCorriente, Long> {
}
