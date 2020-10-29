package Entidades;

public class Projeto {
    String tipo;
    double diametro;
    double peso_metro;
    int quantidade;
    int comprimento;
    double peso_ferro = quantidade * comprimento * peso_metro;
    double comp_total = quantidade * comprimento;
    
}

