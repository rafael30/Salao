/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Usuario;
import Util.Manager;

/**
 *
 * @author Tadeu
 */
public class UsuarioDAO extends Manager{
    
    public void salvar(Usuario usuario){
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
    }
}
