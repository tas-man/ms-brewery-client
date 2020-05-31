package tas.springframework.msbreweryclient.web.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tas.springframework.msbreweryclient.web.model.BeerDto;
import tas.springframework.msbreweryclient.web.model.CustomerDto;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    // Beer API

    @Test
    void getBeerByIdTest() {
        BeerDto beerDto = client.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }

    @Test
    void saveNewBeerTest() {
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        URI uri = client.saveNewBeer(beerDto);
        assertNotNull(uri);
    }

    @Test
    void updateBeerTest() {
        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        client.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void deleteBeerTest() {
        client.deleteBeer(UUID.randomUUID());
    }

    // Customer API

    @Test
    void getCustomerByIdTest() {
        CustomerDto customerDto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void saveNewCustomerTest() {
        CustomerDto customerDto = CustomerDto.builder().customerName("New Customer").build();
        URI uri = client.saveNewCustomer(customerDto);
        assertNotNull(uri);
    }

    @Test
    void updateCustomerTest() {
        CustomerDto customerDto = CustomerDto.builder().customerName("New Customer").build();
        client.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void deleteCustomer() {
        client.deleteCustomer(UUID.randomUUID());
    }
}