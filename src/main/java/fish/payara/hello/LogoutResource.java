package fish.payara.hello;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("logout")
public class LogoutResource {

    @Inject
    private HttpServletRequest request;

    @GET
    public String logout() throws ServletException {
        request.logout();
        var session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            return "You have been logged out";
        }
        return "No session";
    }

}
