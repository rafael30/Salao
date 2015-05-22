
package Controller;
import Model.Cidade;
import Util.Manager;

public class CidadeDAO extends Manager {
    
    public void salvar(Cidade cidade){
        em.getTransaction().begin();
        em.merge(cidade);
        em.getTransaction().commit();
    }
}
