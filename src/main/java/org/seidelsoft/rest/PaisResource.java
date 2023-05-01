package org.seidelsoft.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import lombok.AllArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.hibernate.service.spi.ServiceException;
import org.seidelsoft.model.pais.Pais;
import org.seidelsoft.model.pais.PaisDTO;
import org.seidelsoft.util.MediaTypes;
import org.seidelsoft.service.PaisService;

import java.net.URI;
import java.util.Objects;

@Path("/paises")
@Produces(MediaTypes.APPLICATION_JSON_UTF_8)
@Consumes(MediaTypes.APPLICATION_JSON_UTF_8)
@Tag(name = "pais", description = "Pais Operations")
@AllArgsConstructor
public class PaisResource {

    private final PaisService service;

    @GET
    @APIResponse(
            responseCode = "200",
            description = "Get all paises",
            content = @Content(
                    mediaType = MediaTypes.APPLICATION_JSON_UTF_8,
                    schema = @Schema(type = SchemaType.ARRAY, implementation = Pais.class)
            )
    )
    public Response get() {
        return Response.ok(service.findAll()).build();
    }

    @GET
    @Path("/{id}")
    @APIResponses(value = {
        @APIResponse(
                responseCode = "200", description = "Get paises by customerId",
                content = @Content(
                        mediaType = MediaTypes.APPLICATION_JSON,
                        schema = @Schema(type = SchemaType.OBJECT, implementation = Pais.class)
                )
        ),
        @APIResponse(
                responseCode = "404",
                description = "Pais does not exist for Id",
                content = @Content(mediaType = MediaTypes.APPLICATION_JSON)
        )
    })
    public Response getById(@Parameter(name = "id", required = true) @PathParam("id") Long id) {
        return service.findById(id)
                .map(pais -> Response.ok(pais).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());

    }

    @POST
    @Path("/{id}")
    @APIResponses(value = {
            @APIResponse(
                    responseCode = "201",
                    description = "Pais Created",
                    content = @Content(
                            mediaType = MediaTypes.APPLICATION_JSON,
                            schema = @Schema(type = SchemaType.OBJECT, implementation = Pais.class)
                    )
            ),
            @APIResponse(
                    responseCode = "400",
                    description = "Pais invalid",
                    content = @Content(mediaType = MediaTypes.APPLICATION_JSON)
            ),
            @APIResponse(
                    responseCode = "400",
                    description = "Pais already exists for id",
                    content = @Content(mediaType = MediaTypes.APPLICATION_JSON)
            )
    })
    public Response post(@NotNull @Valid PaisDTO dto, @Context UriInfo uriInfo) {
        service.save(dto);
        URI uri = uriInfo.getAbsolutePathBuilder().path(Long.toString(dto.getId())).build();
        return Response.created(uri).entity(dto).build();
    }

    @PUT
    @Path("/{id}")
    @APIResponse(
            responseCode = "204",
            description = "Pais updated",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(type = SchemaType.OBJECT, implementation = Pais.class)
            )
    )
    @APIResponse(
            responseCode = "400",
            description = "Invalid Pais",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @APIResponse(
            responseCode = "400",
            description = "Pais object does not have id",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @APIResponse(
            responseCode = "400",
            description = "Path variable id does not match Pais.id",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    @APIResponse(
            responseCode = "404",
            description = "No Pais found for id provided",
            content = @Content(mediaType = MediaType.APPLICATION_JSON)
    )
    public Response put(@Parameter(name = "id", required = true) @PathParam("id") Integer customerId, @NotNull @Valid PaisDTO dto) {
        if (!Objects.equals(customerId, dto.getId())) {
            throw new ServiceException("Path variable customerId does not match Customer.customerId");
        }
        service.update(dto);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
