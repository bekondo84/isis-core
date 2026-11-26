//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.11.24 à 01:48:47 PM CET 
//


package com.teratech.jaxb;

import com.isis.generated.ExtensionElements;
import com.isis.generated.MessageDefinition;
import com.isis.generated.SignalDefinition;
import com.isis.generated.TimerDefinition;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Classe Java pour BoundaryEvent complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="BoundaryEvent"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;choice&gt;
 *           &lt;element name="timerEventDefinition" type="{http://www.isis.cm/config/workflow}TimerDefinition"/&gt;
 *           &lt;element name="messageEventDefinition" type="{http://www.isis.cm/config/workflow}MessageDefinition"/&gt;
 *           &lt;element name="signalEventDefinition" type="{http://www.isis.cm/config/workflow}SignalDefinition"/&gt;
 *         &lt;/choice&gt;
 *         &lt;element name="extensionElements" type="{http://www.isis.cm/config/workflow}ExtensionElements" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="attachedToRef" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" /&gt;
 *       &lt;attribute name="cancelActivity" type="{http://www.w3.org/2001/XMLSchema}boolean" default="true" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BoundaryEvent", propOrder = {
    "timerEventDefinition",
    "messageEventDefinition",
    "signalEventDefinition",
    "extensionElements"
})
public class BoundaryEvent {

    protected TimerDefinition timerEventDefinition;
    protected MessageDefinition messageEventDefinition;
    protected SignalDefinition signalEventDefinition;
    protected ExtensionElements extensionElements;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "attachedToRef", required = true)
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object attachedToRef;
    @XmlAttribute(name = "cancelActivity")
    protected Boolean cancelActivity;

    /**
     * Obtient la valeur de la propriété timerEventDefinition.
     * 
     * @return
     *     possible object is
     *     {@link TimerDefinition }
     *     
     */
    public TimerDefinition getTimerEventDefinition() {
        return timerEventDefinition;
    }

    /**
     * Définit la valeur de la propriété timerEventDefinition.
     * 
     * @param value
     *     allowed object is
     *     {@link TimerDefinition }
     *     
     */
    public void setTimerEventDefinition(TimerDefinition value) {
        this.timerEventDefinition = value;
    }

    /**
     * Obtient la valeur de la propriété messageEventDefinition.
     * 
     * @return
     *     possible object is
     *     {@link MessageDefinition }
     *     
     */
    public MessageDefinition getMessageEventDefinition() {
        return messageEventDefinition;
    }

    /**
     * Définit la valeur de la propriété messageEventDefinition.
     * 
     * @param value
     *     allowed object is
     *     {@link MessageDefinition }
     *     
     */
    public void setMessageEventDefinition(MessageDefinition value) {
        this.messageEventDefinition = value;
    }

    /**
     * Obtient la valeur de la propriété signalEventDefinition.
     * 
     * @return
     *     possible object is
     *     {@link SignalDefinition }
     *     
     */
    public SignalDefinition getSignalEventDefinition() {
        return signalEventDefinition;
    }

    /**
     * Définit la valeur de la propriété signalEventDefinition.
     * 
     * @param value
     *     allowed object is
     *     {@link SignalDefinition }
     *     
     */
    public void setSignalEventDefinition(SignalDefinition value) {
        this.signalEventDefinition = value;
    }

    /**
     * Obtient la valeur de la propriété extensionElements.
     * 
     * @return
     *     possible object is
     *     {@link ExtensionElements }
     *     
     */
    public ExtensionElements getExtensionElements() {
        return extensionElements;
    }

    /**
     * Définit la valeur de la propriété extensionElements.
     * 
     * @param value
     *     allowed object is
     *     {@link ExtensionElements }
     *     
     */
    public void setExtensionElements(ExtensionElements value) {
        this.extensionElements = value;
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
     * Obtient la valeur de la propriété attachedToRef.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getAttachedToRef() {
        return attachedToRef;
    }

    /**
     * Définit la valeur de la propriété attachedToRef.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setAttachedToRef(Object value) {
        this.attachedToRef = value;
    }

    /**
     * Obtient la valeur de la propriété cancelActivity.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isCancelActivity() {
        if (cancelActivity == null) {
            return true;
        } else {
            return cancelActivity;
        }
    }

    /**
     * Définit la valeur de la propriété cancelActivity.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCancelActivity(Boolean value) {
        this.cancelActivity = value;
    }

}
