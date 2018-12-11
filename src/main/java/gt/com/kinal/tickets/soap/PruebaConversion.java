/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.kinal.tickets.soap;

import gt.com.kinal.tickets.domain.Ticket;
import java.io.StringWriter;
import java.util.Date;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * @author jose
 */
public class PruebaConversion {
    public static void main(String[] args) throws JAXBException {
        Ticket ticket = new Ticket("Navegacion", "No puedo ingresar a pagina de Banguat", "C", new Date());
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(Ticket.class);
        Marshaller m = context.createMarshaller();
        m.marshal(ticket, writer);
        System.out.println(writer.toString());
    }
}
