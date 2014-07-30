/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mobilistasistemas.treinamento.escolas.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author vanessa
 */
@Entity
@Table( name = "Escola" )
@NamedQueries( {
    @NamedQuery( name = "Escola.findAll" ,
                 query = "SELECT e FROM Escola e" ) ,
    @NamedQuery( name = "Escola.findById" ,
                 query = "SELECT e FROM Escola e WHERE e.id = :id" ) } )
public class Escola implements Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Id
    @Basic( optional = false )
    @NotNull
    private Integer id;

    private String nome;

    public Escola() {
    }

    public Escola( Integer id ) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome( String nome ) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += ( id != null
                  ? id.hashCode()
                  : 0 );
        return hash;
    }

    @Override
    public boolean equals( Object object ) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if ( !( object instanceof Escola ) ) {
            return false;
        }
        Escola other = ( Escola ) object;
        if ( ( this.id == null && other.id != null ) || ( this.id != null && !this.id.equals(
                other.id ) ) ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.mobilistasistemas.treinamento.escolas.model.Escola[ id=" + id + " ]";
    }

}
