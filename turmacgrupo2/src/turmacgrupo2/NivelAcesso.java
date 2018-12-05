/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turmacgrupo2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Baiano
 */
@Entity
@Table(name = "nivel_acesso", catalog = "turmacgrupo2", schema = "")
@NamedQueries({
    @NamedQuery(name = "NivelAcesso.findAll", query = "SELECT n FROM NivelAcesso n"),
    @NamedQuery(name = "NivelAcesso.findByCodFunc", query = "SELECT n FROM NivelAcesso n WHERE n.codFunc = :codFunc"),
    @NamedQuery(name = "NivelAcesso.findByAcesso", query = "SELECT n FROM NivelAcesso n WHERE n.acesso = :acesso"),
    @NamedQuery(name = "NivelAcesso.findByCodigo", query = "SELECT n FROM NivelAcesso n WHERE n.codigo = :codigo"),
    @NamedQuery(name = "NivelAcesso.verifiqueAcesso", query = "SELECT n FROM NivelAcesso n WHERE n.codFunc = :codFunc and n.acesso = :acesso")})
public class NivelAcesso implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Column(name = "cod_func")
    private Integer codFunc;
    @Column(name = "acesso")
    private String acesso;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;

    public NivelAcesso() {
    }

    public NivelAcesso(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodFunc() {
        return codFunc;
    }

    public void setCodFunc(Integer codFunc) {
        Integer oldCodFunc = this.codFunc;
        this.codFunc = codFunc;
        changeSupport.firePropertyChange("codFunc", oldCodFunc, codFunc);
    }

    public String getAcesso() {
        return acesso;
    }

    public void setAcesso(String acesso) {
        String oldAcesso = this.acesso;
        this.acesso = acesso;
        changeSupport.firePropertyChange("acesso", oldAcesso, acesso);
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        Integer oldCodigo = this.codigo;
        this.codigo = codigo;
        changeSupport.firePropertyChange("codigo", oldCodigo, codigo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelAcesso)) {
            return false;
        }
        NivelAcesso other = (NivelAcesso) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turmacgrupo2.NivelAcesso[ codigo=" + codigo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
