package com.kloudvista.nursingProj.service;

import com.kloudvista.nursingProj.domain.BioDetail;
import com.kloudvista.nursingProj.domain.Nurse;
import com.kloudvista.nursingProj.dto.Biodata;
import com.kloudvista.nursingProj.dto.NurseReq;
import com.kloudvista.nursingProj.dto.NurseResp;
import com.kloudvista.nursingProj.repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NurseServiceImpl implements NurseService{
    @Autowired
    private final NurseRepository repository;

    public NurseServiceImpl(NurseRepository repository) {
        this.repository = repository;
    }

    @Override
    public NurseResp saveNurse(NurseReq req) {
        Nurse nurse = new Nurse();
        nurse.setFirstName(req.getFirstName());
        nurse.setEmail(req.getEmail());
        nurse.setPhoneNumber(req.getPhoneNumber());
        nurse.setLastName(req.getLastName());
        nurse.setStatus(true);

        Nurse save = repository.save(nurse);
        return new NurseResp("Saved successfully", save);
    }

    @Override
    public NurseResp saveNurses(List<NurseReq> req) {
        List<Nurse> nurseList = new ArrayList<>();
        req.forEach(n -> {
            Nurse nurse = new Nurse();
            nurse.setFirstName(n.getFirstName());
            nurse.setEmail(n.getEmail());
            nurse.setPhoneNumber(n.getPhoneNumber());
            nurse.setLastName(n.getLastName());
            nurse.setStatus(true);
           // nurse.setBioDetails(new BioDetail(0, n.getBiodata().getDateOfBirth(), n.getBiodata().getHeight(),  n.getBiodata().getWeight()));
            nurse.setBioDetail(bioDataToBioDetail(n.getBiodata()));
            nurseList.add(nurse);
        });


        List<Nurse> saved = repository.saveAll(nurseList);
        return new NurseResp("Saved successfully", saved);
    }

    @Override
    public NurseResp getNurseById(long id) {
        Optional<Nurse> byId = repository.findById(id);
        if(!byId.isPresent()) return  new NurseResp("No record available for the id", null);
        Nurse nurse = byId.get();
        return new NurseResp("successful", nurse);
    }


    @Override
    public NurseResp getNurses() {
        List<Nurse> nurseList = repository.findAll();
        return new NurseResp("successful", nurseList);
    }

    @Override
    public NurseResp deleteNurse(long id) {
        try {
            repository.deleteById(id);
        }catch (Exception ex){
            return new NurseResp("Error deleting record", null);
        }
        return new NurseResp("Successful", null);
    }

    @Override
    public NurseResp updateNurse(NurseReq nurseReq, long id) {
        Nurse nurse = new Nurse();
        try {
            nurse.setFirstName(nurseReq.getFirstName());
            nurse.setEmail(nurseReq.getEmail());
            nurse.setPhoneNumber(nurseReq.getPhoneNumber());
            nurse.setLastName(nurseReq.getLastName());
            nurse.setId(id);
            Nurse save = repository.save(nurse);
            return new NurseResp("successful", save);
        }catch (Exception exception){
            return new NurseResp("failed", null);
        }
    }

    @Override
    public NurseResp getByEmail(String emailAddress) {
        Nurse byEmail = repository.findByEmail(emailAddress);
        return new NurseResp("successful", byEmail);
    }

    private BioDetail bioDataToBioDetail(Biodata biodata){
        BioDetail bioDetail = new BioDetail();
        bioDetail.setDateOfBirth(biodata.getDateOfBirth()) ;
        bioDetail.setHeight(biodata.getHeight());
        bioDetail.setWeight(biodata.getWeight());
        return bioDetail;
    }

}
