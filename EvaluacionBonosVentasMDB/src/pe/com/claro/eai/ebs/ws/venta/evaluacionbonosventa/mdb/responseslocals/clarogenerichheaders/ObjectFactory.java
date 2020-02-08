
package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.responseslocals.clarogenerichheaders;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pe.com.claro.esb.data.commonbusinessentities.clarogenericheaders.v2 package. 
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

    private final static QName _HeaderResponse_QNAME = new QName("http://claro.com.pe/esb/data/commonBusinessEntities/claroGenericHeaders/v2/", "headerResponse");
    private final static QName _HeaderRequest_QNAME = new QName("http://claro.com.pe/esb/data/commonBusinessEntities/claroGenericHeaders/v2/", "headerRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pe.com.claro.esb.data.commonbusinessentities.clarogenericheaders.v2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HeaderRequestType }
     * 
     */
    public HeaderRequestType createHeaderRequest() {
        return new HeaderRequestType();
    }

    /**
     * Create an instance of {@link HeaderResponse }
     * 
     */
    public HeaderResponse createHeaderResponse() {
        return new HeaderResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HeaderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://claro.com.pe/esb/data/commonBusinessEntities/claroGenericHeaders/v2/", name = "headerResponse")
    public JAXBElement<HeaderResponse> createHeaderResponse(HeaderResponse value) {
        return new JAXBElement<HeaderResponse>(_HeaderResponse_QNAME, HeaderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HeaderRequestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://claro.com.pe/esb/data/commonBusinessEntities/claroGenericHeaders/v2/", name = "headerRequest")
    public JAXBElement<HeaderRequestType> createHeaderRequest(HeaderRequestType value) {
        return new JAXBElement<HeaderRequestType>(_HeaderRequest_QNAME, HeaderRequestType.class, null, value);
    }

}
