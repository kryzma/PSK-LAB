package rest;

import entities.Zone;
import lombok.*;
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
    @Setter @Getter
    private ZonesDAO zonesDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Zone zone = zonesDAO.findOne(id);
        if (zone == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        ZoneDto zoneDto = new ZoneDto();
        zoneDto.setName(zone.getName());

        return Response.ok(zoneDto).build();
    }

    /*
    @PUT
    @Path("{id}")
    public Response modifyZone(@PathParam("id") Integer id, Zone newZone) {
        try{
            Zone oldZone = zonesDAO.findOne(id);
            oldZone.setName(newZone.getName());
            zonesDAO.update(oldZone);
        }
        catch (Exception e){
            return Response.status(404).build();
        }
        return Response.ok().build();
    }
     */

}
