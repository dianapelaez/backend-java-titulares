package coop.tecso.examen.util;

public class DescubiertoException extends Exception {

    private static final long serialVersionUID = -237309515068576880L;

    public DescubiertoException() {
        super("El monto de la operación supera el valor asignado para el descubierto");

    }
}
