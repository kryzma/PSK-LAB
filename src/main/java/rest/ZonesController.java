package rest;

import entities.Zone;
import org.mybatis.cdi.Transactional;
import persistence.ZonesDAO;
import rest.contracts.ZoneDto;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Model
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
    public Response update(
            @PathParam("id") final Integer zoneId,
            ZoneDto zoneData) {
        System.out.println("inside put");
        try {
            Zone existingZone = zonesDAO.findOne(zoneId);
            if (existingZone == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            System.out.println("new name = " + zoneData.getName());
            existingZone.setName(zoneData.getName());
            zonesDAO.update(existingZone);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(ZoneDto newZone) {
        System.out.println("at post");
        Zone zoneToCreate = new Zone();
        zoneToCreate.setName(newZone.getName());
        System.out.println("new zone name = " + newZone.getName());
        this.zonesDAO.persist(zoneToCreate);
        return Response.ok("hello").build();
    }

}
