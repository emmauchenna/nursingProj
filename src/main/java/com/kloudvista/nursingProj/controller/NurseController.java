package com.kloudvista.nursingProj.controller;

import com.kloudvista.nursingProj.domain.Address;
import com.kloudvista.nursingProj.domain.Nurse;
import com.kloudvista.nursingProj.dto.NurseReq;
import com.kloudvista.nursingProj.dto.NurseResp;
import com.kloudvista.nursingProj.repository.AddressRepository;
import com.kloudvista.nursingProj.repository.NurseRepository;
import com.kloudvista.nursingProj.service.NurseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/nurse")
public class NurseController {

@Autowired
private NurseServiceImpl nurseServiceImpl;

   // CRUD
    // @RequestBody - post
    //

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<NurseResp> saveNurse(@RequestBody NurseReq nurseReq){
        NurseResp nurseResp = nurseServiceImpl.saveNurse(nurseReq);
        return  new ResponseEntity<>(nurseResp, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public ResponseEntity<NurseResp> getNurses(){
        NurseResp nurseResp = nurseServiceImpl.getNurses();
        return  new ResponseEntity<>(nurseResp, HttpStatus.OK);
    }

    @RequestMapping(value = "/get-by-id/{id}", method = RequestMethod.GET)
    public ResponseEntity<NurseResp> getNurseById(@PathVariable long id){
        NurseResp nurseResp = nurseServiceImpl.getNurseById(id);
        return  new ResponseEntity<>(nurseResp, HttpStatus.OK);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<NurseResp> getNurseById(@RequestBody NurseReq req, @PathVariable int id){
        NurseResp nurseResp = nurseServiceImpl.updateNurse(req, id);
        return  new ResponseEntity<>(nurseResp, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<NurseResp> delNurseById(@PathVariable int id){
        NurseResp nurseResp = nurseServiceImpl.deleteNurse(id);
        return  new ResponseEntity<>(nurseResp, HttpStatus.OK);
    }

}
