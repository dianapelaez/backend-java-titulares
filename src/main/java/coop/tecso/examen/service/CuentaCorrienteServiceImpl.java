package coop.tecso.examen.service;

import coop.tecso.examen.model.CuentaCorriente;
import coop.tecso.examen.repository.CuentaCorrienteRepository;
import coop.tecso.examen.util.CuentaCorrienteConMovimientosException;
import coop.tecso.examen.util.DescubiertoException;
import coop.tecso.examen.util.TipoMoneda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CuentaCorrienteServiceImpl implements CuentaCorrienteService {

    @Autowired
    private CuentaCorrienteRepository cuentaCorrienteRepository;

    @Override
    public CuentaCorriente save(CuentaCorriente cuentaCorriente) throws DescubiertoException {

        if(Objects.nonNull(cuentaCorriente)) {
            if(validarDescubierto(cuentaCorriente)){
                return cuentaCorrienteRepository.save(cuentaCorriente);
            }else{
                throw new DescubiertoException();
            }
        }

        return null;
    }

    @Override
    public List<CuentaCorriente> findAll() {
        return cuentaCorrienteRepository.findAll();
    }

    @Override
    public CuentaCorriente findById(Long id){
        return cuentaCorrienteRepository.findById(id).get();
    }

    @Override
    public void delete(CuentaCorriente cuentaCorriente) throws CuentaCorrienteConMovimientosException {
        if(cuentaCorrienteRepository.count() > 0){
            throw new CuentaCorrienteConMovimientosException();
        }

        cuentaCorrienteRepository.delete(cuentaCorriente);
    }

    private boolean validarDescubierto(CuentaCorriente cuentaCorriente){
        int tipoMoneda = cuentaCorriente.getMoneda().ordinal();
        double saldo = cuentaCorriente.getSaldo();
        double descubierto = 0;

        if(saldo >= 0){
            return true;
        }

        for(TipoMoneda item: TipoMoneda.values()){
            if(item.compareTo(TipoMoneda.PESO) == 0){
                if(item.equals(tipoMoneda)){
                    descubierto = 1000;
                }
            }else if(item.compareTo(TipoMoneda.DOLAR) == 0){
                if(item.equals(tipoMoneda)){
                    descubierto = 300;
                }
            }else if(item.compareTo(TipoMoneda.EURO) == 0){
                if(item.equals(tipoMoneda)){
                    descubierto = 150;
                }
            }
        }

        if(saldo < descubierto) return false;

        return true;
    }
}
