package nsu.com.movie_db_postgres.controllers;

import nsu.com.movie_db_postgres.models.CommonResponse;
import nsu.com.movie_db_postgres.models.Customer;
import nsu.com.movie_db_postgres.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<CommonResponse> getAllCustomer() {

        var commonResponse = new CommonResponse();
        commonResponse.data = customerRepository.findAll();
        commonResponse.message = "All customer";

        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<CommonResponse> addCustomer(@RequestBody Customer customer) {

        customer = customerRepository.save(customer);

        var commonResponse = new CommonResponse();
        commonResponse.data = customer;
        commonResponse.message = "added customer: " + customer.getCustomerName();

        return new ResponseEntity<>(commonResponse, HttpStatus.OK);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<CommonResponse> deleteCustomer(@PathVariable Integer id) {
        {
            CommonResponse cr = new CommonResponse();
            HttpStatus resp;

            if (customerRepository.existsById(id)) {
                cr.message = "Deleted Customer with id: " + id;
                resp = HttpStatus.OK;
            } else {
                cr.message = "Customer not found with id: " + id;
                resp = HttpStatus.NOT_FOUND;
            }

            return new ResponseEntity<>(cr, resp);
        }
    }

}