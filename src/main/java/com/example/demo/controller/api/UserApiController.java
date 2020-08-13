package com.example.demo.controller.api;

import com.example.demo.controller.ifs.CrudInterface;
import com.example.demo.model.network.Header;
import com.example.demo.model.network.request.UserApiRequest;
import com.example.demo.model.network.response.UserApiResponse;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Override
    @PostMapping("") // /api/user
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> userApiRequest) {
        return null;
    }

    @Override
    @GetMapping("{id}") // /api/user/{id}
    public Header<UserApiResponse> read(@PathVariable(name="id") Long id) {
        return null;
    }

    @Override
    @PutMapping("") // /api/user
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> userApiRequest) {
        return null;
    }

    @Override
    @DeleteMapping("{id}") // /api/user/{id}
    public Header delete(@PathVariable Long id) {
        return null;
    }
}
