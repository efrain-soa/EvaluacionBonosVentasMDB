
package pe.com.claro.eai.ebs.ws.venta.evaluacionbonosventa.mdb.responseslocals;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para ResponseStatus complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ResponseStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codeResponse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="descriptionResponse" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="errorLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="origin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="errorDetails" type="{http://claro.com.pe/esb/data/commonBusinessEntities/responseStatus/v2/}errorDetailType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseStatus", propOrder = {
    "status",
    "codeResponse",
    "descriptionResponse",
    "errorLocation",
    "date",
    "origin",
    "errorDetails"
})
public class ResponseStatus {

    protected int status;
    @XmlElement(required = true)
    protected String codeResponse;
    @XmlElement(required = true)
    protected String descriptionResponse;
    protected String errorLocation;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;
    protected String origin;
    protected List<ErrorDetailType> errorDetails;

    /**
     * Obtiene el valor de la propiedad status.
     * 
     */
    public int getStatus() {
        return status;
    }

    /**
     * Define el valor de la propiedad status.
     * 
     */
    public void setStatus(int value) {
        this.status = value;
    }

    /**
     * Obtiene el valor de la propiedad codeResponse.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodeResponse() {
        return codeResponse;
    }

    /**
     * Define el valor de la propiedad codeResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodeResponse(String value) {
        this.codeResponse = value;
    }

    /**
     * Obtiene el valor de la propiedad descriptionResponse.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescriptionResponse() {
        return descriptionResponse;
    }

    /**
     * Define el valor de la propiedad descriptionResponse.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescriptionResponse(String value) {
        this.descriptionResponse = value;
    }

    /**
     * Obtiene el valor de la propiedad errorLocation.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorLocation() {
        return errorLocation;
    }

    /**
     * Define el valor de la propiedad errorLocation.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorLocation(String value) {
        this.errorLocation = value;
    }

    /**
     * Obtiene el valor de la propiedad date.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Define el valor de la propiedad date.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

    /**
     * Obtiene el valor de la propiedad origin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Define el valor de la propiedad origin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigin(String value) {
        this.origin = value;
    }

    /**
     * Gets the value of the errorDetails property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the errorDetails property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getErrorDetails().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ErrorDetailType }
     * 
     * 
     */
    public List<ErrorDetailType> getErrorDetails() {
        if (errorDetails == null) {
            errorDetails = new ArrayList<ErrorDetailType>();
        }
        return this.errorDetails;
    }

}
