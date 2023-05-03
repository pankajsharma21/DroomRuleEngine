package com.DroomRuleEngine.DroomRuleEngine.Config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.io.Resource;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfig {

    private static final String RULES_CUSTOMER_RULES_DRL = "Rules/VotingRights.drl";
    private static final KieServices kieServices = KieServices.Factory.get();

    @Bean
    public KieContainer kieContainer() {
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource(RULES_CUSTOMER_RULES_DRL));
        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();
        KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());
        return kieContainer;
    }

//    @Bean
//    public KieContainer kieContainer() {
//        KieServices kieServices = KieServices.Factory.get();
//        KieFileSystem kfs = kieServices.newKieFileSystem();
//        Resource resource = kieServices.getResources().newClassPathResource("Rules/voter-verification-rules.xls");
//        kfs.write(resource);
//        KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
//        KieRepository kieRepository = kieServices.getRepository();
//        KieModule kieModule = kieRepository.getKieModule(kieBuilder.getKieModule().getReleaseId());
//        return kieServices.newKieContainer(kieModule.getReleaseId());
//    }
}