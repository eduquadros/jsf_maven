
package br.com.jeqtech.model.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="cidade")

public class Cidade implements Serializable{
    private static final long serialVersionUID=1L;
    

    @Id
    @GeneratedValue
    @Column(name="IdCidade", nullable= false)
    private Integer IdCidade;

    @Column(name="nome", length = 80, nullable = false)
    private String nome;
    
    

    @OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY)
    @ForeignKey(name="EnderecoCidade")
    private List<Endereco> enderecos;

    public Cidade() {
    }

    public Integer getIdCidade() {
        return IdCidade;
    }

    public void setIdCidade(Integer IdCidade) {
        this.IdCidade = IdCidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.IdCidade);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        if (!Objects.equals(this.IdCidade, other.IdCidade)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
