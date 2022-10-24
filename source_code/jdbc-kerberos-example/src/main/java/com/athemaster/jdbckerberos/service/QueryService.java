package com.athemaster.jdbckerberos.service;

import com.athemaster.jdbckerberos.entity.UsersEntity;
import com.athemaster.jdbckerberos.repository.UsersRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class QueryService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UsersRepository usersRepository;

    public JSONObject query() {
        List<UsersEntity> list = usersRepository.findAll();
        JSONObject result = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        for (UsersEntity usersEntity : list) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name",usersEntity.getName());
            jsonObject.put("age",usersEntity.getAge());
            jsonArray.put(jsonObject);
        }
        result.put("result",jsonArray);
        return result;
    }
}
