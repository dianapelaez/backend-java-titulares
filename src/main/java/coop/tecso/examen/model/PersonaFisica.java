package coop.tecso.examen.model;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static javax.persistence.AccessType.FIELD;

@Entity
@Table(name = "persona_fisica")
@Access(FIELD)
public class PersonaFisica extends Persona {

    private static final long serialVersionUID = 5611463759980476476L;

    @Column(name = "dni", nullable = false, unique = true)
    private Long DNI;

    @Column(name = "nombre", nullable = false, length = 80)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 250)
    private String apellido;

    public Long getDNI() {
        return DNI;
    }

    public void setDNI(Long DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

}
