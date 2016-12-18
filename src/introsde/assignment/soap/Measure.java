
package introsde.assignment.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java per measure complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="measure">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dateRegistered" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="measureType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="measureValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="measureValueType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mid" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="personId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "measure", propOrder = {
    "dateRegistered",
    "measureType",
    "measureValue",
    "measureValueType",
    "mid",
    "personId"
})
public class Measure {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateRegistered;
    protected String measureType;
    protected String measureValue;
    protected String measureValueType;
    protected Long mid;
    protected Long personId;

    /**
     * Recupera il valore della proprietà dateRegistered.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateRegistered() {
        return dateRegistered;
    }

    /**
     * Imposta il valore della proprietà dateRegistered.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateRegistered(XMLGregorianCalendar value) {
        this.dateRegistered = value;
    }

    /**
     * Recupera il valore della proprietà measureType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeasureType() {
        return measureType;
    }

    /**
     * Imposta il valore della proprietà measureType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeasureType(String value) {
        this.measureType = value;
    }

    /**
     * Recupera il valore della proprietà measureValue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeasureValue() {
        return measureValue;
    }

    /**
     * Imposta il valore della proprietà measureValue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeasureValue(String value) {
        this.measureValue = value;
    }

    /**
     * Recupera il valore della proprietà measureValueType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeasureValueType() {
        return measureValueType;
    }

    /**
     * Imposta il valore della proprietà measureValueType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeasureValueType(String value) {
        this.measureValueType = value;
    }

    /**
     * Recupera il valore della proprietà mid.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMid() {
        return mid;
    }

    /**
     * Imposta il valore della proprietà mid.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMid(Long value) {
        this.mid = value;
    }

    /**
     * Recupera il valore della proprietà personId.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPersonId() {
        return personId;
    }

    /**
     * Imposta il valore della proprietà personId.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPersonId(Long value) {
        this.personId = value;
    }

}
