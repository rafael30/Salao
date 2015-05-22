
package Controller;

import Model.Usuario;
import Util.Manager;


public class UsuarioDAO extends Manager{
    
    public void salvar(Usuario usuario){
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
    }
}
