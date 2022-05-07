package com.divyam.rest.webservices.restfulwebservices.models;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("SomeBeanFilter")
public class SomeBean2 {
    private String field1;
    private String field2;
    private String field3;

}
