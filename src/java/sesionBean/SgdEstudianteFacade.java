/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesionBean;

import entity.SgdEstudiante;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Danilo
 */
@Stateless
public class SgdEstudianteFacade extends AbstractFacade<SgdEstudiante> {

    @PersistenceContext(unitName = "dinamicoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SgdEstudianteFacade() {
        super(SgdEstudiante.class);
    }
    
}
