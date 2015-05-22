
package Controller;

import Model.Servico;
import Util.Manager;


public class ServicoDAO extends Manager{
    
    public void salvar(Servico servico){
        em.getTransaction().begin();
        em.merge(servico);
        em.getTransaction().commit();
    }
}
