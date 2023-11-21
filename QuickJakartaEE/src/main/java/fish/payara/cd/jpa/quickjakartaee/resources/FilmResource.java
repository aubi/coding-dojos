package fish.payara.cd.jpa.quickjakartaee.resources;

import fish.payara.cd.jpa.quickjakartaee.controller.FilmController;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("film")
public class FilmResource {

    @EJB
    private FilmController filmController;
    
    @GET
    public Response findAll(){
        return Response
                .ok(filmController.listOfFilms())
                .build();
    }
}
