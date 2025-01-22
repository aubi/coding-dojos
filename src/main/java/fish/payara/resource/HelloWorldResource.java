package fish.payara.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

import java.time.ZonedDateTime;

@Path("hello")
public class HelloWorldResource {
    @Inject
    DateService dateService;

    @GET
    public Response hello(@QueryParam("name") String name) {
        if ((name == null) || name.trim().isEmpty()) {
            name = "world";
        }
        return Response
                .ok(name)
                .build();
    }

    @GET
    @Path("christmas")
    public long untilChristmas (@QueryParam("date") String date) {
        if (date == null) {
            return dateService.secondUntilChristmas(ZonedDateTime.now());
        }
        else {
            return dateService.secondUntilChristmas(ZonedDateTime.parse(date));
        }
    }

}