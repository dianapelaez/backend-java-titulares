package coop.tecso.examen.service;


import coop.tecso.examen.model.CuentaCorriente;
import coop.tecso.examen.util.CuentaCorrienteConMovimientosException;
import coop.tecso.examen.util.DescubiertoException;

import java.util.List;

public interface CuentaCorrienteService {
    /**
     * Ingresa un nuevo registro o actualiza uno ya existente
     * @param persona
     * @return El usuario guardado
     */
    public CuentaCorriente save(CuentaCorriente cuentaCorriente) throws DescubiertoException;

    /**
     * Recupera la lista de usuarios
     *
     * @return La lista de usuarios
     */
    public List<CuentaCorriente> findAll();

    /**
     * Recupera una cuenta por Id
     *
     * @return La lista de usuarios
     */
    public CuentaCorriente findById(Long id);

    /**
     * Borra el usuario enviado
     *
     * @param cuentaCorriente
     */
    public void delete(CuentaCorriente cuentaCorriente) throws CuentaCorrienteConMovimientosException;
}
