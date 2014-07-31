/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mobilitasistemas.treinamento.escolas.services;

import br.com.mobilitasistemas.treinamento.escolas.dao.EscolaDao;
import br.com.mobilitasistemas.treinamento.escolas.model.Escola;
import br.com.mobilitasistemas.treinamento.escolas.model.Professor;
import com.google.gson.Gson;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author vanessa
 */
@Stateless
@Path( "/escolas" )
public class EscolaREST {

    @Inject
    private EscolaDao dao;

    //post
    //get
    @GET
    @Produces( MediaType.APPLICATION_JSON )
    public String busca() {

        List<Escola> escolas = dao.getEscola();
        filtraEscolas( escolas );
        String toJson = new Gson().toJson( escolas );
        return toJson;

    }

    private void filtraEscolas( List<Escola> escolas ) {
        for ( Escola escola : escolas ) {
            Set<Professor> professores = escola.getProfessores();
            for ( Professor professor : professores ) {
                professor.setEscolas( null );
            }
        }
    }

    @Path( "/salvar" )
    @POST
    @Consumes( MediaType.APPLICATION_JSON )
    public String salvarEscola( String escola ) {

        Escola fromJson = new Gson().fromJson( escola , Escola.class );
        Escola salvaEscola = dao.salvaEscola( fromJson );

        String toJson = new Gson().toJson( salvaEscola );
        return toJson;
    }

}
