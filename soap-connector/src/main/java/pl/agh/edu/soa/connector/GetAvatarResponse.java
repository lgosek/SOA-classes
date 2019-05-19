
package pl.agh.edu.soa.connector;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAvatarResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAvatarResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="EncodedAvatar" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAvatarResponse", propOrder = {
    "encodedAvatar"
})
public class GetAvatarResponse {

    @XmlElement(name = "EncodedAvatar")
    protected String encodedAvatar;

    /**
     * Gets the value of the encodedAvatar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncodedAvatar() {
        return encodedAvatar;
    }

    /**
     * Sets the value of the encodedAvatar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncodedAvatar(String value) {
        this.encodedAvatar = value;
    }

}
