//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.2 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2026.06.17 à 01:13:57 PM WAT 
//


package com.teratech.jaxb.entities;

import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;

import javax.xml.namespace.QName;


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

    private final static QName _Actions_QNAME = new QName("http://www.isis.cm/config/isis-actions", "actions");
    private final static QName _Shutcuts_QNAME = new QName("http://www.isis.cm/config/isis-shutcut", "shutcuts");
    private final static QName _ExplorerTree_QNAME = new QName("http://www.isis.cm/config/explorer-tree", "explorer-tree");
    private final static QName _Search_QNAME = new QName("http://www.isis.cm/config/isis-search", "search");

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
     * Create an instance of {@link FieldType }
     * 
     */
    public FieldType createFieldType() {
        return new FieldType();
    }

    /**
     * Create an instance of {@link Controllers.Controller }
     * 
     */
    public Controllers.Controller createControllersController() {
        return new Controllers.Controller();
    }

    /**
     * Create an instance of {@link Actions }
     * 
     */
    public Actions createActions() {
        return new Actions();
    }

    /**
     * Create an instance of {@link Action }
     * 
     */
    public Action createAction() {
        return new Action();
    }

    /**
     * Create an instance of {@link Dashbord }
     * 
     */
    public Dashbord createDashbord() {
        return new Dashbord();
    }

    /**
     * Create an instance of {@link DashboardSectionType }
     * 
     */
    public DashboardSectionType createDashboardSectionType() {
        return new DashboardSectionType();
    }

    /**
     * Create an instance of {@link DashboardSubSectionType }
     * 
     */
    public DashboardSubSectionType createDashboardSubSectionType() {
        return new DashboardSubSectionType();
    }

    /**
     * Create an instance of {@link DashboardItem }
     * 
     */
    public DashboardItem createDashboardItem() {
        return new DashboardItem();
    }

    /**
     * Create an instance of {@link EditorArea }
     * 
     */
    public EditorArea createEditorArea() {
        return new EditorArea();
    }

    /**
     * Create an instance of {@link EditorAreaType }
     * 
     */
    public EditorAreaType createEditorAreaType() {
        return new EditorAreaType();
    }

    /**
     * Create an instance of {@link CommonType }
     * 
     */
    public CommonType createCommonType() {
        return new CommonType();
    }

    /**
     * Create an instance of {@link FormType }
     * 
     */
    public FormType createFormType() {
        return new FormType();
    }

    /**
     * Create an instance of {@link TabType }
     * 
     */
    public TabType createTabType() {
        return new TabType();
    }

    /**
     * Create an instance of {@link SubSectionType }
     * 
     */
    public SubSectionType createSubSectionType() {
        return new SubSectionType();
    }

    /**
     * Create an instance of {@link SectionType }
     * 
     */
    public SectionType createSectionType() {
        return new SectionType();
    }

    /**
     * Create an instance of {@link FilterType }
     * 
     */
    public FilterType createFilterType() {
        return new FilterType();
    }

    /**
     * Create an instance of {@link Shutcuts }
     * 
     */
    public Shutcuts createShutcuts() {
        return new Shutcuts();
    }

    /**
     * Create an instance of {@link Shutcut }
     * 
     */
    public Shutcut createShutcut() {
        return new Shutcut();
    }

    /**
     * Create an instance of {@link ExplorerTree }
     * 
     */
    public ExplorerTree createExplorerTree() {
        return new ExplorerTree();
    }

    /**
     * Create an instance of {@link NavigationNode }
     * 
     */
    public NavigationNode createNavigationNode() {
        return new NavigationNode();
    }

    /**
     * Create an instance of {@link ListView }
     * 
     */
    public ListView createListView() {
        return new ListView();
    }

    /**
     * Create an instance of {@link ListViewType }
     * 
     */
    public ListViewType createListViewType() {
        return new ListViewType();
    }

    /**
     * Create an instance of {@link TemplateType }
     * 
     */
    public TemplateType createTemplateType() {
        return new TemplateType();
    }

    /**
     * Create an instance of {@link Search }
     * 
     */
    public Search createSearch() {
        return new Search();
    }

    /**
     * Create an instance of {@link ColumnType }
     * 
     */
    public ColumnType createColumnType() {
        return new ColumnType();
    }

    /**
     * Create an instance of {@link Pattern }
     * 
     */
    public Pattern createPattern() {
        return new Pattern();
    }

    /**
     * Create an instance of {@link PatternField }
     * 
     */
    public PatternField createPatternField() {
        return new PatternField();
    }

    /**
     * Create an instance of {@link SearchField }
     * 
     */
    public SearchField createSearchField() {
        return new SearchField();
    }

    /**
     * Create an instance of {@link Context }
     * 
     */
    public Context createContext() {
        return new Context();
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

    /**
     * Create an instance of {@link FieldType.Filters }
     * 
     */
    public FieldType.Filters createFieldTypeFilters() {
        return new FieldType.Filters();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Actions }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Actions }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.isis.cm/config/isis-actions", name = "actions")
    public JAXBElement<Actions> createActions(Actions value) {
        return new JAXBElement<Actions>(_Actions_QNAME, Actions.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Shutcuts }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Shutcuts }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.isis.cm/config/isis-shutcut", name = "shutcuts")
    public JAXBElement<Shutcuts> createShutcuts(Shutcuts value) {
        return new JAXBElement<Shutcuts>(_Shutcuts_QNAME, Shutcuts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExplorerTree }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ExplorerTree }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.isis.cm/config/explorer-tree", name = "explorer-tree")
    public JAXBElement<ExplorerTree> createExplorerTree(ExplorerTree value) {
        return new JAXBElement<ExplorerTree>(_ExplorerTree_QNAME, ExplorerTree.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Search }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Search }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.isis.cm/config/isis-search", name = "search")
    public JAXBElement<Search> createSearch(Search value) {
        return new JAXBElement<Search>(_Search_QNAME, Search.class, null, value);
    }

}
