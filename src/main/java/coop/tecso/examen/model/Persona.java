package coop.tecso.examen.model;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import static javax.persistence.AccessType.FIELD;

@MappedSuperclass
@Access(FIELD)
public abstract class Persona extends AbstractPersistentObject {

    private static final long serialVersionUID = 1921707937244377676L;

    @Column(name = "cuit", nullable = false, unique = true)
    private Long cuit;

    public Long getCuit() {
        return cuit;
    }

    public void setCuit(Long cuit) {
        this.cuit = cuit;
    }

}
