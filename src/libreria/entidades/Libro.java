/*
// Curso Egg FullStack
 */
package libreria.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Ezequiel Balasch
 */
@Entity
@Table(name="libro")
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="titulo")
    private String titulo;
    @Column(name="anio")
    private Integer anio;
    @Column(name="ejemplares")
    private Integer ejemplares;
    @Column(name="ejemplares_Prestados")
    private Integer ejemplaresPrestados;
    @Column(name="ejemplares_Restantes")
    private Integer ejemplaresRestantes;
    @Column(name="alta")
    private Boolean alta;
    @Column(name="autor")
    @OneToOne(fetch=FetchType.LAZY)
    private Autor autor;
    @Column(name="editorial")
    @OneToOne(fetch=FetchType.LAZY)
    private Editorial editorial;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libreria.entidades.Libro[ id=" + id + " ]";
    }
    
}
