package coop.tecso.examen.util;

public class CuentaCorrienteConMovimientosException extends Exception {

    private static final long serialVersionUID = -237309515068576880L;

    public CuentaCorrienteConMovimientosException() {
        super("La cuenta corriente no puede ser eliminada porque tiene movimientos asociados");

    }
}
