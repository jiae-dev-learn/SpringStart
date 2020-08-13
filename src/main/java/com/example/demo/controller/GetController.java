package com.example.demo.controller;

import com.example.demo.model.SearchParam;
import com.example.demo.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api") //http://localhost:8080/api
public class GetController {

    //http://localhost:8080/api/getMethod
    @RequestMapping(method = RequestMethod.GET, path = "/getMethod")
    public String getRequest(){

        return "Hi getMethod";
    }

    @GetMapping("/getParameter") //localhost:8080/api/getParameter?id=1234&password=abcd
    public String getParameter(@RequestParam String id, @RequestParam(name="password") String pwd){
        String password = "bbbb";
        System.out.println("id: " + id);
        System.out.println("pwd: " + pwd);

        return id+pwd;
    }

    //localhost:8080/api/getMultiParameter?account=abcd&email=study@gmail.com&page=10
    //위처럼 파라미터값이 많을 경우 아래와 같이 multiparameter처럼 객체로 값을 받아올 수 있음.
    @GetMapping ("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        // { "account" : "", "email" : "", "page" : 0 }
        return searchParam;
    }

    @GetMapping("/header")
    public Header getHeader(){

        // {"resultCode: "OK", "description": "OK"}
        return Header.builder().resultCode("OK").description("OK").build();
    }

}
