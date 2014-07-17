package com.beans;

import com.dao.DAO;
import com.model.Pessoa;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "pessoaMB")
@SessionScoped
public class PessoaMB implements Serializable {

    private Pessoa pessoa;
    

    public PessoaMB() {
        this.pessoa = new Pessoa();
        this.pessoa.setNome("Danilo Felix da Silva");
    }

    public Pessoa getPessoa() {
        return this.pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String salvar() {
        new DAO<>(Pessoa.class).adiciona(this.pessoa);
        this.pessoa = new Pessoa();
        return "";
    }

    public List<Pessoa> getTipos() {
        return new DAO<>(Pessoa.class).listaTodos();
    }

    public void buscaPorId(Long id) {
        this.pessoa = new DAO<>(Pessoa.class).buscaPorId(id);
    }
    public List<Pessoa> buscarPorNomePacial(String nome){
        return new DAO<>(Pessoa.class).buscaPorQuery("Pessoa.porNome", "nome", "%"+nome+"%"); 
    }
    public List<Pessoa> buscarPorNomeInicio(String nome){
        return new DAO<>(Pessoa.class).buscaPorQuery("Pessoa.porNome", "nome", nome+"%");   
    }

}
