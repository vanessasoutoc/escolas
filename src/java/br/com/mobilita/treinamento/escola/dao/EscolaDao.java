package br.com.mobilita.treinamento.escola.dao;

import br.com.mobilistasistemas.treinamento.escolas.model.Escola;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vanessa
 */
@Stateless
public class EscolaDao {

    @PersistenceContext( unitName = "EscolasPU" )
    private EntityManager entityManager;

    public Escola salvaEscola( Escola escola ) {
        return entityManager.merge( escola );
    }

    public List<Escola> getEscola( Escola escola ) {
        return entityManager.createNamedQuery( "Escola.findAll" , Escola.class ).getResultList();

    }

}
