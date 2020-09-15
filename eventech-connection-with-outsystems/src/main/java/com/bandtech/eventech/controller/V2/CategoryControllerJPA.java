package com.bandtech.eventech.controller.V2;

import com.bandtech.eventech.model.V2.CategoryJPA;
import com.bandtech.eventech.Repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.*;

@RestController
@RequestMapping("/v2/categorys/CategoryJPA")
public class CategoryControllerJPA {
         @Autowired
         private ICategoryRepository repository;

    @PostMapping
    public ResponseEntity create(@RequestBody CategoryJPA category){
        repository.save(category);
        return status(201).build();
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity get(@PathVariable int categoryId){
        Optional<CategoryJPA> categories = repository.findById(categoryId);

            if (!categories.isPresent())
            {
                return  badRequest().build();
            }
            else {
                return ok(categories);
            }
    }
    @DeleteMapping("/{categoryId}")
    public ResponseEntity delete(@PathVariable int categoryId){
        if (this.repository.existsById(categoryId)) {
            this.repository.deleteById(categoryId);
            return ok().build();
        }
        else{
            return notFound().build();

        }
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity update(@PathVariable int categoryId,
                                 @RequestBody CategoryJPA category){
        Optional<CategoryJPA> consultaExistente = this.repository.findById(categoryId);
        if(consultaExistente.isPresent()) {
            CategoryJPA categoryEncontrado = consultaExistente.get();

            categoryEncontrado.setDescription(category.getDescription());
            categoryEncontrado.setCategoryName(category.getCategoryName());

            this.repository.save(categoryEncontrado);
            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
