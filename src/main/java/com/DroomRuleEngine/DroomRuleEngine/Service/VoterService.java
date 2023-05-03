package com.DroomRuleEngine.DroomRuleEngine.Service;


import com.DroomRuleEngine.DroomRuleEngine.DTO.VoterVerificationDTO;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoterService {

    @Autowired
    private KieContainer kieContainer;

    public VoterVerificationDTO getVerfication(VoterVerificationDTO voter) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("voter", voter);
        kieSession.insert(voter);
        kieSession.fireAllRules();
        kieSession.dispose();
        return voter;
    }

//    public VoterVerificationDTO getVerfication(VoterVerificationDTO voterVerificationDTO) {
//        KieSession kieSession = kieContainer.newKieSession();
//        kieSession.insert(voterVerificationDTO);
//        kieSession.fireAllRules();
//        kieSession.dispose();
//        return voterVerificationDTO;
//    }

}

