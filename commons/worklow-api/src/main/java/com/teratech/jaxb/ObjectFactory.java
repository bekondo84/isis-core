//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.11.24 à 01:48:47 PM CET 
//


package com.teratech.jaxb;

import javax.xml.namespace.QName;

import com.isis.generated.*;
import com.isis.generated.Process;
import com.isis.generated.SequenceFlow;
import com.isis.generated.ServiceTask;
import com.isis.generated.SignalDefinition;
import com.isis.generated.TimerDefinition;
import com.isis.generated.TimerEvent;
import com.isis.generated.UserTask;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.isis.generated package. 
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

    private final static QName _Process_QNAME = new QName("http://www.isis.cm/config/workflow", "process");
    private final static QName _ProcessStartEvent_QNAME = new QName("http://www.isis.cm/config/workflow", "startEvent");
    private final static QName _ProcessUserTask_QNAME = new QName("http://www.isis.cm/config/workflow", "userTask");
    private final static QName _ProcessServiceTask_QNAME = new QName("http://www.isis.cm/config/workflow", "serviceTask");
    private final static QName _ProcessExclusiveGateway_QNAME = new QName("http://www.isis.cm/config/workflow", "exclusiveGateway");
    private final static QName _ProcessParallelGateway_QNAME = new QName("http://www.isis.cm/config/workflow", "parallelGateway");
    private final static QName _ProcessTimerEvent_QNAME = new QName("http://www.isis.cm/config/workflow", "timerEvent");
    private final static QName _ProcessIntermediateCatchEvent_QNAME = new QName("http://www.isis.cm/config/workflow", "intermediateCatchEvent");
    private final static QName _ProcessBoundaryEvent_QNAME = new QName("http://www.isis.cm/config/workflow", "boundaryEvent");
    private final static QName _ProcessEndEvent_QNAME = new QName("http://www.isis.cm/config/workflow", "endEvent");
    private final static QName _ProcessSequenceFlow_QNAME = new QName("http://www.isis.cm/config/workflow", "sequenceFlow");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.isis.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link com.isis.generated.Process }
     * 
     */
    public com.isis.generated.Process createProcess() {
        return new com.isis.generated.Process();
    }

    /**
     * Create an instance of {@link Node }
     * 
     */
    public Node createNode() {
        return new Node();
    }

    /**
     * Create an instance of {@link UserTask }
     * 
     */
    public UserTask createUserTask() {
        return new UserTask();
    }

    /**
     * Create an instance of {@link ServiceTask }
     * 
     */
    public ServiceTask createServiceTask() {
        return new ServiceTask();
    }

    /**
     * Create an instance of {@link Gateway }
     * 
     */
    public Gateway createGateway() {
        return new Gateway();
    }

    /**
     * Create an instance of {@link TimerEvent }
     * 
     */
    public TimerEvent createTimerEvent() {
        return new TimerEvent();
    }

    /**
     * Create an instance of {@link IntermediateCatchEvent }
     * 
     */
    public IntermediateCatchEvent createIntermediateCatchEvent() {
        return new IntermediateCatchEvent();
    }

    /**
     * Create an instance of {@link BoundaryEvent }
     * 
     */
    public BoundaryEvent createBoundaryEvent() {
        return new BoundaryEvent();
    }

    /**
     * Create an instance of {@link TimerDefinition }
     * 
     */
    public TimerDefinition createTimerDefinition() {
        return new TimerDefinition();
    }

    /**
     * Create an instance of {@link MessageDefinition }
     * 
     */
    public MessageDefinition createMessageDefinition() {
        return new MessageDefinition();
    }

    /**
     * Create an instance of {@link com.isis.generated.SignalDefinition }
     * 
     */
    public SignalDefinition createSignalDefinition() {
        return new SignalDefinition();
    }

    /**
     * Create an instance of {@link SequenceFlow }
     * 
     */
    public SequenceFlow createSequenceFlow() {
        return new SequenceFlow();
    }

    /**
     * Create an instance of {@link ExtensionElements }
     * 
     */
    public ExtensionElements createExtensionElements() {
        return new ExtensionElements();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Process }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Process }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.isis.cm/config/workflow", name = "process")
    public JAXBElement<Process> createProcess(Process value) {
        return new JAXBElement<Process>(_Process_QNAME, Process.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Node }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Node }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.isis.cm/config/workflow", name = "startEvent", scope = Process.class)
    public JAXBElement<Node> createProcessStartEvent(Node value) {
        return new JAXBElement<Node>(_ProcessStartEvent_QNAME, Node.class, Process.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserTask }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UserTask }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.isis.cm/config/workflow", name = "userTask", scope = Process.class)
    public JAXBElement<UserTask> createProcessUserTask(UserTask value) {
        return new JAXBElement<UserTask>(_ProcessUserTask_QNAME, UserTask.class, Process.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceTask }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ServiceTask }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.isis.cm/config/workflow", name = "serviceTask", scope = Process.class)
    public JAXBElement<ServiceTask> createProcessServiceTask(ServiceTask value) {
        return new JAXBElement<ServiceTask>(_ProcessServiceTask_QNAME, ServiceTask.class, Process.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Gateway }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Gateway }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.isis.cm/config/workflow", name = "exclusiveGateway", scope = Process.class)
    public JAXBElement<Gateway> createProcessExclusiveGateway(Gateway value) {
        return new JAXBElement<Gateway>(_ProcessExclusiveGateway_QNAME, Gateway.class, Process.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Gateway }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Gateway }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.isis.cm/config/workflow", name = "parallelGateway", scope = Process.class)
    public JAXBElement<Gateway> createProcessParallelGateway(Gateway value) {
        return new JAXBElement<Gateway>(_ProcessParallelGateway_QNAME, Gateway.class, Process.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TimerEvent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TimerEvent }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.isis.cm/config/workflow", name = "timerEvent", scope = Process.class)
    public JAXBElement<TimerEvent> createProcessTimerEvent(TimerEvent value) {
        return new JAXBElement<TimerEvent>(_ProcessTimerEvent_QNAME, TimerEvent.class, Process.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IntermediateCatchEvent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link IntermediateCatchEvent }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.isis.cm/config/workflow", name = "intermediateCatchEvent", scope = Process.class)
    public JAXBElement<IntermediateCatchEvent> createProcessIntermediateCatchEvent(IntermediateCatchEvent value) {
        return new JAXBElement<IntermediateCatchEvent>(_ProcessIntermediateCatchEvent_QNAME, IntermediateCatchEvent.class, Process.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BoundaryEvent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BoundaryEvent }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.isis.cm/config/workflow", name = "boundaryEvent", scope = Process.class)
    public JAXBElement<BoundaryEvent> createProcessBoundaryEvent(BoundaryEvent value) {
        return new JAXBElement<BoundaryEvent>(_ProcessBoundaryEvent_QNAME, BoundaryEvent.class, Process.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Node }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Node }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.isis.cm/config/workflow", name = "endEvent", scope = Process.class)
    public JAXBElement<Node> createProcessEndEvent(Node value) {
        return new JAXBElement<Node>(_ProcessEndEvent_QNAME, Node.class, Process.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SequenceFlow }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SequenceFlow }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.isis.cm/config/workflow", name = "sequenceFlow", scope = Process.class)
    public JAXBElement<SequenceFlow> createProcessSequenceFlow(SequenceFlow value) {
        return new JAXBElement<SequenceFlow>(_ProcessSequenceFlow_QNAME, SequenceFlow.class, Process.class, value);
    }

}
