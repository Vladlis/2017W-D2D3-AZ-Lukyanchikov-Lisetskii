
package com.epam.soap.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.epam.soap.service package. 
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

    private final static QName _GetFactorial_QNAME = new QName("http://service.soap.epam.com/", "getFactorial");
    private final static QName _GetFactorialResponse_QNAME = new QName("http://service.soap.epam.com/", "getFactorialResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.epam.soap.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFactorialResponse }
     * 
     */
    public GetFactorialResponse createGetFactorialResponse() {
        return new GetFactorialResponse();
    }

    /**
     * Create an instance of {@link GetFactorial }
     * 
     */
    public GetFactorial createGetFactorial() {
        return new GetFactorial();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFactorial }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.epam.com/", name = "getFactorial")
    public JAXBElement<GetFactorial> createGetFactorial(GetFactorial value) {
        return new JAXBElement<GetFactorial>(_GetFactorial_QNAME, GetFactorial.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFactorialResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.soap.epam.com/", name = "getFactorialResponse")
    public JAXBElement<GetFactorialResponse> createGetFactorialResponse(GetFactorialResponse value) {
        return new JAXBElement<GetFactorialResponse>(_GetFactorialResponse_QNAME, GetFactorialResponse.class, null, value);
    }

}
