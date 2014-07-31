/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mobilitasistemas.treinamento.escolas.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author vanessa
 */
@Entity
public class Professor implements Serializable {

    @Id
    private int id;

    private String nome;

    private String especialidade;

    @ManyToMany( mappedBy = "professores" )
    private Set<Escola> escolas;

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome( String nome ) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade( String especialidade ) {
        this.especialidade = especialidade;
    }

    public Set<Escola> getEscolas() {
        return escolas;
    }

    public void setEscolas( Set<Escola> escolas ) {
        this.escolas = escolas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        final Professor other = ( Professor ) obj;
        if ( this.id != other.id ) {
            return false;
        }
        return true;
    }

}
