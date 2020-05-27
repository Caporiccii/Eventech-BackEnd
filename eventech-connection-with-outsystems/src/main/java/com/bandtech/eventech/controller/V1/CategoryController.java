package com.bandtech.eventech.controller.V1;


import com.bandtech.eventech.Service.V1.CategoryService;
import com.bandtech.eventech.model.V1.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/categorys")
public class CategoryController {

    CategoryService categoryService = new CategoryService();
    Category response;

    @GetMapping("/{categoryId}")
    public ResponseEntity getForEntity(@PathVariable("categoryId") Long categoryId){

        response = categoryService.getForEntity(categoryId);
        return ok().body(response);
    }
    @PostMapping
    public ResponseEntity postUser(@RequestBody Category category){

        categoryService.postForEntity(category);

        return status(201).build();
    }
    @DeleteMapping("/{categoryId}")
    public ResponseEntity deleteUserById(@PathVariable("categoryId") Long categoryId){

        categoryService.deleteForEntity(categoryId);
        return ok().build();
    }
    @PutMapping("/{categoryId}")
    public ResponseEntity updateUser(@PathVariable("categoryId") Long categoryId,
                                     @RequestBody Category category) {


        return ok().build();
    }
}
