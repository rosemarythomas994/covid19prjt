package com.hospital.covid;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import com.hospital.covid.CovidRepository;
import com.hospital.covid.Covid;
import org.springframework.stereotype.Service;

@Service
public class CovidService {
    @Autowired
    private CovidRepository covidRepository;


    public JSONObject getAllPatient(){
        List<Covid> covidList = new ArrayList<>();
        covidRepository.findAll().forEach(covidList::add);
        JSONObject obj = new JSONObject();
        obj.put("message", "List of patients in database is attached herewith");
        obj.put("covidlist", covidList);
        return obj;
    }

    public JSONObject addPatient(Covid key){
        covidRepository.save(key);
        JSONObject obj = new JSONObject();
        obj.put("message", "Successfully added a new Patient!");
        return obj;
    }

    public JSONObject updatePatient(String id, Covid key){
        covidRepository.save(key);
        JSONObject obj = new JSONObject();
        obj.put("message", "Successfully updated the Patient");
        obj.put("PatientId", id);
        return obj;
    }

    public JSONObject deletePatient(String id){
        covidRepository.deleteById(id);
        JSONObject obj = new JSONObject();
        obj.put("message", "Successfully deleted the Patient");
        obj.put("PatientId", id);
        return obj;
    }

    public JSONObject validatePatient(Covid covid){
        JSONObject obj = new JSONObject();


        if(covid.getId().equals("")){
            obj.put("status", "failed");
            obj.put("message", "Register Number is not given");
            return obj;
        }


        obj.put("status", "success");
        obj.put("message", "User entry is possible");
        return obj;

    }
}
