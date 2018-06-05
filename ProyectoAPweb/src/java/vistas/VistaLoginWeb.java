package vistas;

import controlador.ControladorLogin;
import controlador.VistaLogin;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Administrador;
import modelo.Afiliado;
import modelo.Especifico;
import vista.Inicio;

/**
 * @author Aníbal Pittamiglio.
 */

public class VistaLoginWeb implements VistaLogin{
    
    private ControladorLogin controlador;
    private HttpServletResponse response; 
    private HttpServletRequest request; 

    public VistaLoginWeb() {
        controlador = new ControladorLogin(this, "Mozo");
    }
    
    public void login(HttpServletRequest req,HttpServletResponse res) throws ClassNotFoundException {
        String usr = req.getParameter("usuario");
        String pass = req.getParameter("contr");
        response = res;
        request = req;
        Inicio.main(null);
        controlador.login(usr, pass);
    }  

    @Override
    public void ingresarAfiliado(Afiliado afi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ingresarAdministrador(Administrador adm) {
        try {
            request.getSession(true).setAttribute("Administrador", adm);
            response.sendRedirect("GestionCobranza.html");
        } catch (IOException ex) {
            System.out.println("Error al redirect:" + ex.getMessage());
        }
    }

    @Override
    public void ingresarEspecifico(Especifico esp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void mostrarError(String mensaje) {
        try {
            response.sendRedirect("index.jsp?msg=" + mensaje);
        } catch (IOException ex) {
            System.out.println("Error al redirect:" + ex.getMessage());
        }
    }
}