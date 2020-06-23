package com.bandtech.eventech.controller.V1;

import com.bandtech.eventech.Service.V1.AddressService;
import com.bandtech.eventech.interfaces.IAdressOut;
import com.bandtech.eventech.model.V1.Address;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = AdrressController.class)
class AdrressControllerTest {
    @Autowired
    private AdrressController adrressController;
    Class classe = AdrressController.class;
    @MockBean
    AddressService addressService;
    final long ADDRES_ID = 40;
    ResponseEntity resposta;
    Method postForEntity;
    Method getForEntity;
    Method putForEntity;
    Method deleteUser;
    Address address;
    @Test
    void getForEntity()  {

        address = new Address();

        Mockito.when(addressService.getForEntity(ADDRES_ID)).thenReturn(address);

        resposta = adrressController.getForEntity(ADDRES_ID);

        assertEquals(200, resposta.getStatusCodeValue(), "ShouldBeReturn 200");

    }

    @Test
    void postForEntity() {

        //address = new Address();

        //Mockito.doAnswer(addressService.postForEntity(address)).when(address);
    }

    @Test
    void deleteUser() {
    }

    @Test
    void putForEntity() {
    }

    @Test
    void testConfig() throws NoSuchMethodException {
        getForEntity = classe.getDeclaredMethod("getForEntity",Long.class);

        assertTrue(getForEntity.isAnnotationPresent(GetMapping.class),
                "ShouldBe @GetMapping");

        postForEntity = classe.getDeclaredMethod("postForEntity", Address.class);

        assertTrue(postForEntity.isAnnotationPresent(PostMapping.class),
                "ShouldBe @PostMapping");

        deleteUser = classe.getDeclaredMethod("deleteUser", Long.class);

        assertTrue(deleteUser.isAnnotationPresent(DeleteMapping.class),
                "ShouldBe @DeleteMapping");

        putForEntity = classe.getDeclaredMethod("putForEntity", Long.class, Address.class);

        assertTrue(putForEntity.isAnnotationPresent(PutMapping.class),
                "ShouldBe @PutMapping");

    }
}