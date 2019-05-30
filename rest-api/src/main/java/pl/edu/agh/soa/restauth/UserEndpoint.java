package pl.edu.agh.soa.restauth;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.annotation.PostConstruct;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static io.jsonwebtoken.security.Keys.secretKeyFor;
import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

@Path("/login")
@Produces("application/Json")
@Consumes("application/Json")
@Api(value = "LoginService", description = "Endpoint for JWT Token retrieval")
public class UserEndpoint {
    public static Key key = secretKeyFor(SignatureAlgorithm.HS512);
    private List<User> users = new LinkedList<User>();

    @PostConstruct
    void init(){
        users.add(new User("user", "pass"));
    }

    @POST
    @Path("/")
    @ApiOperation(value = "Login endpoint")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Login successful, returned JWT token"),
            @ApiResponse(code = 401, message = "Invalid authorization data")})
    public Response authenticateUser(User user) {
//        ObjectMapper mapper = new ObjectMapper();
        try {
//            User user = mapper.readValue(json, User.class);

            // Authenticate the user using the credentials provided
            authenticate(user);

            // Issue a token for the user
            String token = issueToken(user.getLogin());

            // Return the token on the response
            return Response.ok().header(AUTHORIZATION, "Bearer " + token).build();

        } catch (Exception e) {
            return Response.status(UNAUTHORIZED).header("Reason", e.getMessage()).build();
        }
    }

    private void authenticate (User usr) throws Exception {
        for (User user:users) {
            if(user.getLogin().equals(usr.getLogin()) && user.getPassword().equals(usr.getPassword()))
                return;
        }
        throw new Exception("Authorisation failed");
    }

    private String issueToken(String login) {
        String keyString = "simplekey";
//        Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "HmacSHA512");

        String jwtToken = Jwts.builder()
                .setSubject(login)
                .setIssuer("http://localhost:8080/rest-api/api/login/")
                .setIssuedAt(new Date())
                .setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        return jwtToken;
    }

    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}