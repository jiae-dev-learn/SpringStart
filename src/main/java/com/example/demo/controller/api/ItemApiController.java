package com.example.demo.controller.api;

import com.example.demo.controller.CrudController;
import com.example.demo.controller.ifs.CrudInterface;
import com.example.demo.model.network.Header;
import com.example.demo.model.network.request.ItemApiRequest;
import com.example.demo.model.network.response.ItemApiResponse;
import com.example.demo.service.ItemApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse> {

    @Autowired
    private ItemApiLogicService itemApiLogicService;

    @PostConstruct
    public void init(){
        this.baseService = itemApiLogicService;
    }
//    @PostMapping("")
//    @Override
//    public Header<ItemApiResponse> create(@RequestBody Header<ItemApiRequest> request) {
//        log.info("{}",request);
//        return itemApiLogicService.create(request);
//    }
//
//    @Override
//    @GetMapping("{id}")
//    public Header<ItemApiResponse> read(@PathVariable Long id) {
//        log.info("id: {}",id);
//        return itemApiLogicService.read(id);
//    }
//
//    @Override
//    @PutMapping("")
//    public Header<ItemApiResponse> update(@RequestBody Header<ItemApiRequest> request) {
//        log.info("{}",request);
//        return itemApiLogicService.update(request);
//    }
//
//    @Override
//    @DeleteMapping("{id}")
//    public Header delete(@PathVariable Long id) {
//        log.info("id: {}", id);
//        return itemApiLogicService.delete(id);
//    }
}
