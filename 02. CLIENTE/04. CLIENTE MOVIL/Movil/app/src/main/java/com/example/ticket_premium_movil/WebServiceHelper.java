package com.example.ticket_premium_movil;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

public class WebServiceHelper {
    private static final String NAMESPACE = "http://ws.monster.edu.ec/";
    private static final String URL = "http://172.20.10.3:8080/Monster_Federacion_Futbol/WSTicket?wsdl";
    public static boolean comprobarUsuario(String username, String password) {
        String methodName = "comprobarUsuario";
        String SOAP_ACTION = "http://ws.monster.edu.ec/WSTicket/comprobarUsuarioResponse";
        // Crear un objeto SoapObject para la solicitud SOAP
        SoapObject request = new SoapObject(NAMESPACE, methodName);

        // Crear los parámetros de entrada
        PropertyInfo usernameProp = new PropertyInfo();
        usernameProp.setName("username");
        usernameProp.setValue(username);
        usernameProp.setType(String.class);
        request.addProperty(usernameProp);

        PropertyInfo passwordProp = new PropertyInfo();
        passwordProp.setName("password");
        passwordProp.setValue(password);
        passwordProp.setType(String.class);
        request.addProperty(passwordProp);

        // Crear un objeto SoapSerializationEnvelope para configurar la solicitud SOAP
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);

        // Crear un objeto HttpTransportSE para realizar la llamada SOAP
        HttpTransportSE transport = new HttpTransportSE(URL);

