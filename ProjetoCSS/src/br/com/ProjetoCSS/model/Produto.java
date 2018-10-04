/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ProjetoCSS.model;

/**
 *
 * @author Yago
 */
public class Produto {

    private int id_prod;
    private String nome_prod;
    private String desc_prod;
    private int qtd_prod;
    private float valor_prod;
    private String cat_prod;

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getNome_prod() {
        return nome_prod;
    }

    public void setNome_prod(String nome_prod) {
        this.nome_prod = nome_prod;
    }

    public String getDesc_prod() {
        return desc_prod;
    }

    public void setDesc_prod(String desc_prod) {
        this.desc_prod = desc_prod;
    }

    public int getQtd_prod() {
        return qtd_prod;
    }

    public void setQtd_prod(int qtd_prod) {
        this.qtd_prod = qtd_prod;
    }

    public float getValor_prod() {
        return valor_prod;
    }

    public void setValor_prod(float valor_prod) {
        this.valor_prod = valor_prod;
    }

    public String getCat_prod() {
        return cat_prod;
    }

    public void setCat_prod(String cat_prod) {
        this.cat_prod = cat_prod;
    }

    public Object[] getProduto() {
        int id = this.getId_prod();
        String nome = this.getNome_prod();
        String desc = this.getDesc_prod();
        int qtd = this.getQtd_prod();
        float valor = this.getValor_prod();
        String cat = this.getCat_prod();
        Object[] p = {id, nome, desc, qtd, valor, cat};

        return p;
    }
}
