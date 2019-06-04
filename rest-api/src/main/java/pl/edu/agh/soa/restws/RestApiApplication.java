package pl.edu.agh.soa.restws;

import io.swagger.jaxrs.config.BeanConfig;
import pl.edu.agh.soa.model.proto.StudentProtocMessageBodyProvider;
import pl.edu.agh.soa.restauth.JWTTokenNeededFilter;
import pl.edu.agh.soa.restauth.UserEndpoint;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class RestApiApplication extends Application {
    public RestApiApplication(){
        init();
    }

    private void init () {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/rest-api/api");
        beanConfig.setResourcePackage(StudentRestApi.class.getPackage().getName() + "," + UserEndpoint.class
                .getPackage().getName());
        beanConfig.setTitle("Swagger UI documentation for Student REST Web Service");
        beanConfig.setDescription("Sample RESTful API built using RESTEasy, Swagger and Swagger UI");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(StudentRestApi.class);
        h.add(RestApiJpa.class);
        h.add(UserEndpoint.class);
        h.add(JWTTokenNeededFilter.class);
        h.add(StudentProtocMessageBodyProvider.class);
        h.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        h.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        return h;
    }
}
