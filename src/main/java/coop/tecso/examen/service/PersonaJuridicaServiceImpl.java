package coop.tecso.examen.service;

import coop.tecso.examen.model.PersonaJuridica;
import coop.tecso.examen.repository.PersonaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaJuridicaServiceImpl implements PersonaJuridicaService {

    @Autowired
    private PersonaJuridicaRepository personaJuridicaRepository;

    @Override
    public PersonaJuridica save(PersonaJuridica personaJuridica) {
        return personaJuridicaRepository.save(personaJuridica);
    }

    @Override
    public List<PersonaJuridica> findAll() {
        return personaJuridicaRepository.findAll();
    }

    @Override
    public void delete(PersonaJuridica personaJuridica) {
        personaJuridicaRepository.delete(personaJuridica);
    }

    @Override
    public void deleteById(Long id) {
        personaJuridicaRepository.deleteById(id);
    }
}
