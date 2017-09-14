/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesionBean;

import entity.SgdPosgradoTipoDocumento;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Danilo
 */
@Stateless
public class SgdPosgradoTipoDocumentoFacade extends AbstractFacade<SgdPosgradoTipoDocumento> {

    @PersistenceContext(unitName = "dinamicoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SgdPosgradoTipoDocumentoFacade() {
        super(SgdPosgradoTipoDocumento.class);
    }
    
    public List<SgdPosgradoTipoDocumento> findAllByPosgrado(int id){
        Query query = getEntityManager().createNamedQuery("SgdPosgradoTipoDocumento.findAllByPosgrado");
        query.setParameter("idPos", id);
        List<SgdPosgradoTipoDocumento> resultList = query.getResultList();
        return resultList;
    }
    
}
