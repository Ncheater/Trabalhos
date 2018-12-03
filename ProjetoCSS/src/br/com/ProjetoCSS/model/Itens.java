/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ProjetoCSS.model;

/**
 *
 * @author lucas
 */
public class Itens {
    private String Produto;
    private String Categoria;
    private int Quantidade;
    private int Total;
    
    public String getProduto(){
        return Produto;
    }
    public void setProduto(String Produto){
        this.Produto = Produto;
    }
    
    public String getCategoria(){
        return Categoria;
    }
    public void setCategoria(String Categoria){
        this.Categoria = Categoria;
    }
    
    public int getQuatidade(){
        return Quantidade;
    }
    public void setQuantidade(int Quantidade){
        this.Quantidade = Quantidade;
    }
    
    public int getTotal(){
        return Total;
    }
    public void setTotal(int Total){
        this.Total = Total;
    }
}