        try {
            // Realizar la llamada SOAP
            transport.call(SOAP_ACTION, envelope);

            // Obtener la respuesta del servicio web
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();

            // Parsear la respuesta a boolean
            return Boolean.parseBoolean(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static boolean registroUsuario(String username, String password, String nombre,
                                          String apellido, String cedula, String direccion) {
        String methodName = "registroUsuario";
        String SOAP_ACTION = "http://ws.monster.edu.ec/WSTicket/registroUsuario";
        // Crear un objeto SoapObject para la solicitud SOAP
        SoapObject request = new SoapObject(NAMESPACE, methodName);

        // Crear los parámetros de entrada
        PropertyInfo usernameProp = new PropertyInfo();
        usernameProp.setName("usuario");
        usernameProp.setValue(username);
        usernameProp.setType(String.class);
        request.addProperty(usernameProp);

        PropertyInfo passwordProp = new PropertyInfo();
        passwordProp.setName("password");
        passwordProp.setValue(password);
        passwordProp.setType(String.class);
        request.addProperty(passwordProp);

        PropertyInfo nameProp = new PropertyInfo();
        nameProp.setName("nombres");
        nameProp.setValue(nombre);
        nameProp.setType(String.class);
        request.addProperty(nameProp);

        PropertyInfo lastnameProp = new PropertyInfo();
        lastnameProp.setName("apellidos");
        lastnameProp.setValue(apellido);
        lastnameProp.setType(String.class);
        request.addProperty(lastnameProp);

        PropertyInfo cedulaProp = new PropertyInfo();
        cedulaProp.setName("cedula");
        cedulaProp.setValue(cedula);
        cedulaProp.setType(String.class);
        request.addProperty(cedulaProp);

        PropertyInfo direccionProp = new PropertyInfo();
        direccionProp.setName("direccion");
        direccionProp.setValue(direccion);
        direccionProp.setType(String.class);
        request.addProperty(direccionProp);

        // Crear un objeto SoapSerializationEnvelope para configurar la solicitud SOAP
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);

        // Crear un objeto HttpTransportSE para realizar la llamada SOAP
        HttpTransportSE transport = new HttpTransportSE(URL);

        try {
            // Realizar la llamada SOAP
            transport.call(SOAP_ACTION, envelope);

            // Obtener la respuesta del servicio web
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();

            // Parsear la respuesta a boolean
            return Boolean.parseBoolean(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public static List<Ticket> traerPartidos() {
        String methodName = "traerPartidos";
        String SOAP_ACTION = "http://ws.monster.edu.ec/WSTicket/traerPartidosRequest";
        // Crea una instancia de SoapObject con el namespace y el nombre del método
        SoapObject request = new SoapObject(NAMESPACE, methodName);

        // Crea un objeto SoapSerializationEnvelope para configurar la solicitud SOAP
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);
        envelope.addMapping(NAMESPACE, "Ticket", Ticket.class);

        // Crea un objeto HttpTransportSE para realizar la llamada SOAP
        HttpTransportSE transport = new HttpTransportSE(URL);

        try {
            // Realiza la llamada SOAP
            transport.call(SOAP_ACTION, envelope);

            // Obtiene la respuesta del web service
            Vector<SoapObject> responseVector = (Vector<SoapObject>) envelope.getResponse();

            // Crea una lista para almacenar los partidos
            List<Ticket> partidos = new ArrayList<>();

            // Itera sobre los elementos de la respuesta y agrega los partidos a la lista
            for (SoapObject ticketObject : responseVector) {

                Ticket ticket = new Ticket();
                ticket.setNombreEstadio(ticketObject.getProperty("nombreEstadio").toString());
                ticket.setCodigoPartido(Integer.parseInt(ticketObject.getProperty("codigoPartido").toString()));
                ticket.setEquipoVisita(ticketObject.getProperty("equipoVisita").toString());
                ticket.setEquipoLocal(ticketObject.getProperty("equipoLocal").toString());
                String fechaString = ticketObject.getProperty("fechaPartido").toString();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
                Date fechaPartido;
                try {
                    fechaPartido = dateFormat.parse(fechaString);
                } catch (ParseException e) {
                    e.printStackTrace();
                    return null;
                }
                ticket.setFechaPartido(fechaPartido);
                ticket.setHoraPartido(ticketObject.getProperty("horaPartido").toString());

                // Agrega el ticket a la lista
                partidos.add(ticket);
            }

            // Devuelve la lista de partidos
            return partidos;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static List<Localidad> traerLocalidades(int codigoPartido) {
        String methodName = "traerLocalidades";
        String SOAP_ACTION = "http://ws.monster.edu.ec/WSTicket/traerLocalidadesResponse";

        // Crea una instancia de SoapObject con el namespace y el nombre del método
        SoapObject request = new SoapObject(NAMESPACE, methodName);

        // Crea el parámetro de entrada
        PropertyInfo codigoPartidoProp = new PropertyInfo();
        codigoPartidoProp.setName("codigoPartido");
        codigoPartidoProp.setValue(codigoPartido);
        codigoPartidoProp.setType(Integer.class);
        request.addProperty(codigoPartidoProp);

        // Crea un objeto SoapSerializationEnvelope para configurar la solicitud SOAP
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);

        // Crea un objeto HttpTransportSE para realizar la llamada SOAP
        HttpTransportSE transport = new HttpTransportSE(URL);

        try {
            // Realiza la llamada SOAP
            transport.call(SOAP_ACTION + methodName, envelope);

            // Obtiene la respuesta del web service
            Vector<Object> responseVector = (Vector<Object>) envelope.getResponse();

            // Convierte el vector de respuesta en una lista de objetos Localidad
            List<Localidad> localidades = new ArrayList<>();
            for (Object responseObj : responseVector) {
                if (responseObj instanceof SoapObject) {
                    SoapObject soapObject = (SoapObject) responseObj;
                    Localidad localidad = new Localidad();

                    // Parsea los atributos de la localidad del SoapObject
                    localidad.setCodigoLocalidad(Integer.parseInt(soapObject.getProperty("codigoLocalidad").toString()));
                    localidad.setNombreLocalidad(soapObject.getProperty("nombreLocalidad").toString());
                    localidad.setDisponibilidadLocalidad(Integer.parseInt(soapObject.getProperty("disponibilidadLocalidad").toString()));
                    localidad.setPrecioLocalidad(Double.parseDouble(soapObject.getProperty("precioLocalidad").toString()));

                    localidades.add(localidad);
                }
            }

            return localidades;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void registroCompra(String nombreCliente, String cedula, String direccion, int cantPalco, int cantTribuna,
                                      int cantGeneral, int cantGeneralVisita, double totalPrecio, int codigoPartido) {
        String SOAP_ACTION = "http://ws.monster.edu.ec/WSTicket/registroCompra";
        try {
            // Crea un objeto SoapObject con el namespace y el nombre del método
            SoapObject request = new SoapObject(NAMESPACE, "registroCompra");

            // Crea los parámetros de entrada
            PropertyInfo nombreClienteProp = new PropertyInfo();
            nombreClienteProp.setName("nombreCliente");
            nombreClienteProp.setValue(nombreCliente);
            nombreClienteProp.setType(String.class);
            request.addProperty(nombreClienteProp);

            PropertyInfo cedulaProp = new PropertyInfo();
            cedulaProp.setName("cedula");
            cedulaProp.setValue(cedula);
            cedulaProp.setType(String.class);
            request.addProperty(cedulaProp);

            PropertyInfo direccionProp = new PropertyInfo();
            direccionProp.setName("direccion");
            direccionProp.setValue(direccion);
            direccionProp.setType(String.class);
            request.addProperty(direccionProp);

            PropertyInfo cantPalcoProp = new PropertyInfo();
            cantPalcoProp.setName("cantPalco");
            cantPalcoProp.setValue(cantPalco);
            cantPalcoProp.setType(int.class);
            request.addProperty(cantPalcoProp);

            PropertyInfo cantTribunaProp = new PropertyInfo();
            cantTribunaProp.setName("cantTribuna");
            cantTribunaProp.setValue(cantTribuna);
            cantTribunaProp.setType(int.class);
            request.addProperty(cantTribunaProp);

            PropertyInfo cantGeneralProp = new PropertyInfo();
            cantGeneralProp.setName("cantGeneral");
            cantGeneralProp.setValue(cantGeneral);
            cantGeneralProp.setType(int.class);
            request.addProperty(cantGeneralProp);

            PropertyInfo cantGeneralVisitaProp = new PropertyInfo();
            cantGeneralVisitaProp.setName("cantGeneralVisita");
            cantGeneralVisitaProp.setValue(cantGeneralVisita);
            cantGeneralVisitaProp.setType(int.class);
            request.addProperty(cantGeneralVisitaProp);

            PropertyInfo totalPrecioProp = new PropertyInfo();
            totalPrecioProp.setName("totalPrecio");
            totalPrecioProp.setValue(String.valueOf(totalPrecio));
            totalPrecioProp.setType(double.class);
            request.addProperty(totalPrecioProp);

            PropertyInfo codigoPartidoProp = new PropertyInfo();
            codigoPartidoProp.setName("codigoPartido");
            codigoPartidoProp.setValue(codigoPartido);
            codigoPartidoProp.setType(int.class);
            request.addProperty(codigoPartidoProp);

            // Crea un objeto SoapSerializationEnvelope para configurar la solicitud SOAP
            SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            envelope.setOutputSoapObject(request);

            // Crea un objeto HttpTransportSE para realizar la llamada SOAP
            HttpTransportSE transport = new HttpTransportSE(URL);

            // Realiza la llamada SOAP
            transport.call(SOAP_ACTION, envelope);

            // Si la llamada es exitosa, no se espera una respuesta del servidor
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public static List<Factura> traerReporte(int codigoPartido) {
        String methodName = "traerReporte";
        String SOAP_ACTION = "http://ws.monster.edu.ec/WSTicket/traerReporteRequest";

        // Crea una instancia de SoapObject con el namespace y el nombre del método
        SoapObject request = new SoapObject(NAMESPACE, methodName);
        request.addProperty("codigoPartido", codigoPartido);

        // Crea un objeto SoapSerializationEnvelope para configurar la solicitud SOAP
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);

        // Crea un objeto HttpTransportSE para realizar la llamada SOAP
        HttpTransportSE transport = new HttpTransportSE(URL);

        try {
            // Realiza la llamada SOAP
            transport.call(SOAP_ACTION, envelope);

            // Obtiene la respuesta del web service
            Object response = envelope.getResponse();

            // Verifica el tipo de respuesta
            if (response instanceof SoapObject) {
                // Si la respuesta es un SoapObject
                SoapObject soapObject = (SoapObject) response;

                // Procesa la respuesta y crea la lista de Factura
                List<Factura> listaFacturas = new ArrayList<>();
                for (int i = 0; i < soapObject.getPropertyCount(); i++) {
                    SoapObject facturaObject = (SoapObject) soapObject.getProperty(i);
                    Factura factura = new Factura();
                    factura.setCantPalco(Integer.parseInt(facturaObject.getPropertyAsString("cantPalco")));
                    factura.setCantTribuna(Integer.parseInt(facturaObject.getPropertyAsString("cantTribuna")));
                    factura.setCantGeneral(Integer.parseInt(facturaObject.getPropertyAsString("cantGeneral")));
                    factura.setCantGeneralVisita(Integer.parseInt(facturaObject.getPropertyAsString("cantGeneralVisita")));
                    factura.setPrecioTotal(Double.parseDouble(facturaObject.getPropertyAsString("precioTotal")));
                    // Agrega la factura a la lista
                    listaFacturas.add(factura);
                }

                return listaFacturas;
            } else if (response instanceof Vector) {
                // Si la respuesta es un Vector
                Vector vector = (Vector) response;

                // Procesa la respuesta y crea la lista de Factura
                List<Factura> listaFacturas = new ArrayList<>();
                for (int i = 0; i < vector.size(); i++) {
                    SoapObject facturaObject = (SoapObject) vector.get(i);
                    Factura factura = new Factura();
                    factura.setCantPalco(Integer.parseInt(facturaObject.getPropertyAsString("cantPalco")));
                    factura.setCantTribuna(Integer.parseInt(facturaObject.getPropertyAsString("cantTribuna")));
                    factura.setCantGeneral(Integer.parseInt(facturaObject.getPropertyAsString("cantGeneral")));
                    factura.setCantGeneralVisita(Integer.parseInt(facturaObject.getPropertyAsString("cantGeneralVisita")));
                    factura.setPrecioTotal(Double.parseDouble(facturaObject.getPropertyAsString("precioTotal")));
                    // Agrega la factura a la lista
                    listaFacturas.add(factura);
                }

                return listaFacturas;
            } else {
                // Tipo de respuesta no válido
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
