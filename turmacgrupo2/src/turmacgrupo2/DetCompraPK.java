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
public class DetCompraPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "Compra_id_Compra")
    private int compraidCompra;
    @Basic(optional = false)
    @Column(name = "Produto_id_Produto")
    private int produtoidProduto;

    public DetCompraPK() {
    }

    public DetCompraPK(int compraidCompra, int produtoidProduto) {
        this.compraidCompra = compraidCompra;
        this.produtoidProduto = produtoidProduto;
    }

    public int getCompraidCompra() {
        return compraidCompra;
    }

    public void setCompraidCompra(int compraidCompra) {
        this.compraidCompra = compraidCompra;
    }

    public int getProdutoidProduto() {
        return produtoidProduto;
    }

    public void setProdutoidProduto(int produtoidProduto) {
        this.produtoidProduto = produtoidProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) compraidCompra;
        hash += (int) produtoidProduto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetCompraPK)) {
            return false;
        }
        DetCompraPK other = (DetCompraPK) object;
        if (this.compraidCompra != other.compraidCompra) {
            return false;
        }
        if (this.produtoidProduto != other.produtoidProduto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turmacgrupo2.DetCompraPK[ compraidCompra=" + compraidCompra + ", produtoidProduto=" + produtoidProduto + " ]";
    }
    
}
