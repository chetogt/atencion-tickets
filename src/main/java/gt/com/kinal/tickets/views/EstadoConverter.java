/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.tickets.views;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author jose
 */
@FacesConverter("estadoConverter")
public class EstadoConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return string;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        String value = t.toString();
        switch(value) {
            case "C":
                return "Creado";
            case "A":
                return "Asignado";
            case "E":
                return "En ejecucion";
            case "R":
                return "Resuelto";
            case "S":
                return "Sin solucion";
        }
        return "";
    } 
}
