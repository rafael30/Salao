/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Servico;
import Util.Manager;

/**
 *
 * @author Tadeu
 */
public class ServicoDAO extends Manager{
    
    public void salvar(Servico servico){
        em.getTransaction().begin();
        em.merge(servico);
        em.getTransaction().commit();
    }
}
