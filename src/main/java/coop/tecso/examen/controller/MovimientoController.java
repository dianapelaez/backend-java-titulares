package coop.tecso.examen.controller;

import coop.tecso.examen.model.Movimiento;
import coop.tecso.examen.service.MovimientoService;
import coop.tecso.examen.util.DescubiertoException;
import coop.tecso.examen.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class MovimientoController {

    @Autowired
    protected MovimientoService movimientoService;

    @RequestMapping("/movimiento")
    public List<Movimiento> getAll() {
        return movimientoService.findAll();
    }

    @RequestMapping("/movimiento/{idCuenta}")
    public List<Movimiento> getByIdCuenta() {
        return movimientoService.findAll();
    }

    // Ingresar nuevo o actualizar existente
    @RequestMapping(value = "/movimiento", method = RequestMethod.POST)
    public RestResponse saveOrUpdate(@RequestBody Movimiento movimiento) {

        if(!validate(movimiento)){
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
                    "Los campos no están diligenciados");
        }

        try {
            movimientoService.save(movimiento);
        }catch (DescubiertoException ex){
            return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
                    "La operación no puede realizarse porque supera el descubierto asignado");
        }

        return new RestResponse(HttpStatus.OK.value(), "Operación exitosa");
    }

    private boolean validate(Movimiento movimiento) {
        if (Objects.isNull(movimiento.getCuentaCorriente()) ||
                Objects.isNull(movimiento.getImporte()) ||
                Objects.isNull(movimiento.getTipoMovimiento()) ||
                Objects.isNull(movimiento.getDescripcion()) ||
                Objects.isNull(movimiento.getFecha())
        ) {
            return false;
        }

        return true;
    }
}
