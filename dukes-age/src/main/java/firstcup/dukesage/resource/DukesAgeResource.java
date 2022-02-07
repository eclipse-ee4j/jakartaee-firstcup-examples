/*
 * Copyright (c) 2014, 2021 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v. 1.0, which is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */

package firstcup.dukesage.resource;

import java.time.LocalDate;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

/**
 * REST Web Service
 *
 */
@Path("dukesAge")
public class DukesAgeResource {

    /** Creates a new instance of DukesAgeResource */
    public DukesAgeResource() {
    }

    /**
     * Retrieves representation of an instance of DukesAgeResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    public String getText() {
        // Create a new Calendar for Duke's birthday
        LocalDate dukesBirthday = LocalDate.of(1995, 5, 23);
        // Create a new Calendar for today
        LocalDate now = LocalDate.now();

        // Subtract today's year from Duke's birth year, 1995
        int dukesAge = now.getYear() - dukesBirthday.getYear();
        LocalDate thisBirthday = dukesBirthday.plusYears(dukesAge);

        // If today's date is before May 23, subtract a year from Duke's age
        if (now.isBefore(thisBirthday)) {
            dukesAge--;
        }
        // Return a String representation of Duke's age
        return "" + dukesAge;
    }
}
