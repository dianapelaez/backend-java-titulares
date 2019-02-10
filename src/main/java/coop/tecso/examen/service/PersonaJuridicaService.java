package coop.tecso.examen.service;


import coop.tecso.examen.model.PersonaJuridica;

import java.util.List;

public interface PersonaJuridicaService {
    /**
     * Ingresa un nuevo registro o actualiza uno ya existente
     * @param persona
     * @return El usuario guardado
     */
    public PersonaJuridica save(PersonaJuridica personaJuridica);

    /**
     * Recupera la lista de usuarios
     *
     * @return La lista de usuarios
     */
    public List<PersonaJuridica> findAll();

    /**
     * Borra el usuario enviado
     *
     * @param persona
     */
    public void delete(PersonaJuridica personaJuridica);

    /**
     * Borra la persona por id
     *
     * @param Id
     */
    public void deleteById(Long id);
}
