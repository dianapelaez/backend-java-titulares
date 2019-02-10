package coop.tecso.examen.service;


import coop.tecso.examen.model.PersonaFisica;

import java.util.List;

public interface PersonaFisicaService {
    /**
     * Ingresa un nuevo registro o actualiza uno ya existente
     * @param persona
     * @return El usuario guardado
     */
    public PersonaFisica save(PersonaFisica persona);

    /**
     * Recupera la lista de personas
     *
     * @return La lista de personas
     */
    public List<PersonaFisica> findAll();

    /**
     * Borra la persona enviado
     *
     * @param persona
     */
    public void delete(PersonaFisica persona);

    /**
     * Borra la persona por id
     *
     * @param Id
     */
    public void deleteById(Long id);
}
