package org.acme.resource;

import org.acme.configmap.ErrorConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/config")
public class ConfigResource {
    private static final Logger TRACE = LogManager.getLogger("TRACE");

    @Inject
    ErrorConfig errorConfig;

    /*
     * To load config properties values into map
     */
    @GET
    @Path("/{code}")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@PathParam("code") String messageCode) {
        ErrorConfig.ErrorInfo value = null;
        String reason = "message code is not found";

        if (errorConfig.error().containsKey(messageCode)) {
            value = errorConfig.error().get(messageCode);
            reason = value.reason();
        }
        return reason;
    }

}
