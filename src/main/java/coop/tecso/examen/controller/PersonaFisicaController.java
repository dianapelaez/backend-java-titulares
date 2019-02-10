package coop.tecso.examen.controller;

import coop.tecso.examen.model.PersonaFisica;
import coop.tecso.examen.model.PersonaJuridica;
import coop.tecso.examen.service.PersonaFisicaService;
import coop.tecso.examen.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class PersonaFisicaController {

    @Autowired
    protected PersonaFisicaService personaFisicaService;
    
    protected ObjectMapper mapper;

    @RequestMapping("/personafisica")
    public List<PersonaFisica> getAll() {
        return personaFisicaService.findAll();
    }

    // Ingresar nuevo o actualizar existente
    @RequestMapping(value = "/personafisica", method = RequestMethod.POST)
    public RestResponse saveOrUpdate(@RequestBody String personaFisicaJson) throws JsonParseException, JsonMappingException, IOException {
    	
        this.mapper = new ObjectMapper();
    	
    	PersonaFisica personaFisica = this.mapper.readValue(personaFisicaJson, PersonaFisica.class);
    	
        if(!validate(personaFisica)){
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
                    "Los campos no están diligenciados");
        }

        personaFisicaService.save(personaFisica);

        return new RestResponse(HttpStatus.OK.value(), "Operación exitosa");
    }

    @RequestMapping(value = "/personafisica/{id}", method = RequestMethod.DELETE)
    public void delete(@RequestBody Long id) {
        personaFisicaService.deleteById(id);
    }
    
    private boolean validate(PersonaFisica personaFisica) {
        if (Objects.isNull(personaFisica.getDNI()) ||
                Objects.isNull(personaFisica.getCuit()) ||
                Objects.isNull(personaFisica.getNombre()) ||
                Objects.isNull(personaFisica.getApellido()) ) {
            return false;
        }

        return true;
    }
}
