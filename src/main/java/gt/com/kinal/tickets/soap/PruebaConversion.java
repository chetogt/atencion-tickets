/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.tickets.soap;

import gt.com.kinal.tickets.domain.Tecnico;
import gt.com.kinal.tickets.domain.Ticket;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author jose
 */
public class PruebaConversion {
    public static void main(String[] args) throws JAXBException {
        Ticket ticket = new Ticket("Navegacion", "No puedo ingresar a pagina de Banguat", "C", new Date());
        Ticket ticketDos = new Ticket("Impresora", "No puedo imprimir", "C", new Date());
        Tecnico tecnico = new Tecnico("Jose Cordova", "jose@correo.com");
        tecnico.setTickets(new ArrayList<>());
        tecnico.getTickets().add(ticket);
        tecnico.getTickets().add(ticketDos);
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(Tecnico.class);
        Marshaller m = context.createMarshaller();
        m.marshal(tecnico, writer);
        System.out.println(writer.toString());
        
        Unmarshaller um = context.createUnmarshaller();
        InputStream is = new ByteArrayInputStream(writer.toString().getBytes(StandardCharsets.UTF_8));
        Tecnico tecnicoXml = (Tecnico) um.unmarshal(is);
        System.out.println("Nombre del tecnico: " + tecnicoXml.getNombre());
    }
}
