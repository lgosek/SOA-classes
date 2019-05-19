package pl.edu.agh.soa.restws;

import pl.edu.agh.soa.model.StudentManager;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/students")
public class StudentRestApi{
    @Inject
    private StudentManager studentManager;

    @GET
    @Path("{id}/name")
    @Produces("application/Json")
    public String getStudentFirstName(@PathParam("id") int id){
        return this.studentManager.get(id).getFirstName();
    }
    //@PathParam("id") int id
}
