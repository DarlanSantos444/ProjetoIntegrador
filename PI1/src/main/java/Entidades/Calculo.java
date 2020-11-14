
package Entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Calculo implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    public int quantidade;
    public Double comprimento;
    public Double resultado;
    public Double pesoTotal;
    public Double compTotal;

    public Double getCompTotal() {
        return compTotal;
    }

    public void setCompTotal(Double compTotal) {
        this.compTotal = compTotal;
    }
    
    public Double getPesoTotal() {
        return pesoTotal;
    }
    public void setPesoTotal(Double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }
    
    public Double getResultado() {
        resultado = (quantidade * comprimento);
        return resultado;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }

    
    
}
