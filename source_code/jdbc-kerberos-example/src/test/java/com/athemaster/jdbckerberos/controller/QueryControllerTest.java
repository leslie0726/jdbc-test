package com.athemaster.jdbckerberos.controller;

import com.athemaster.jdbckerberos.entity.UsersEntity;
import com.athemaster.jdbckerberos.repository.UsersRepository;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;


@SpringBootTest
public class QueryControllerTest {

    @MockBean
    private UsersRepository usersRepository;

    @Autowired
    private QueryController queryController;


    @Test
    public void test() throws ParseException {
        List<UsersEntity> mockList = new ArrayList<>();
        UsersEntity mockEntity = new UsersEntity();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("2021-04-09");

        mockEntity.setName("jojo");
        mockEntity.setAge(10);
        mockList.add(mockEntity);
        when(usersRepository.findAll()).thenReturn(mockList);

        String result = queryController.query();
        JSONObject jsonObject =(JSONObject) new JSONObject(result).getJSONArray("result").get(0);
        Assertions.assertEquals("jojo", jsonObject.get("name"));
        Assertions.assertEquals(10, jsonObject.get("age"));


    }

}