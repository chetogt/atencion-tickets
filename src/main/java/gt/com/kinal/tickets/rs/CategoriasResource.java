/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.tickets.rs;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import gt.com.kinal.tickets.service.CategoriasServiceImpl;

/**
 *
 * @author jose
 */
@Path("categorias")
public class CategoriasResource {
    @Inject
    CategoriasServiceImpl categoriasService;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getCategorias() {
        return categoriasService.getCategorias();
    }
}
