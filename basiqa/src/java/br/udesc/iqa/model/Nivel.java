/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.udesc.iqa.model;

/**
 *
 * @author Rick
 */
public enum Nivel {

    EXCELENTE("Excelente"),
    BOM("Bom"),
    MEDIO("Médio"),
    RUIM("Ruim"),
    MUITO_RUIM("Muito Ruim");

    private String nome;

    private Nivel(String nome) {
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