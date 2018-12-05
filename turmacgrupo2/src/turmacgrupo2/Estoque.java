/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turmacgrupo2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author infoc
 */
@Entity
@Table(name = "estoque")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estoque.findAll", query = "SELECT e FROM Estoque e"),
    @NamedQuery(name = "Estoque.findByIdEstoque", query = "SELECT e FROM Estoque e WHERE e.idEstoque = :idEstoque"),
    @NamedQuery(name = "Estoque.findByDescricao", query = "SELECT e FROM Estoque e WHERE e.descricao = :descricao"),
    @NamedQuery(name = "Estoque.findByQtde", query = "SELECT e FROM Estoque e WHERE e.qtde = :qtde"),
    @NamedQuery(name = "Estoque.findByData", query = "SELECT e FROM Estoque e WHERE e.data = :data"),
    @NamedQuery(name = "Estoque.findByTipo", query = "SELECT e FROM Estoque e WHERE e.tipo = :tipo"),
    @NamedQuery(name = "Estoque.findByValor", query = "SELECT e FROM Estoque e WHERE e.valor = :valor"),
    @NamedQuery(name = "Estoque.findBySaldo", query = "SELECT e FROM Estoque e WHERE e.saldo = :saldo")})
public class Estoque implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Estoque")
    private Integer idEstoque;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "qtde")
    private Integer qtde;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "tipo")
    private String tipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @Column(name = "saldo")
    private Integer saldo;

    public Estoque() {
    }

    public Estoque(Integer idEstoque) {
        this.idEstoque = idEstoque;
    }

    public Integer getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(Integer idEstoque) {
        Integer oldIdEstoque = this.idEstoque;
        this.idEstoque = idEstoque;
        changeSupport.firePropertyChange("idEstoque", oldIdEstoque, idEstoque);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    public Integer getQtde() {
        return qtde;
    }

    public void setQtde(Integer qtde) {
        Integer oldQtde = this.qtde;
        this.qtde = qtde;
        changeSupport.firePropertyChange("qtde", oldQtde, qtde);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        Date oldData = this.data;
        this.data = data;
        changeSupport.firePropertyChange("data", oldData, data);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        String oldTipo = this.tipo;
        this.tipo = tipo;
        changeSupport.firePropertyChange("tipo", oldTipo, tipo);
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        Double oldValor = this.valor;
        this.valor = valor;
        changeSupport.firePropertyChange("valor", oldValor, valor);
    }

    public Integer getSaldo() {
        return saldo;
    }

    public void setSaldo(Integer saldo) {
        Integer oldSaldo = this.saldo;
        this.saldo = saldo;
        changeSupport.firePropertyChange("saldo", oldSaldo, saldo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstoque != null ? idEstoque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estoque)) {
            return false;
        }
        Estoque other = (Estoque) object;
        if ((this.idEstoque == null && other.idEstoque != null) || (this.idEstoque != null && !this.idEstoque.equals(other.idEstoque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turmacgrupo2.Estoque[ idEstoque=" + idEstoque + " ]";
    }
    public String receberProduto(Produto produto)
        {
            Conexao c=new Conexao();
            try
                {
                    String sentenca;
                    sentenca = "INSERT INTO estoque VALUES (NULL, '" +
                            produto.getDescricao() + "','0',NULL,'','"+produto.getPrecoProduto()+"','0')";
                    return c.atualizarBanco(sentenca);
                }
            catch(Exception e)
                {
                    return e.getMessage();
                }
        }
    public String atualizarEntrada(DetCompra detCompra)
       {
            Conexao c=new Conexao();
            try
                {
                    String sentenca;
                    sentenca = "INSERT INTO estoque VALUES (NULL, '" +
                            detCompra.getDescricaoProduto() + "','"+detCompra.getQtdVenda()+"',NULL,'E','"+detCompra.getValorTotal()+"','"+detCompra.getQtdVenda()+"')";
                    return c.atualizarBanco(sentenca);
                }
            catch(Exception e)
                {
                    return e.getMessage();
                }
        }
    
    public String atualizarSaida(DetVenda detVenda)
       {
            Conexao c=new Conexao();
            Estoque es=new Estoque();
            try
                {
                    String sentenca;
                    sentenca = "UPDATE estoque SET 'descricao'= '" +
                            detVenda.getDescricaoProduto() + "','qtde'="+detVenda.getQtdeVenda()+",'data'='NULL','tipo'='S','valor'="+detVenda.getValorTotal()+",'saldo'="+detVenda.getQtdeVenda()+" WHERE 'id_Estoque'="+es.getIdEstoque()+";";
                    return c.atualizarBanco(sentenca);
                }
            catch(Exception e)
                {
                    return e.getMessage();
                }
        }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
}
