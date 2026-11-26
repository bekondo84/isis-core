//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.11.24 à 01:48:47 PM CET 
//


package com.teratech.jaxb;

import java.util.ArrayList;
import java.util.List;

import com.isis.generated.SequenceFlow;
import com.isis.generated.ServiceTask;
import com.isis.generated.TimerEvent;
import com.isis.generated.UserTask;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElementRefs;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Classe Java pour Process complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="Process"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;choice maxOccurs="unbounded"&gt;
 *         &lt;element name="startEvent" type="{http://www.isis.cm/config/workflow}Node"/&gt;
 *         &lt;element name="userTask" type="{http://www.isis.cm/config/workflow}UserTask"/&gt;
 *         &lt;element name="serviceTask" type="{http://www.isis.cm/config/workflow}ServiceTask"/&gt;
 *         &lt;element name="exclusiveGateway" type="{http://www.isis.cm/config/workflow}Gateway"/&gt;
 *         &lt;element name="parallelGateway" type="{http://www.isis.cm/config/workflow}Gateway"/&gt;
 *         &lt;element name="timerEvent" type="{http://www.isis.cm/config/workflow}TimerEvent"/&gt;
 *         &lt;element name="intermediateCatchEvent" type="{http://www.isis.cm/config/workflow}IntermediateCatchEvent"/&gt;
 *         &lt;element name="boundaryEvent" type="{http://www.isis.cm/config/workflow}BoundaryEvent"/&gt;
 *         &lt;element name="endEvent" type="{http://www.isis.cm/config/workflow}Node"/&gt;
 *         &lt;element name="sequenceFlow" type="{http://www.isis.cm/config/workflow}SequenceFlow"/&gt;
 *       &lt;/choice&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" default="1.0" /&gt;
 *       &lt;attribute name="executable" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Process", propOrder = {
    "startEventOrUserTaskOrServiceTask"
})
public class Process {

    @XmlElementRefs({
        @XmlElementRef(name = "startEvent", namespace = "http://www.isis.cm/config/workflow", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "userTask", namespace = "http://www.isis.cm/config/workflow", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "serviceTask", namespace = "http://www.isis.cm/config/workflow", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "exclusiveGateway", namespace = "http://www.isis.cm/config/workflow", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "parallelGateway", namespace = "http://www.isis.cm/config/workflow", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "timerEvent", namespace = "http://www.isis.cm/config/workflow", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "intermediateCatchEvent", namespace = "http://www.isis.cm/config/workflow", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "boundaryEvent", namespace = "http://www.isis.cm/config/workflow", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "endEvent", namespace = "http://www.isis.cm/config/workflow", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "sequenceFlow", namespace = "http://www.isis.cm/config/workflow", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> startEventOrUserTaskOrServiceTask;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "version")
    protected String version;
    @XmlAttribute(name = "executable")
    protected Boolean executable;

    /**
     * Gets the value of the startEventOrUserTaskOrServiceTask property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the startEventOrUserTaskOrServiceTask property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStartEventOrUserTaskOrServiceTask().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link BoundaryEvent }{@code >}
     * {@link JAXBElement }{@code <}{@link Gateway }{@code >}
     * {@link JAXBElement }{@code <}{@link Gateway }{@code >}
     * {@link JAXBElement }{@code <}{@link IntermediateCatchEvent }{@code >}
     * {@link JAXBElement }{@code <}{@link Node }{@code >}
     * {@link JAXBElement }{@code <}{@link Node }{@code >}
     * {@link JAXBElement }{@code <}{@link SequenceFlow }{@code >}
     * {@link JAXBElement }{@code <}{@link ServiceTask }{@code >}
     * {@link JAXBElement }{@code <}{@link TimerEvent }{@code >}
     * {@link JAXBElement }{@code <}{@link UserTask }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getStartEventOrUserTaskOrServiceTask() {
        if (startEventOrUserTaskOrServiceTask == null) {
            startEventOrUserTaskOrServiceTask = new ArrayList<JAXBElement<?>>();
        }
        return this.startEventOrUserTaskOrServiceTask;
    }

    /**
     * Obtient la valeur de la propriété id.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Définit la valeur de la propriété id.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Obtient la valeur de la propriété name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Définit la valeur de la propriété name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtient la valeur de la propriété version.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        if (version == null) {
            return "1.0";
        } else {
            return version;
        }
    }

    /**
     * Définit la valeur de la propriété version.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Obtient la valeur de la propriété executable.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isExecutable() {
        if (executable == null) {
            return true;
        } else {
            return executable;
        }
    }

    /**
     * Définit la valeur de la propriété executable.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExecutable(Boolean value) {
        this.executable = value;
    }

}
