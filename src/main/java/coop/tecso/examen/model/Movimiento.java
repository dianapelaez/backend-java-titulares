package coop.tecso.examen.model;

import coop.tecso.examen.util.TipoMoneda;
import coop.tecso.examen.util.TipoMovimiento;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

import static javax.persistence.AccessType.FIELD;

@Entity
@Table(name = "movimientos")
@Access(FIELD)
public class Movimiento extends AbstractPersistentObject{

    private static final long serialVersionUID = -2891890201089698384L;

    @ManyToOne
    @JoinColumn(name="id_cuenta")
    private CuentaCorriente cuentaCorriente;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "tipo_movimiento", nullable = false, columnDefinition="int(1)")
    private TipoMovimiento tipoMovimiento;

    @Column(name = "descripcion", nullable = false, length = 200)
    private String descripcion;

    @Column(name = "importe", nullable = false, columnDefinition="Decimal(10,2)")
    private double importe;

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.cuentaCorriente = cuentaCorriente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

}
