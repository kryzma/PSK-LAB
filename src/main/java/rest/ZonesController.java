package rest;

import entities.Zone;
import org.mybatis.cdi.Transactional;
import persistence.ZonesDAO;
import rest.contracts.ZoneDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/zones")
public class ZonesController {

    @Inject
    private ZonesDAO zonesDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {

        System.out.println("Inside get");
        Zone zone = zonesDAO.findOne(id);
        if (zone == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        ZoneDto zoneDto = new ZoneDto();
        zoneDto.setName(zone.getName());

        return Response.ok(zoneDto).build();
    }


    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Integer id, ZoneDto newZone) {
        System.out.println("at put");
        Zone myZone = zonesDAO.findOne(id);

        if (myZone == null) {
            return Response.status(404).build();
        }

        myZone.setName(newZone.getName());

        zonesDAO.update(myZone);

        return Response.ok().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(Zone zone) {
        System.out.println("at post");
        Zone zoneToCreate = new Zone();
        zoneToCreate.setName(zone.getName());
        this.zonesDAO.persist(zoneToCreate);
        return Response.ok("hello").build();
    }

}
