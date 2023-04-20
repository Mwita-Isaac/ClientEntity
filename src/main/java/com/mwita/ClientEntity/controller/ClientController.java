package com.mwita.ClientEntity.controller;

import com.mwita.ClientEntity.exception.ResourceNotFound;
import com.mwita.ClientEntity.model.client;
import com.mwita.ClientEntity.repository.Client_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    @Autowired
    private Client_Repo Client_Repo;

    @GetMapping
    public List<client> getAllClient(){
        return Client_Repo.findAll();
    }

    @PostMapping
    public client createEmployee(@RequestBody client client) {
        return Client_Repo.save(client);
    }

    // build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<client> getEmployeeById(@PathVariable  long id){
        client employee = Client_Repo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Client does not exist with id:" + id));
        return ResponseEntity.ok(employee);
    }

    // build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<client> updateEmployee(@PathVariable long id,@RequestBody client clientDetails) {
        client updateEmployee = Client_Repo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Client does not exist with id: " + id));

        updateEmployee.setFirstName(clientDetails.getFirstName());
        updateEmployee.setLastName(clientDetails.getLastName());
        updateEmployee.setEmailId(clientDetails.getEmailId());

        Client_Repo.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){

        client employee = Client_Repo.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Client does not exist with id: " + id));

        Client_Repo.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}


