package com.divyam.rest.webservices.restfulwebservices.filtering;

import com.divyam.rest.webservices.restfulwebservices.models.SomeBean;
import com.divyam.rest.webservices.restfulwebservices.models.SomeBean2;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public SomeBean retrieveSomeBean() {
        return new SomeBean("value1","value2","value3");
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> retrieveSomeBeanList(){
        return Arrays.asList(new SomeBean("value1","value2","value3"),new SomeBean("value12","value22","value3"));
    }

    //field1,field2
    @GetMapping("/dynamic-filtering")
    public MappingJacksonValue retrieveSomeBeanDynamic() {
        SomeBean2 someBean = new SomeBean2("value1", "value2", "value3");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(someBean);

        mapping.setFilters(filters);
        return mapping;
    }

    //field2,field3
    @GetMapping("/dynamic-filtering-list")
    public MappingJacksonValue retrieveSomeBeanListDynamic(){



        List<SomeBean2> list = Arrays.asList(new SomeBean2("value1", "value2", "value3"), new SomeBean2("value12", "value22", "value32"));

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(list);
        mapping.setFilters(filters);

        return mapping;
    }

}
