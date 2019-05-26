package pl.edu.agh.soa.restws;

import pl.edu.agh.soa.restauth.UserEndpoint;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class RestApiApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(StudentRestApi.class);
        h.add(UserEndpoint.class);
        return h;
    }
}
