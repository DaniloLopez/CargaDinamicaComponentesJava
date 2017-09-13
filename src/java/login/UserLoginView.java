/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;


import Utiidades.Utilidades;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;


/**
 *
 * @hola unicauca
 */


@ManagedBean
@SessionScoped
public class UserLoginView implements Serializable{
    private String username;
    private String password;                   
    
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
   
    public void login() throws ServletException {        
         Utilidades.redireccionar("/dinamico/faces/GestionContenido/sgdPosgradoTipoDocumento/List.xhtml");
    }                            
}
