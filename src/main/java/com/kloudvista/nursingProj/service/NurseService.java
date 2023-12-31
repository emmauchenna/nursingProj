package com.kloudvista.nursingProj.service;

import com.kloudvista.nursingProj.dto.NurseReq;
import com.kloudvista.nursingProj.dto.NurseResp;

import java.util.List;


public interface NurseService {
    NurseResp saveNurse(NurseReq req);
    NurseResp saveNurses(List<NurseReq> req);
    NurseResp getNurseById(long id);
    NurseResp getNurses();
    NurseResp deleteNurse(long id);
    NurseResp updateNurse(NurseReq nurseReq, long id);
    NurseResp getByEmail(String emailAddress);
}
