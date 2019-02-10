package coop.tecso.examen.service;

import coop.tecso.examen.model.PersonaFisica;
import coop.tecso.examen.repository.PersonaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaFisicaServiceImpl implements PersonaFisicaService {

    @Autowired
    private PersonaFisicaRepository personaFisicaRepository;

    @Override
    public PersonaFisica save(PersonaFisica personaFisica) {
        return personaFisicaRepository.save(personaFisica);
    }

    @Override
    public List<PersonaFisica> findAll() {
        return personaFisicaRepository.findAll();
    }

    @Override
    public void delete(PersonaFisica personaFisica) {
        personaFisicaRepository.delete(personaFisica);
    }

    @Override
    public void deleteById(Long id) {
        personaFisicaRepository.deleteById(id);
    }
}
