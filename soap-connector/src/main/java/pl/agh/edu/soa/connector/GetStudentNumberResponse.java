
package pl.agh.edu.soa.connector;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getStudentNumberResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getStudentNumberResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="StudentNumber" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getStudentNumberResponse", propOrder = {
    "studentNumber"
})
public class GetStudentNumberResponse {

    @XmlElement(name = "StudentNumber")
    protected int studentNumber;

    /**
     * Gets the value of the studentNumber property.
     * 
     */
    public int getStudentNumber() {
        return studentNumber;
    }

    /**
     * Sets the value of the studentNumber property.
     * 
     */
    public void setStudentNumber(int value) {
        this.studentNumber = value;
    }

}
