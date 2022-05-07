package com.divyam.rest.webservices.restfulwebservices.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value={"field1","field2"})
public class SomeBean {
    private String field1;
    private String field2;

    //use com.fasterxml.jackson.annotation.JsonIgnore
    //@JsonIgnore
    private String field3;


    /*
    Use @JsonIgnore to filter the specific field
    if need to filer more JsonIgnoreProperties(value={"field1","field2"}) can be used
     */
}
