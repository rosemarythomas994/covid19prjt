package com.hospital.covid;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hospital.covid.CovidService;

@RestController
public class CovidController {

    @Autowired
    private CovidService covidservice;

    // Displaying all patients
    @GetMapping("/patient")
    public ResponseEntity<?> getAllPatients(){
        return ResponseEntity.status(HttpStatus.OK).body(covidservice.getAllPatient());
    }

    // Adding a new patient
    @PostMapping("/patient")
    public ResponseEntity<?> addPatient(@RequestBody Covid pat){
        JSONObject validate = covidservice.validatePatient(pat);
        if(validate.get("status").equals("success")){
            JSONObject msg = covidservice.addPatient(pat);
            return ResponseEntity.status(HttpStatus.OK).body(msg);
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(validate);
        }
    }

    // Updating a patient
    @PutMapping("/patient/{id}")
    public ResponseEntity<?> updatePatient(@PathVariable String id, @RequestBody Covid pat){
        JSONObject msg = covidservice.updatePatient(id, pat);
        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }

    // Deleting a patient
    @DeleteMapping("/patient/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable String id){
        JSONObject msg = covidservice.deletePatient(id);
        return ResponseEntity.status(HttpStatus.OK).body(msg);
    }

}