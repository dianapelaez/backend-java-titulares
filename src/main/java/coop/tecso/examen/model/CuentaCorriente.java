package coop.tecso.examen.model;

import coop.tecso.examen.util.TipoMoneda;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.AccessType.FIELD;

@Entity
@Table(name = "cuenta_corriente")
@Access(FIELD)
public class CuentaCorriente extends AbstractPersistentObject{

    private static final long serialVersionUID = -2891890201089698384L;

    @Column(name = "numero", nullable = false, unique = true)
    private Long numero;

    @Column(name = "moneda", nullable = false, columnDefinition="int(1) default '0'")
    private TipoMoneda moneda = TipoMoneda.PESO;

    @Column(name = "saldo", nullable = false, columnDefinition="Decimal(10,2) default '0.00'")
    private double saldo;

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public TipoMoneda getMoneda() {
        return moneda;
    }

    public void setMoneda(TipoMoneda moneda) {
        this.moneda = moneda;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
