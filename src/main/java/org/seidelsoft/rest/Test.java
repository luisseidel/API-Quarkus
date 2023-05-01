package org.seidelsoft.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/teste")
public class Test {

    @GET
    public String get() {
        return "TESTESSSS!";
    }

}
