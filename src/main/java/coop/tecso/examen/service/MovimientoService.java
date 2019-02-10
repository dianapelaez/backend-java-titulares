package coop.tecso.examen.service;


import coop.tecso.examen.model.Movimiento;
import coop.tecso.examen.util.DescubiertoException;

import java.util.List;

public interface MovimientoService {
    /**
     * Ingresa un nuevo registro o actualiza uno ya existente
     * @param persona
     * @return El movimiento guardado
     */
    public Movimiento save(Movimiento movimiento) throws DescubiertoException;

    /**
     * Recupera la lista de movimientos
     *
     * @return La lista de movimientos
     */
    public List<Movimiento> findAll();

    /**
     * Recupera los movimientos para una cuenta
     *
     * @return La lista de movimientos
     */
    public List<Movimiento> findByCuentaCorrienteId(Long idCuenta);

}
