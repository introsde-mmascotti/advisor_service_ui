
package advisor.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the advisor.service package. 
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

    private final static QName _GetWeightAdviceResponse_QNAME = new QName("http://service.advisor/", "getWeightAdviceResponse");
    private final static QName _GetRecommendedIntakeResponse_QNAME = new QName("http://service.advisor/", "getRecommendedIntakeResponse");
    private final static QName _GetFitnessAdviceResponse_QNAME = new QName("http://service.advisor/", "getFitnessAdviceResponse");
    private final static QName _GetWeightAdvice_QNAME = new QName("http://service.advisor/", "getWeightAdvice");
    private final static QName _GetFitnessAdvice_QNAME = new QName("http://service.advisor/", "getFitnessAdvice");
    private final static QName _GetMealAdvice_QNAME = new QName("http://service.advisor/", "getMealAdvice");
    private final static QName _GetMealAdviceResponse_QNAME = new QName("http://service.advisor/", "getMealAdviceResponse");
    private final static QName _GetRecommendedIntake_QNAME = new QName("http://service.advisor/", "getRecommendedIntake");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: advisor.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetRecommendedIntakeResponse }
     * 
     */
    public GetRecommendedIntakeResponse createGetRecommendedIntakeResponse() {
        return new GetRecommendedIntakeResponse();
    }

    /**
     * Create an instance of {@link GetWeightAdviceResponse }
     * 
     */
    public GetWeightAdviceResponse createGetWeightAdviceResponse() {
        return new GetWeightAdviceResponse();
    }

    /**
     * Create an instance of {@link GetMealAdviceResponse }
     * 
     */
    public GetMealAdviceResponse createGetMealAdviceResponse() {
        return new GetMealAdviceResponse();
    }

    /**
     * Create an instance of {@link GetRecommendedIntake }
     * 
     */
    public GetRecommendedIntake createGetRecommendedIntake() {
        return new GetRecommendedIntake();
    }

    /**
     * Create an instance of {@link GetFitnessAdvice }
     * 
     */
    public GetFitnessAdvice createGetFitnessAdvice() {
        return new GetFitnessAdvice();
    }

    /**
     * Create an instance of {@link GetMealAdvice }
     * 
     */
    public GetMealAdvice createGetMealAdvice() {
        return new GetMealAdvice();
    }

    /**
     * Create an instance of {@link GetFitnessAdviceResponse }
     * 
     */
    public GetFitnessAdviceResponse createGetFitnessAdviceResponse() {
        return new GetFitnessAdviceResponse();
    }

    /**
     * Create an instance of {@link GetWeightAdvice }
     * 
     */
    public GetWeightAdvice createGetWeightAdvice() {
        return new GetWeightAdvice();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWeightAdviceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.advisor/", name = "getWeightAdviceResponse")
    public JAXBElement<GetWeightAdviceResponse> createGetWeightAdviceResponse(GetWeightAdviceResponse value) {
        return new JAXBElement<GetWeightAdviceResponse>(_GetWeightAdviceResponse_QNAME, GetWeightAdviceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecommendedIntakeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.advisor/", name = "getRecommendedIntakeResponse")
    public JAXBElement<GetRecommendedIntakeResponse> createGetRecommendedIntakeResponse(GetRecommendedIntakeResponse value) {
        return new JAXBElement<GetRecommendedIntakeResponse>(_GetRecommendedIntakeResponse_QNAME, GetRecommendedIntakeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFitnessAdviceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.advisor/", name = "getFitnessAdviceResponse")
    public JAXBElement<GetFitnessAdviceResponse> createGetFitnessAdviceResponse(GetFitnessAdviceResponse value) {
        return new JAXBElement<GetFitnessAdviceResponse>(_GetFitnessAdviceResponse_QNAME, GetFitnessAdviceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWeightAdvice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.advisor/", name = "getWeightAdvice")
    public JAXBElement<GetWeightAdvice> createGetWeightAdvice(GetWeightAdvice value) {
        return new JAXBElement<GetWeightAdvice>(_GetWeightAdvice_QNAME, GetWeightAdvice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFitnessAdvice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.advisor/", name = "getFitnessAdvice")
    public JAXBElement<GetFitnessAdvice> createGetFitnessAdvice(GetFitnessAdvice value) {
        return new JAXBElement<GetFitnessAdvice>(_GetFitnessAdvice_QNAME, GetFitnessAdvice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMealAdvice }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.advisor/", name = "getMealAdvice")
    public JAXBElement<GetMealAdvice> createGetMealAdvice(GetMealAdvice value) {
        return new JAXBElement<GetMealAdvice>(_GetMealAdvice_QNAME, GetMealAdvice.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMealAdviceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.advisor/", name = "getMealAdviceResponse")
    public JAXBElement<GetMealAdviceResponse> createGetMealAdviceResponse(GetMealAdviceResponse value) {
        return new JAXBElement<GetMealAdviceResponse>(_GetMealAdviceResponse_QNAME, GetMealAdviceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRecommendedIntake }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.advisor/", name = "getRecommendedIntake")
    public JAXBElement<GetRecommendedIntake> createGetRecommendedIntake(GetRecommendedIntake value) {
        return new JAXBElement<GetRecommendedIntake>(_GetRecommendedIntake_QNAME, GetRecommendedIntake.class, null, value);
    }

}
