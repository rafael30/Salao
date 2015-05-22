
package Controller;

import Model.Cargo;
import Util.Manager;


public class CargoDAO extends Manager{
    
    public void salvar(Cargo cargo){
        em.getTransaction().begin();
        em.merge(cargo);
        em.getTransaction().commit();
    }
    
}
