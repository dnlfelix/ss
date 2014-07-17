package com.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String telefone;
    private String celular;
    private String assunto;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date nascimento;
    private String email;
    private String endereco;
    private String bairro;
    private String cep;
    private String cidade;

    public Long getId() {
        return id;
    }

    public void setId(Long var) {
        this.id = var;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String var) {
        this.nome = var;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String var) {
        this.telefone = var;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String var) {
        this.celular = var;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String var) {
        this.assunto = var;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date var) {
        this.nascimento = var;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String var) {
        this.email = var;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String var) {
        this.endereco = var;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String var) {
        this.bairro = var;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String var) {
        this.cep = var;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String var) {
        this.cidade = var;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.nome);
        hash = 17 * hash + Objects.hashCode(this.telefone);
        hash = 17 * hash + Objects.hashCode(this.celular);
        hash = 17 * hash + Objects.hashCode(this.assunto);
        hash = 17 * hash + Objects.hashCode(this.nascimento);
        hash = 17 * hash + Objects.hashCode(this.email);
        hash = 17 * hash + Objects.hashCode(this.endereco);
        hash = 17 * hash + Objects.hashCode(this.bairro);
        hash = 17 * hash + Objects.hashCode(this.cep);
        hash = 17 * hash + Objects.hashCode(this.cidade);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.celular, other.celular)) {
            return false;
        }
        if (!Objects.equals(this.assunto, other.assunto)) {
            return false;
        }
        if (!Objects.equals(this.nascimento, other.nascimento)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (!Objects.equals(this.cep, other.cep)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Pessoa[ id=" + id + " ]";
    }

}
