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
import javax.persistence.JoinColumn;
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
    private Long isbn;
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
    @JoinColumn(name="autor")
    @OneToOne(fetch=FetchType.LAZY)
    private Autor autor;
    @JoinColumn(name="editorial")
    @OneToOne(fetch=FetchType.LAZY)
    private Editorial editorial;

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public Integer getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    public Integer getEjemplaresRestantes() {
        return ejemplaresRestantes;
    }

    public Boolean getAlta() {
        return alta;
    }

    public Autor getAutor() {
        return autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public void setEjemplaresPrestados(Integer ejemplaresPrestados) {
        this.ejemplaresPrestados = ejemplaresPrestados;
    }

    public void setEjemplaresRestantes(Integer ejemplaresRestantes) {
        this.ejemplaresRestantes = ejemplaresRestantes;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "libreria.entidades.Libro[ id=" + isbn + " ]";
    }
    
}
