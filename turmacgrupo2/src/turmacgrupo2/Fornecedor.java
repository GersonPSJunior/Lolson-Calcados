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
@Table(name = "fornecedor", catalog = "turmacgrupo2", schema = "")
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f"),
    @NamedQuery(name = "Fornecedor.findByIdFornecedor", query = "SELECT f FROM Fornecedor f WHERE f.idFornecedor = :idFornecedor"),
    @NamedQuery(name = "Fornecedor.findByNomeForn", query = "SELECT f FROM Fornecedor f WHERE f.nomeForn = :nomeForn"),
    @NamedQuery(name = "Fornecedor.findByEmail", query = "SELECT f FROM Fornecedor f WHERE f.email = :email"),
    @NamedQuery(name = "Fornecedor.findByTelefone", query = "SELECT f FROM Fornecedor f WHERE f.telefone = :telefone"),
    @NamedQuery(name = "Fornecedor.findByCelular", query = "SELECT f FROM Fornecedor f WHERE f.celular = :celular"),
    @NamedQuery(name = "Fornecedor.findByFax", query = "SELECT f FROM Fornecedor f WHERE f.fax = :fax"),
    @NamedQuery(name = "Fornecedor.findByCepForn", query = "SELECT f FROM Fornecedor f WHERE f.cepForn = :cepForn"),
    @NamedQuery(name = "Fornecedor.findByEnderecoForn", query = "SELECT f FROM Fornecedor f WHERE f.enderecoForn = :enderecoForn"),
    @NamedQuery(name = "Fornecedor.findByCnpjForn", query = "SELECT f FROM Fornecedor f WHERE f.cnpjForn = :cnpjForn"),
    @NamedQuery(name = "Fornecedor.findByRgForn", query = "SELECT f FROM Fornecedor f WHERE f.rgForn = :rgForn"),
    @NamedQuery(name = "Fornecedor.findByOrgaoEmissor", query = "SELECT f FROM Fornecedor f WHERE f.orgaoEmissor = :orgaoEmissor"),
    @NamedQuery(name = "Fornecedor.findByUf", query = "SELECT f FROM Fornecedor f WHERE f.uf = :uf")})
public class Fornecedor implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Fornecedor")
    private Integer idFornecedor;
    @Column(name = "nome_forn")
    private String nomeForn;
    @Column(name = "email")
    private String email;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "celular")
    private String celular;
    @Column(name = "fax")
    private String fax;
    @Column(name = "cep_forn")
    private String cepForn;
    @Column(name = "endereco_forn")
    private String enderecoForn;
    @Column(name = "cnpj_forn")
    private String cnpjForn;
    @Column(name = "rg_forn")
    private String rgForn;
    @Column(name = "orgao_emissor")
    private String orgaoEmissor;
    @Column(name = "uf")
    private String uf;

    public Fornecedor() {
    }

    public Fornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        Integer oldIdFornecedor = this.idFornecedor;
        this.idFornecedor = idFornecedor;
        changeSupport.firePropertyChange("idFornecedor", oldIdFornecedor, idFornecedor);
    }

    public String getNomeForn() {
        return nomeForn;
    }

    public void setNomeForn(String nomeForn) {
        String oldNomeForn = this.nomeForn;
        this.nomeForn = nomeForn;
        changeSupport.firePropertyChange("nomeForn", oldNomeForn, nomeForn);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        String oldTelefone = this.telefone;
        this.telefone = telefone;
        changeSupport.firePropertyChange("telefone", oldTelefone, telefone);
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        String oldCelular = this.celular;
        this.celular = celular;
        changeSupport.firePropertyChange("celular", oldCelular, celular);
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        String oldFax = this.fax;
        this.fax = fax;
        changeSupport.firePropertyChange("fax", oldFax, fax);
    }

    public String getCepForn() {
        return cepForn;
    }

    public void setCepForn(String cepForn) {
        String oldCepForn = this.cepForn;
        this.cepForn = cepForn;
        changeSupport.firePropertyChange("cepForn", oldCepForn, cepForn);
    }

    public String getEnderecoForn() {
        return enderecoForn;
    }

    public void setEnderecoForn(String enderecoForn) {
        String oldEnderecoForn = this.enderecoForn;
        this.enderecoForn = enderecoForn;
        changeSupport.firePropertyChange("enderecoForn", oldEnderecoForn, enderecoForn);
    }

    public String getCnpjForn() {
        return cnpjForn;
    }

    public void setCnpjForn(String cnpjForn) {
        String oldCnpjForn = this.cnpjForn;
        this.cnpjForn = cnpjForn;
        changeSupport.firePropertyChange("cnpjForn", oldCnpjForn, cnpjForn);
    }

    public String getRgForn() {
        return rgForn;
    }

    public void setRgForn(String rgForn) {
        String oldRgForn = this.rgForn;
        this.rgForn = rgForn;
        changeSupport.firePropertyChange("rgForn", oldRgForn, rgForn);
    }

    public String getOrgaoEmissor() {
        return orgaoEmissor;
    }

    public void setOrgaoEmissor(String orgaoEmissor) {
        String oldOrgaoEmissor = this.orgaoEmissor;
        this.orgaoEmissor = orgaoEmissor;
        changeSupport.firePropertyChange("orgaoEmissor", oldOrgaoEmissor, orgaoEmissor);
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        String oldUf = this.uf;
        this.uf = uf;
        changeSupport.firePropertyChange("uf", oldUf, uf);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFornecedor != null ? idFornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.idFornecedor == null && other.idFornecedor != null) || (this.idFornecedor != null && !this.idFornecedor.equals(other.idFornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turmacgrupo2.Fornecedor[ idFornecedor=" + idFornecedor + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
