/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turmacgrupo2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Baiano
 */
@Entity
@Table(name = "det_compra", catalog = "turmacgrupo2", schema = "")
@NamedQueries({
    @NamedQuery(name = "DetCompra.findAll", query = "SELECT d FROM DetCompra d"),
    @NamedQuery(name = "DetCompra.findByCompraidCompra", query = "SELECT d FROM DetCompra d WHERE d.detCompraPK.compraidCompra = :compraidCompra"),
    @NamedQuery(name = "DetCompra.findByProdutoidProduto", query = "SELECT d FROM DetCompra d WHERE d.detCompraPK.produtoidProduto = :produtoidProduto"),
    @NamedQuery(name = "DetCompra.findByValorTotal", query = "SELECT d FROM DetCompra d WHERE d.valorTotal = :valorTotal"),
    @NamedQuery(name = "DetCompra.findByQtdVenda", query = "SELECT d FROM DetCompra d WHERE d.qtdVenda = :qtdVenda"),
    @NamedQuery(name = "DetCompra.findByValorUnitario", query = "SELECT d FROM DetCompra d WHERE d.valorUnitario = :valorUnitario")})
public class DetCompra implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetCompraPK detCompraPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_total")
    private Double valorTotal;
    @Column(name = "qtd_venda")
    private Integer qtdVenda;
    @Column(name = "valor_unitario")
    private Double valorUnitario;
    @JoinColumn(name = "Compra_id_Compra", referencedColumnName = "id_Compra", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Compra compra;
    
     @Transient
    private String descricaoProduto;

    public DetCompra() {
    }

    public DetCompra(DetCompraPK detCompraPK) {
        this.detCompraPK = detCompraPK;
    }

    public DetCompra(int compraidCompra, int produtoidProduto) {
        this.detCompraPK = new DetCompraPK(compraidCompra, produtoidProduto);
    }

    public DetCompraPK getDetCompraPK() {
        return detCompraPK;
    }

    public void setDetCompraPK(DetCompraPK detCompraPK) {
        this.detCompraPK = detCompraPK;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        Double oldValorTotal = this.valorTotal;
        this.valorTotal = valorTotal;
        changeSupport.firePropertyChange("valorTotal", oldValorTotal, valorTotal);
    }

    public Integer getQtdVenda() {
        return qtdVenda;
    }

    public void setQtdVenda(Integer qtdVenda) {
        Integer oldQtdVenda = this.qtdVenda;
        this.qtdVenda = qtdVenda;
        changeSupport.firePropertyChange("qtdVenda", oldQtdVenda, qtdVenda);
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        Double oldValorUnitario = this.valorUnitario;
        this.valorUnitario = valorUnitario;
        changeSupport.firePropertyChange("valorUnitario", oldValorUnitario, valorUnitario);
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        Compra oldCompra = this.compra;
        this.compra = compra;
        changeSupport.firePropertyChange("compra", oldCompra, compra);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detCompraPK != null ? detCompraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetCompra)) {
            return false;
        }
        DetCompra other = (DetCompra) object;
        if ((this.detCompraPK == null && other.detCompraPK != null) || (this.detCompraPK != null && !this.detCompraPK.equals(other.detCompraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turmacgrupo2.DetCompra[ detCompraPK=" + detCompraPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    /**
     * @return the descricaoProduto
     */
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    /**
     * @param descricaoProduto the descricaoProduto to set
     */
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }
    
}
