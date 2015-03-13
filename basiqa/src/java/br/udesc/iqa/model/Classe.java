/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.iqa.model;

/**
 *
 * @author Rick
 */
public enum Classe {
    
    CLASSE_1("Classe 1"),
    CLASSE_2("Classe 2"),
    CLASSE_3("Classe 3"),
    CLASSE_4("Classe 4");

    private String nome;

    private Classe(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    public String getNome(){
        return nome;
    }
}