package coop.tecso.examen.model;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static javax.persistence.AccessType.FIELD;

@Entity
@Table(name = "persona_juridica")
@Access(FIELD)
public class PersonaJuridica extends Persona{

    private static final long serialVersionUID = 1266308301075578119L;

    @Column(name = "razon", nullable = false, length = 100)
    private String razon;

    @Column(name = "fundacion", nullable = false)
    private int fundacion;

    public String getRazon() {
		return razon;
	}

	public void setRazon(String razon) {
		this.razon = razon;
	}

	public int getFundacion() {
        return fundacion;
    }

    public void setFundacion(int fundacion) {
        this.fundacion = fundacion;
    }
}
