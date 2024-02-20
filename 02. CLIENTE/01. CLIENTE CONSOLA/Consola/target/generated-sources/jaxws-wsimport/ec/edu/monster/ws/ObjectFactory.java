
package ec.edu.monster.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ec.edu.monster.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ComprobarUsuario_QNAME = new QName("http://ws.monster.edu.ec/", "comprobarUsuario");
    private final static QName _ComprobarUsuarioResponse_QNAME = new QName("http://ws.monster.edu.ec/", "comprobarUsuarioResponse");
    private final static QName _RegistroCompra_QNAME = new QName("http://ws.monster.edu.ec/", "registroCompra");
    private final static QName _RegistroUsuario_QNAME = new QName("http://ws.monster.edu.ec/", "registroUsuario");
    private final static QName _Ticket_QNAME = new QName("http://ws.monster.edu.ec/", "ticket");
    private final static QName _TraerCliente_QNAME = new QName("http://ws.monster.edu.ec/", "traerCliente");
    private final static QName _TraerClienteResponse_QNAME = new QName("http://ws.monster.edu.ec/", "traerClienteResponse");
    private final static QName _TraerLocalidades_QNAME = new QName("http://ws.monster.edu.ec/", "traerLocalidades");
    private final static QName _TraerLocalidadesResponse_QNAME = new QName("http://ws.monster.edu.ec/", "traerLocalidadesResponse");
    private final static QName _TraerPartidos_QNAME = new QName("http://ws.monster.edu.ec/", "traerPartidos");
    private final static QName _TraerPartidosResponse_QNAME = new QName("http://ws.monster.edu.ec/", "traerPartidosResponse");
    private final static QName _TraerReporte_QNAME = new QName("http://ws.monster.edu.ec/", "traerReporte");
    private final static QName _TraerReporteResponse_QNAME = new QName("http://ws.monster.edu.ec/", "traerReporteResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ec.edu.monster.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ComprobarUsuario }
     * 
     */
    public ComprobarUsuario createComprobarUsuario() {
        return new ComprobarUsuario();
    }

    /**
     * Create an instance of {@link ComprobarUsuarioResponse }
     * 
     */
    public ComprobarUsuarioResponse createComprobarUsuarioResponse() {
        return new ComprobarUsuarioResponse();
    }

    /**
     * Create an instance of {@link RegistroCompra }
     * 
     */
    public RegistroCompra createRegistroCompra() {
        return new RegistroCompra();
    }

    /**
     * Create an instance of {@link RegistroUsuario }
     * 
     */
    public RegistroUsuario createRegistroUsuario() {
        return new RegistroUsuario();
    }

    /**
     * Create an instance of {@link Ticket }
     * 
     */
    public Ticket createTicket() {
        return new Ticket();
    }

    /**
     * Create an instance of {@link TraerCliente }
     * 
     */
    public TraerCliente createTraerCliente() {
        return new TraerCliente();
    }

    /**
     * Create an instance of {@link TraerClienteResponse }
     * 
     */
    public TraerClienteResponse createTraerClienteResponse() {
        return new TraerClienteResponse();
    }

    /**
     * Create an instance of {@link TraerLocalidades }
     * 
     */
    public TraerLocalidades createTraerLocalidades() {
        return new TraerLocalidades();
    }

    /**
     * Create an instance of {@link TraerLocalidadesResponse }
     * 
     */
    public TraerLocalidadesResponse createTraerLocalidadesResponse() {
        return new TraerLocalidadesResponse();
    }

    /**
     * Create an instance of {@link TraerPartidos }
     * 
     */
    public TraerPartidos createTraerPartidos() {
        return new TraerPartidos();
    }

    /**
     * Create an instance of {@link TraerPartidosResponse }
     * 
     */
    public TraerPartidosResponse createTraerPartidosResponse() {
        return new TraerPartidosResponse();
    }

    /**
     * Create an instance of {@link TraerReporte }
     * 
     */
    public TraerReporte createTraerReporte() {
        return new TraerReporte();
    }

    /**
     * Create an instance of {@link TraerReporteResponse }
     * 
     */
    public TraerReporteResponse createTraerReporteResponse() {
        return new TraerReporteResponse();
    }

    /**
     * Create an instance of {@link Cliente }
     * 
     */
    public Cliente createCliente() {
        return new Cliente();
    }

    /**
     * Create an instance of {@link Factura }
     * 
     */
    public Factura createFactura() {
        return new Factura();
    }

    /**
     * Create an instance of {@link Localidad }
     * 
     */
    public Localidad createLocalidad() {
        return new Localidad();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComprobarUsuario }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ComprobarUsuario }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "comprobarUsuario")
    public JAXBElement<ComprobarUsuario> createComprobarUsuario(ComprobarUsuario value) {
        return new JAXBElement<ComprobarUsuario>(_ComprobarUsuario_QNAME, ComprobarUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComprobarUsuarioResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ComprobarUsuarioResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "comprobarUsuarioResponse")
    public JAXBElement<ComprobarUsuarioResponse> createComprobarUsuarioResponse(ComprobarUsuarioResponse value) {
        return new JAXBElement<ComprobarUsuarioResponse>(_ComprobarUsuarioResponse_QNAME, ComprobarUsuarioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistroCompra }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistroCompra }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "registroCompra")
    public JAXBElement<RegistroCompra> createRegistroCompra(RegistroCompra value) {
        return new JAXBElement<RegistroCompra>(_RegistroCompra_QNAME, RegistroCompra.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistroUsuario }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegistroUsuario }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "registroUsuario")
    public JAXBElement<RegistroUsuario> createRegistroUsuario(RegistroUsuario value) {
        return new JAXBElement<RegistroUsuario>(_RegistroUsuario_QNAME, RegistroUsuario.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Ticket }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Ticket }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "ticket")
    public JAXBElement<Ticket> createTicket(Ticket value) {
        return new JAXBElement<Ticket>(_Ticket_QNAME, Ticket.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TraerCliente }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TraerCliente }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "traerCliente")
    public JAXBElement<TraerCliente> createTraerCliente(TraerCliente value) {
        return new JAXBElement<TraerCliente>(_TraerCliente_QNAME, TraerCliente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TraerClienteResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TraerClienteResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "traerClienteResponse")
    public JAXBElement<TraerClienteResponse> createTraerClienteResponse(TraerClienteResponse value) {
        return new JAXBElement<TraerClienteResponse>(_TraerClienteResponse_QNAME, TraerClienteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TraerLocalidades }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TraerLocalidades }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "traerLocalidades")
    public JAXBElement<TraerLocalidades> createTraerLocalidades(TraerLocalidades value) {
        return new JAXBElement<TraerLocalidades>(_TraerLocalidades_QNAME, TraerLocalidades.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TraerLocalidadesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TraerLocalidadesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "traerLocalidadesResponse")
    public JAXBElement<TraerLocalidadesResponse> createTraerLocalidadesResponse(TraerLocalidadesResponse value) {
        return new JAXBElement<TraerLocalidadesResponse>(_TraerLocalidadesResponse_QNAME, TraerLocalidadesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TraerPartidos }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TraerPartidos }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "traerPartidos")
    public JAXBElement<TraerPartidos> createTraerPartidos(TraerPartidos value) {
        return new JAXBElement<TraerPartidos>(_TraerPartidos_QNAME, TraerPartidos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TraerPartidosResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TraerPartidosResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "traerPartidosResponse")
    public JAXBElement<TraerPartidosResponse> createTraerPartidosResponse(TraerPartidosResponse value) {
        return new JAXBElement<TraerPartidosResponse>(_TraerPartidosResponse_QNAME, TraerPartidosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TraerReporte }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TraerReporte }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "traerReporte")
    public JAXBElement<TraerReporte> createTraerReporte(TraerReporte value) {
        return new JAXBElement<TraerReporte>(_TraerReporte_QNAME, TraerReporte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TraerReporteResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TraerReporteResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.monster.edu.ec/", name = "traerReporteResponse")
    public JAXBElement<TraerReporteResponse> createTraerReporteResponse(TraerReporteResponse value) {
        return new JAXBElement<TraerReporteResponse>(_TraerReporteResponse_QNAME, TraerReporteResponse.class, null, value);
    }

}
