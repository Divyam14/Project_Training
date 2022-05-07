package com.divyam.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersoningController {

    /* Approach one for versioning is mapping separate uri for person v1 and person 2

    Approach two for versioning is using params in uri

    Approach three is using headers

    Approach four is using producers (Also called Content Negotiation or Accept versioning


     */
    @GetMapping("v1/person")
    public PersonV1 personV1(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2(){
        return new PersonV2(new Name("Bob","Charlie"));
    }


    @GetMapping(value="/person/param",params = "version=1")
    public PersonV1 paramV1(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value="/person/param",params = "version=2")
    public PersonV2 paramV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(value="/person/header",headers = "X-API-VERSION=1")
    public PersonV1 headerV1(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value="/person/header",headers = "X-API-VERSION=2")
    public PersonV2 header2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }

    @GetMapping(value="/person/produces",produces = "application/com.escalon.-v1+json")
    public PersonV1 producerV1(){
        return new PersonV1("Bob Charlie");
    }

    @GetMapping(value="/person/produces",produces = "application/com.escalon.-v2+json")
    public PersonV2 producerV2() {
        return new PersonV2(new Name("Bob", "Charlie"));
    }


}
