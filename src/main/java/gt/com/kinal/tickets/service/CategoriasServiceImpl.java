/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.tickets.service;

import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

/**
 *
 * @author jose
 */
@Singleton
public class CategoriasServiceImpl {
    List<String> categorias = new ArrayList<>();

    @PostConstruct
    public void inicializar() {
        System.out.println("Inicializando categorias");
        categorias.add("Internet");
        categorias.add("Equipo de computo");
        categorias.add("Accesorios");
        categorias.add("Sistema contable");
        categorias.add("Sistema administrativo");
    }
    
    public List<String> getCategorias() {
        return categorias;
    }
}
