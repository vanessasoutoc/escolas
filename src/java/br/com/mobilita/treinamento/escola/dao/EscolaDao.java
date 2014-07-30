package br.com.mobilita.treinamento.escola.dao;

import br.com.mobilistasistemas.treinamento.escolas.model.Escola;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
        TypedQuery<Escola> createNamedQuery = entityManager.createNamedQuery(
                Escola.FIND_ALL , Escola.class );
        List<Escola> resultList = null;
        if ( createNamedQuery != null ) {
            resultList = createNamedQuery.getResultList();
        }

        return resultList;

    }

}
