
package pl.agh.edu.soa.connector;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pl.agh.edu.soa.connector package. 
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

    private final static QName _AddCourse_QNAME = new QName("http://ws.soa.agh.edu.pl/", "addCourse");
    private final static QName _AddCourseResponse_QNAME = new QName("http://ws.soa.agh.edu.pl/", "addCourseResponse");
    private final static QName _AddStudent_QNAME = new QName("http://ws.soa.agh.edu.pl/", "addStudent");
    private final static QName _AddStudentResponse_QNAME = new QName("http://ws.soa.agh.edu.pl/", "addStudentResponse");
    private final static QName _GetAllStudents_QNAME = new QName("http://ws.soa.agh.edu.pl/", "getAllStudents");
    private final static QName _GetAllStudentsResponse_QNAME = new QName("http://ws.soa.agh.edu.pl/", "getAllStudentsResponse");
    private final static QName _GetAvatar_QNAME = new QName("http://ws.soa.agh.edu.pl/", "getAvatar");
    private final static QName _GetAvatarResponse_QNAME = new QName("http://ws.soa.agh.edu.pl/", "getAvatarResponse");
    private final static QName _GetCourses_QNAME = new QName("http://ws.soa.agh.edu.pl/", "getCourses");
    private final static QName _GetCoursesResponse_QNAME = new QName("http://ws.soa.agh.edu.pl/", "getCoursesResponse");
    private final static QName _GetStudentFirstName_QNAME = new QName("http://ws.soa.agh.edu.pl/", "getStudentFirstName");
    private final static QName _GetStudentFirstNameResponse_QNAME = new QName("http://ws.soa.agh.edu.pl/", "getStudentFirstNameResponse");
    private final static QName _GetStudentLastName_QNAME = new QName("http://ws.soa.agh.edu.pl/", "getStudentLastName");
    private final static QName _GetStudentLastNameResponse_QNAME = new QName("http://ws.soa.agh.edu.pl/", "getStudentLastNameResponse");
    private final static QName _GetStudentNumber_QNAME = new QName("http://ws.soa.agh.edu.pl/", "getStudentNumber");
    private final static QName _GetStudentNumberResponse_QNAME = new QName("http://ws.soa.agh.edu.pl/", "getStudentNumberResponse");
    private final static QName _RemoveCourse_QNAME = new QName("http://ws.soa.agh.edu.pl/", "removeCourse");
    private final static QName _RemoveCourseResponse_QNAME = new QName("http://ws.soa.agh.edu.pl/", "removeCourseResponse");
    private final static QName _SetStudentFirstName_QNAME = new QName("http://ws.soa.agh.edu.pl/", "setStudentFirstName");
    private final static QName _SetStudentFirstNameResponse_QNAME = new QName("http://ws.soa.agh.edu.pl/", "setStudentFirstNameResponse");
    private final static QName _SetStudentLastName_QNAME = new QName("http://ws.soa.agh.edu.pl/", "setStudentLastName");
    private final static QName _SetStudentLastNameResponse_QNAME = new QName("http://ws.soa.agh.edu.pl/", "setStudentLastNameResponse");
    private final static QName _SetStudentNumber_QNAME = new QName("http://ws.soa.agh.edu.pl/", "setStudentNumber");
    private final static QName _SetStudentNumberResponse_QNAME = new QName("http://ws.soa.agh.edu.pl/", "setStudentNumberResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pl.agh.edu.soa.connector
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link GetCoursesResponse }
     * 
     */
    public GetCoursesResponse createGetCoursesResponse() {
        return new GetCoursesResponse();
    }

    /**
     * Create an instance of {@link GetAllStudentsResponse }
     * 
     */
    public GetAllStudentsResponse createGetAllStudentsResponse() {
        return new GetAllStudentsResponse();
    }

    /**
     * Create an instance of {@link AddCourse }
     * 
     */
    public AddCourse createAddCourse() {
        return new AddCourse();
    }

    /**
     * Create an instance of {@link AddCourseResponse }
     * 
     */
    public AddCourseResponse createAddCourseResponse() {
        return new AddCourseResponse();
    }

    /**
     * Create an instance of {@link AddStudent }
     * 
     */
    public AddStudent createAddStudent() {
        return new AddStudent();
    }

    /**
     * Create an instance of {@link AddStudentResponse }
     * 
     */
    public AddStudentResponse createAddStudentResponse() {
        return new AddStudentResponse();
    }

    /**
     * Create an instance of {@link GetAllStudents }
     * 
     */
    public GetAllStudents createGetAllStudents() {
        return new GetAllStudents();
    }

    /**
     * Create an instance of {@link GetAvatar }
     * 
     */
    public GetAvatar createGetAvatar() {
        return new GetAvatar();
    }

    /**
     * Create an instance of {@link GetAvatarResponse }
     * 
     */
    public GetAvatarResponse createGetAvatarResponse() {
        return new GetAvatarResponse();
    }

    /**
     * Create an instance of {@link GetCourses }
     * 
     */
    public GetCourses createGetCourses() {
        return new GetCourses();
    }

    /**
     * Create an instance of {@link GetStudentFirstName }
     * 
     */
    public GetStudentFirstName createGetStudentFirstName() {
        return new GetStudentFirstName();
    }

    /**
     * Create an instance of {@link GetStudentFirstNameResponse }
     * 
     */
    public GetStudentFirstNameResponse createGetStudentFirstNameResponse() {
        return new GetStudentFirstNameResponse();
    }

    /**
     * Create an instance of {@link GetStudentLastName }
     * 
     */
    public GetStudentLastName createGetStudentLastName() {
        return new GetStudentLastName();
    }

    /**
     * Create an instance of {@link GetStudentLastNameResponse }
     * 
     */
    public GetStudentLastNameResponse createGetStudentLastNameResponse() {
        return new GetStudentLastNameResponse();
    }

    /**
     * Create an instance of {@link GetStudentNumber }
     * 
     */
    public GetStudentNumber createGetStudentNumber() {
        return new GetStudentNumber();
    }

    /**
     * Create an instance of {@link GetStudentNumberResponse }
     * 
     */
    public GetStudentNumberResponse createGetStudentNumberResponse() {
        return new GetStudentNumberResponse();
    }

    /**
     * Create an instance of {@link RemoveCourse }
     * 
     */
    public RemoveCourse createRemoveCourse() {
        return new RemoveCourse();
    }

    /**
     * Create an instance of {@link RemoveCourseResponse }
     * 
     */
    public RemoveCourseResponse createRemoveCourseResponse() {
        return new RemoveCourseResponse();
    }

    /**
     * Create an instance of {@link SetStudentFirstName }
     * 
     */
    public SetStudentFirstName createSetStudentFirstName() {
        return new SetStudentFirstName();
    }

    /**
     * Create an instance of {@link SetStudentFirstNameResponse }
     * 
     */
    public SetStudentFirstNameResponse createSetStudentFirstNameResponse() {
        return new SetStudentFirstNameResponse();
    }

    /**
     * Create an instance of {@link SetStudentLastName }
     * 
     */
    public SetStudentLastName createSetStudentLastName() {
        return new SetStudentLastName();
    }

    /**
     * Create an instance of {@link SetStudentLastNameResponse }
     * 
     */
    public SetStudentLastNameResponse createSetStudentLastNameResponse() {
        return new SetStudentLastNameResponse();
    }

    /**
     * Create an instance of {@link SetStudentNumber }
     * 
     */
    public SetStudentNumber createSetStudentNumber() {
        return new SetStudentNumber();
    }

    /**
     * Create an instance of {@link SetStudentNumberResponse }
     * 
     */
    public SetStudentNumberResponse createSetStudentNumberResponse() {
        return new SetStudentNumberResponse();
    }

    /**
     * Create an instance of {@link Student.Courses }
     * 
     */
    public Student.Courses createStudentCourses() {
        return new Student.Courses();
    }

    /**
     * Create an instance of {@link GetCoursesResponse.Courses }
     * 
     */
    public GetCoursesResponse.Courses createGetCoursesResponseCourses() {
        return new GetCoursesResponse.Courses();
    }

    /**
     * Create an instance of {@link GetAllStudentsResponse.StudentsList }
     * 
     */
    public GetAllStudentsResponse.StudentsList createGetAllStudentsResponseStudentsList() {
        return new GetAllStudentsResponse.StudentsList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCourse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddCourse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.agh.edu.pl/", name = "addCourse")
    public JAXBElement<AddCourse> createAddCourse(AddCourse value) {
        return new JAXBElement<AddCourse>(_AddCourse_QNAME, AddCourse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCourseResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddCourseResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.agh.edu.pl/", name = "addCourseResponse")
    public JAXBElement<AddCourseResponse> createAddCourseResponse(AddCourseResponse value) {
        return new JAXBElement<AddCourseResponse>(_AddCourseResponse_QNAME, AddCourseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.agh.edu.pl/", name = "addStudent")
    public JAXBElement<AddStudent> createAddStudent(AddStudent value) {
        return new JAXBElement<AddStudent>(_AddStudent_QNAME, AddStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.agh.edu.pl/", name = "addStudentResponse")
    public JAXBElement<AddStudentResponse> createAddStudentResponse(AddStudentResponse value) {
        return new JAXBElement<AddStudentResponse>(_AddStudentResponse_QNAME, AddStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStudents }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllStudents }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.agh.edu.pl/", name = "getAllStudents")
    public JAXBElement<GetAllStudents> createGetAllStudents(GetAllStudents value) {
        return new JAXBElement<GetAllStudents>(_GetAllStudents_QNAME, GetAllStudents.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStudentsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllStudentsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.agh.edu.pl/", name = "getAllStudentsResponse")
    public JAXBElement<GetAllStudentsResponse> createGetAllStudentsResponse(GetAllStudentsResponse value) {
        return new JAXBElement<GetAllStudentsResponse>(_GetAllStudentsResponse_QNAME, GetAllStudentsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvatar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAvatar }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.agh.edu.pl/", name = "getAvatar")
    public JAXBElement<GetAvatar> createGetAvatar(GetAvatar value) {
        return new JAXBElement<GetAvatar>(_GetAvatar_QNAME, GetAvatar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvatarResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAvatarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.agh.edu.pl/", name = "getAvatarResponse")
    public JAXBElement<GetAvatarResponse> createGetAvatarResponse(GetAvatarResponse value) {
        return new JAXBElement<GetAvatarResponse>(_GetAvatarResponse_QNAME, GetAvatarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCourses }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCourses }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.agh.edu.pl/", name = "getCourses")
    public JAXBElement<GetCourses> createGetCourses(GetCourses value) {
        return new JAXBElement<GetCourses>(_GetCourses_QNAME, GetCourses.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCoursesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetCoursesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.agh.edu.pl/", name = "getCoursesResponse")
    public JAXBElement<GetCoursesResponse> createGetCoursesResponse(GetCoursesResponse value) {
        return new JAXBElement<GetCoursesResponse>(_GetCoursesResponse_QNAME, GetCoursesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentFirstName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentFirstName }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.agh.edu.pl/", name = "getStudentFirstName")
    public JAXBElement<GetStudentFirstName> createGetStudentFirstName(GetStudentFirstName value) {
        return new JAXBElement<GetStudentFirstName>(_GetStudentFirstName_QNAME, GetStudentFirstName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentFirstNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentFirstNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.agh.edu.pl/", name = "getStudentFirstNameResponse")
    public JAXBElement<GetStudentFirstNameResponse> createGetStudentFirstNameResponse(GetStudentFirstNameResponse value) {
        return new JAXBElement<GetStudentFirstNameResponse>(_GetStudentFirstNameResponse_QNAME, GetStudentFirstNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentLastName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentLastName }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.agh.edu.pl/", name = "getStudentLastName")
    public JAXBElement<GetStudentLastName> createGetStudentLastName(GetStudentLastName value) {
        return new JAXBElement<GetStudentLastName>(_GetStudentLastName_QNAME, GetStudentLastName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentLastNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentLastNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.agh.edu.pl/", name = "getStudentLastNameResponse")
    public JAXBElement<GetStudentLastNameResponse> createGetStudentLastNameResponse(GetStudentLastNameResponse value) {
        return new JAXBElement<GetStudentLastNameResponse>(_GetStudentLastNameResponse_QNAME, GetStudentLastNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentNumber }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentNumber }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.agh.edu.pl/", name = "getStudentNumber")
    public JAXBElement<GetStudentNumber> createGetStudentNumber(GetStudentNumber value) {
        return new JAXBElement<GetStudentNumber>(_GetStudentNumber_QNAME, GetStudentNumber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentNumberResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetStudentNumberResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.agh.edu.pl/", name = "getStudentNumberResponse")
    public JAXBElement<GetStudentNumberResponse> createGetStudentNumberResponse(GetStudentNumberResponse value) {
        return new JAXBElement<GetStudentNumberResponse>(_GetStudentNumberResponse_QNAME, GetStudentNumberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveCourse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveCourse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.agh.edu.pl/", name = "removeCourse")
    public JAXBElement<RemoveCourse> createRemoveCourse(RemoveCourse value) {
        return new JAXBElement<RemoveCourse>(_RemoveCourse_QNAME, RemoveCourse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveCourseResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemoveCourseResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.agh.edu.pl/", name = "removeCourseResponse")
    public JAXBElement<RemoveCourseResponse> createRemoveCourseResponse(RemoveCourseResponse value) {
        return new JAXBElement<RemoveCourseResponse>(_RemoveCourseResponse_QNAME, RemoveCourseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetStudentFirstName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetStudentFirstName }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.agh.edu.pl/", name = "setStudentFirstName")
    public JAXBElement<SetStudentFirstName> createSetStudentFirstName(SetStudentFirstName value) {
        return new JAXBElement<SetStudentFirstName>(_SetStudentFirstName_QNAME, SetStudentFirstName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetStudentFirstNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetStudentFirstNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.agh.edu.pl/", name = "setStudentFirstNameResponse")
    public JAXBElement<SetStudentFirstNameResponse> createSetStudentFirstNameResponse(SetStudentFirstNameResponse value) {
        return new JAXBElement<SetStudentFirstNameResponse>(_SetStudentFirstNameResponse_QNAME, SetStudentFirstNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetStudentLastName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetStudentLastName }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.agh.edu.pl/", name = "setStudentLastName")
    public JAXBElement<SetStudentLastName> createSetStudentLastName(SetStudentLastName value) {
        return new JAXBElement<SetStudentLastName>(_SetStudentLastName_QNAME, SetStudentLastName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetStudentLastNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetStudentLastNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.agh.edu.pl/", name = "setStudentLastNameResponse")
    public JAXBElement<SetStudentLastNameResponse> createSetStudentLastNameResponse(SetStudentLastNameResponse value) {
        return new JAXBElement<SetStudentLastNameResponse>(_SetStudentLastNameResponse_QNAME, SetStudentLastNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetStudentNumber }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetStudentNumber }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.agh.edu.pl/", name = "setStudentNumber")
    public JAXBElement<SetStudentNumber> createSetStudentNumber(SetStudentNumber value) {
        return new JAXBElement<SetStudentNumber>(_SetStudentNumber_QNAME, SetStudentNumber.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetStudentNumberResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SetStudentNumberResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.soa.agh.edu.pl/", name = "setStudentNumberResponse")
    public JAXBElement<SetStudentNumberResponse> createSetStudentNumberResponse(SetStudentNumberResponse value) {
        return new JAXBElement<SetStudentNumberResponse>(_SetStudentNumberResponse_QNAME, SetStudentNumberResponse.class, null, value);
    }

}
