package coop.tecso.examen.service;

import coop.tecso.examen.model.CuentaCorriente;
import coop.tecso.examen.model.Movimiento;
import coop.tecso.examen.repository.CuentaCorrienteRepository;
import coop.tecso.examen.repository.MovimientoRepository;
import coop.tecso.examen.util.DescubiertoException;
import coop.tecso.examen.util.TipoMoneda;
import coop.tecso.examen.util.TipoMovimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MovimientoServiceImpl implements MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    @Autowired
    protected CuentaCorrienteService cuentaCorrienteService;

    @Override
    public Movimiento save(Movimiento movimiento) throws DescubiertoException{
        actualizarSaldo(movimiento);

        return movimientoRepository.save(movimiento);
    }

    private void actualizarSaldo(Movimiento movimiento) throws DescubiertoException {
        TipoMovimiento tipoMovimiento = movimiento.getTipoMovimiento();
        CuentaCorriente cuentaCorriente = movimiento.getCuentaCorriente();
        double importe = movimiento.getImporte();
        double saldo = cuentaCorriente.getSaldo();
        boolean validar = true;

        if(tipoMovimiento.compareTo(TipoMovimiento.DEBITO) == 0){
            saldo = saldo - importe;
        } else {
            saldo = saldo + importe;
        }

        cuentaCorriente.setSaldo(saldo);
        cuentaCorrienteService.save(cuentaCorriente);
    }

    @Override
    public List<Movimiento> findAll() {
        return movimientoRepository.findAll();
    }

    @Override
    public List<Movimiento> findByCuentaCorrienteId(Long idCuenta) {
        return movimientoRepository.findByCuentaCorrienteIdOrderByFechaDesc(idCuenta);
    }

}
