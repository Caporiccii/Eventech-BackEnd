package com.bandtech.eventech.controller.V1;

import com.bandtech.eventech.Service.V1.AddressService;
import com.bandtech.eventech.interfaces.IAdressOut;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = AdrressController.class)
class AdrressControllerTest {
    @Autowired
    private AdrressController adrressController;
    Class classe = AdrressController.class;
    @MockBean
    AddressService addressService;

    ResponseEntity resposta;
    Method postForEntity;
    Method getForEntity;
    Method putForEntity;
    Method updateUser;




    @Test
    void getForEntity()  {

        Mockito.when(getForEntity);

    }

    @Test
    void postForEntity() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void putForEntity() {
    }

    @Test
    void testConfig() throws NoSuchMethodException {
        getForEntity = classe.getDeclaredMethod("getForEntity",Long.class);

        assertTrue(getForEntity.isAnnotationPresent(GetMapping.class),
                "Deve conter o @GetMapping");
    }
}