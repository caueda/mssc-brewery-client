package guru.springframework.msscbreweryclient.web.client;

import guru.springframework.msscbreweryclient.web.model.BeerDto;
import guru.springframework.msscbreweryclient.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {
        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
        assertEquals("Pale Ale",beerDto.getBeerStyle());
    }

    @Test
    void testSaveNewBeer() {
        var beerDto = BeerDto.builder()
                .beerName("New beer")
                .build();
        var location = breweryClient.saveNewBeer(beerDto);
        log.info("Location {}", location);
        assertNotNull(location);
    }

    @Test
    void testUpdateBeer() {
        var beerDto = BeerDto.builder()
                .beerName("New beer")
                .build();
        breweryClient.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void testDeleteBeer() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }

    @Test
    void getCustomerById() {
        CustomerDto customerDto = breweryClient.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void testSaveNewCustomer() {
        var customerDto = CustomerDto.builder()
                .name("Charles Xavier")
                .build();
        var location = breweryClient.saveNewCustomer(customerDto);
        log.info("Location {}", location);
        assertNotNull(location);
    }

    @Test
    void testUpdateCustomer() {
        var customerDto = CustomerDto.builder()
                .name("Charles Xavier")
                .build();
        breweryClient.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void testDeleteCustomer() {
        breweryClient.deleteCustomer(UUID.randomUUID());
    }
}