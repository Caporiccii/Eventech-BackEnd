package com.bandtech.eventech.interfaces;

import com.bandtech.eventech.model.V1.Category;

public interface ICategoryOut {

     Category getForEntity(Long categoryId);

    void postForEntity(Category category);

    void deleteForEntity(Long categoryId);

    void putForEntity(Long categoryId, Category category);

}
