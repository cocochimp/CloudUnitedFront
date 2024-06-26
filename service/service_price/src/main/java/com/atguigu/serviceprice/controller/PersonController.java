package com.atguigu.serviceprice.controller;

import com.atguigu.serviceprice.entity.Person;
import com.atguigu.serviceprice.service.IPersonService;
import com.atguigu.serviceprice.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/servicePerson/pricePersons")
public class PersonController extends BaseController{
    @Autowired
    private IPersonService personService;

    /*分页查询*/
    @RequestMapping("/person/selectByPage")
    public JsonResult<Map> selectByPage(int current, int number){
        Map map = personService.selectPerson(current, number);
        return new JsonResult<>(OK,map);
    }

    /*查询全部*/
    @RequestMapping("/person/selectAllPerson")
    public JsonResult<List<Person>> selectList(){
        List<Person> people = personService.selectList();
        return new JsonResult<>(OK,people);
    }

    /*根据姓名查询*/
    @RequestMapping("/person/selectByName")
    public JsonResult<List<Person>> selectByName(String name){
        List<Person> people = personService.selectByName(name);
        return new JsonResult<>(OK,people);
    }

}
