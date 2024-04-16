Task (something simple this time): create REST API

Spec: https://jakarta.ee/specifications/restful-ws/3.1/jakarta-restful-ws-spec-3.1

Branch: payara-2024-04-25-rest

Process:

1) New app (starter.payara.fish)

2) It includes some basic REST/GET, so try it

3) Create singular bean to store some data (create list of objects), counters

4) Create GET /rest/v1/entities endpoint to return all entities

5) Create GET /rest/v1/entities/ID endpoint to return one entity

6) Create POST /rest/v1/entities endpoint to create entity

7) Review /openapi

Useful annotations:

@Path("..."), @GET, @POST, @Produces(MediaType....)

Hint for POST:

@POST @Consumes("application/xml") public void registerUser(@Valid User user) {...



Testing hints:

curl -i -H "Content-Type: application/json" -X POST -d '{"username":"Adam","password":"Eve"}' http://localhost:8080/realm-based-security-example/rest/v1/security/login

curl -H "Cookie: JSESSIONID=255fae55304d64763da928143357" -H "Accept: application/json" -X PUT http://localhost/StatefulEJB/resources/counter



Interesting stuff to try:

AsyncResponse: https://jakarta.ee/specifications/restful-ws/3.1/jakarta-restful-ws-spec-3.1#async_response

CompletionStage: https://jakarta.ee/specifications/restful-ws/3.1/jakarta-restful-ws-spec-3.1#completionstage



Client API: https://jakarta.ee/specifications/restful-ws/3.1/jakarta-restful-ws-spec-3.1#client_api

Reactive Clients: https://jakarta.ee/specifications/restful-ws/3.1/jakarta-restful-ws-spec-3.1#reactive_clients

Asynchronous Client API: https://jakarta.ee/specifications/restful-ws/3.1/jakarta-restful-ws-spec-3.1#client_api_async
