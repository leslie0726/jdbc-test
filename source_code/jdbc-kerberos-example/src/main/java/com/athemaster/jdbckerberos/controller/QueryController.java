package com.athemaster.jdbckerberos.controller;

import com.athemaster.jdbckerberos.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class QueryController {

    @Autowired
    QueryService queryService;

    @RequestMapping(value = "query", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String query(){
        return queryService.query().toString();
    }
}
