package com.kloudvista.nursingProj.controller;

import com.kloudvista.nursingProj.domain.BioDetail;
import com.kloudvista.nursingProj.dto.NurseReq;
import com.kloudvista.nursingProj.dto.NurseResp;
import com.kloudvista.nursingProj.repository.BioDetailRepository;
import com.kloudvista.nursingProj.service.NurseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/biodetail")
public class BioDetailController {

    @Autowired
    private BioDetailRepository bioDetailRepository;

    // CRUD
    // @RequestBody - post
    //

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<BioDetail> saveBioDetails(@RequestBody BioDetail detail){
       BioDetail biodetail = bioDetailRepository.save(detail);
        return  new ResponseEntity<>(biodetail, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/get-all", method = RequestMethod.GET)
    public ResponseEntity<List<BioDetail>> getBiodetail(){
        List<BioDetail> all = bioDetailRepository.findAll();
        return  new ResponseEntity<>(all, HttpStatus.OK);
    }
}
