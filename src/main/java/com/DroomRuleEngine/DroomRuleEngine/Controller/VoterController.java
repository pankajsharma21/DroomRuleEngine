package com.DroomRuleEngine.DroomRuleEngine.Controller;

import com.DroomRuleEngine.DroomRuleEngine.DTO.VoterVerificationDTO;
import com.DroomRuleEngine.DroomRuleEngine.Service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoterController {
    @Autowired
    private VoterService voterService;

    @PostMapping("/getverfiy")
    public ResponseEntity<VoterVerificationDTO> getDiscount(@RequestBody VoterVerificationDTO verifcationDTO) {
        VoterVerificationDTO voter = voterService.getVerfication(verifcationDTO);
        return new ResponseEntity<>(voter, HttpStatus.OK);
    }
}
