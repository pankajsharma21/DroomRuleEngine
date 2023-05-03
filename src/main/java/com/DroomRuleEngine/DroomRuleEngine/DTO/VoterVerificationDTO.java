package com.DroomRuleEngine.DroomRuleEngine.DTO;

public class VoterVerificationDTO {
    private String name;
    private int age;
    private boolean eligibleToVote;

    public VoterVerificationDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isEligibleToVote() {
        return eligibleToVote;
    }

    public void setEligibleToVote(boolean eligibleToVote) {
        this.eligibleToVote = eligibleToVote;
    }
}
