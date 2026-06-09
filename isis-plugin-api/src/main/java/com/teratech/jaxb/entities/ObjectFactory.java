//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.06.08 à 11:41:27 AM WAT 
//


package com.teratech.jaxb.entities;

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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.isis.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Controllers }
     * 
     */
    public Controllers createControllers() {
        return new Controllers();
    }

    /**
     * Create an instance of {@link Services }
     * 
     */
    public Services createServices() {
        return new Services();
    }

    /**
     * Create an instance of {@link Controllers.Controller }
     * 
     */
    public Controllers.Controller createControllersController() {
        return new Controllers.Controller();
    }

    /**
     * Create an instance of {@link Plugin }
     * 
     */
    public Plugin createPlugin() {
        return new Plugin();
    }

    /**
     * Create an instance of {@link ContactType }
     * 
     */
    public ContactType createContactType() {
        return new ContactType();
    }

    /**
     * Create an instance of {@link MediasType }
     * 
     */
    public MediasType createMediasType() {
        return new MediasType();
    }

    /**
     * Create an instance of {@link DependsType }
     * 
     */
    public DependsType createDependsType() {
        return new DependsType();
    }

    /**
     * Create an instance of {@link MediaType }
     * 
     */
    public MediaType createMediaType() {
        return new MediaType();
    }

    /**
     * Create an instance of {@link DependType }
     * 
     */
    public DependType createDependType() {
        return new DependType();
    }

    /**
     * Create an instance of {@link Services.Service }
     * 
     */
    public Services.Service createServicesService() {
        return new Services.Service();
    }

}
