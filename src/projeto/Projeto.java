/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

/**
 *
 * @author Alzilene Alencar
 */
public class Projeto {

    String tipo;
    double diametro;
    double peso_metro;
    int quantidade;
    int comprimento;
    double peso_ferro = quantidade * comprimento * peso_metro;
    double comp_total = quantidade * comprimento;
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
