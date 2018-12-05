/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turmacgrupo2;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Baiano
 */
@Embeddable
public class DetVendaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "Produto_id_Produto")
    private int produtoidProduto;
    @Basic(optional = false)
    @Column(name = "Venda_id_Venda")
    private int vendaidVenda;

    public DetVendaPK() {
    }

    public DetVendaPK(int produtoidProduto, int vendaidVenda) {
        this.produtoidProduto = produtoidProduto;
        this.vendaidVenda = vendaidVenda;
    }

    public int getProdutoidProduto() {
        return produtoidProduto;
    }

    public void setProdutoidProduto(int produtoidProduto) {
        this.produtoidProduto = produtoidProduto;
    }

    public int getVendaidVenda() {
        return vendaidVenda;
    }

    public void setVendaidVenda(int vendaidVenda) {
        this.vendaidVenda = vendaidVenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) produtoidProduto;
        hash += (int) vendaidVenda;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetVendaPK)) {
            return false;
        }
        DetVendaPK other = (DetVendaPK) object;
        if (this.produtoidProduto != other.produtoidProduto) {
            return false;
        }
        if (this.vendaidVenda != other.vendaidVenda) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turmacgrupo2.DetVendaPK[ produtoidProduto=" + produtoidProduto + ", vendaidVenda=" + vendaidVenda + " ]";
    }  
    
}
