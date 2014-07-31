/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mobilitasistemas.treinamento.escolas.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vanessa
 */
@Entity
@Table( name = "Escola" )
@NamedQueries( {
    @NamedQuery( name = Escola.FIND_ALL ,
                 query = "SELECT e FROM Escola e" ) ,
    @NamedQuery( name = "Escola.findById" ,
                 query = "SELECT e FROM Escola e WHERE e.id = :id" ) } )
@XmlRootElement
public class Escola implements Serializable {

    public static final String FIND_ALL = "Escola.findAll";

    private static final long serialVersionUID = 1L;
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Id
    private Integer id;

    private String nome;

    private String bairro;

    @ManyToMany( fetch = FetchType.EAGER )
    private Set<Professor> professores;

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

    public String getBairro() {
        return bairro;
    }

    public void setBairro( String bairro ) {
        this.bairro = bairro;
    }

    @XmlTransient
    public Set<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores( Set<Professor> professores ) {
        this.professores = professores;
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
