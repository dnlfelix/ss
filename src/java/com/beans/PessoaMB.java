package com.beans;

import com.dao.DAO;
import com.model.Pessoa;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "pessoaMB")
@SessionScoped
public class PessoaMB implements Serializable{

    private Pessoa pessoa;
    public PessoaMB() {
        this.pessoa = new Pessoa();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    public void salvar(){
        new DAO<>(Pessoa.class).adiciona(this.pessoa);
    }
    
    
    
}
