package io.shs0160.repository;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AbilityRepository {

    private final Map<String, Integer> expStatus = new HashMap<>();

    public int getCurrentExp(String abilityName) {
        expStatus.putIfAbsent(abilityName, 0);
        return expStatus.get(abilityName);
    }

    public void applyExp(String abilityName, int exp) {
        expStatus.replace(abilityName, exp);
    }

}
