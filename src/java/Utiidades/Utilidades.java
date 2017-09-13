package Utiidades;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class Utilidades {

    public static void redireccionar(String pagina) {

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext extcontext = context.getExternalContext();
        extcontext.getFlash().setKeepMessages(true);
        try {
            extcontext.redirect(pagina);
        } catch (IOException ex) {
            Logger.getLogger("Error al redireccionar a " + pagina);
        }
    }
    
    public static String sha256(String cadena)
    {
        StringBuilder sb= new StringBuilder();
        try
        {
            MessageDigest md= MessageDigest.getInstance("SHA-256");
            md.update(cadena.getBytes());
            
            byte[] mb=md.digest();
            for(int i=0; i< mb.length;i++)
            {
                sb.append(Integer.toString((mb[i] & 0xff)+ 0x100,16).substring(1));
            }
            
        }catch(NoSuchAlgorithmException ex)
        {
            System.out.println("Error-Utilidades -- "+ex.getMessage());
        }
        return sb.toString();
    }
}
