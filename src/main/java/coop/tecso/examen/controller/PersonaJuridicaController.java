package coop.tecso.examen.controller;

import coop.tecso.examen.model.PersonaJuridica;
import coop.tecso.examen.service.PersonaJuridicaService;
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
public class PersonaJuridicaController {

    @Autowired
    protected PersonaJuridicaService personaJuridicaService;
    
    protected ObjectMapper mapper;

    @RequestMapping("/personajuridica")
    public List<PersonaJuridica> getAll() {
        return personaJuridicaService.findAll();
    }

    // Ingresar nuevo o actualizar existente
    @RequestMapping(value = "/personajuridica", method = RequestMethod.POST)
    public RestResponse saveOrUpdate(@RequestBody String personaJuridicaJson) throws JsonParseException, JsonMappingException, IOException{
    	    
        	this.mapper = new ObjectMapper();
        	
        	PersonaJuridica personaJuridica = this.mapper.readValue(personaJuridicaJson, PersonaJuridica.class);

        if(!validate(personaJuridica)){
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
                    "Los campos no están diligenciados");
        }

        personaJuridicaService.save(personaJuridica);

        return new RestResponse(HttpStatus.OK.value(), "Operación exitosa");
    }

    // Borrar persona por Id
    @RequestMapping(value = "/personajuridica/{id}", method = RequestMethod.DELETE)
    public void deleteById(@RequestBody Long id) {
        personaJuridicaService.deleteById(id);
    }
    
    private boolean validate(PersonaJuridica personaJuridica) {
        if (Objects.isNull(personaJuridica.getCuit()) ||
                Objects.isNull(personaJuridica.getRazon()) ||
                Objects.isNull(personaJuridica.getFundacion()) ) {
            return false;
        }

        return true;
    }
}
