package io.shs0160.app;

import io.shs0160.repository.AbilityRepository;
import io.shs0160.repository.AbilityRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KoreanCuisineAbility extends AbstractCuisineAbility {

    private final AbilityRepository abilityRepository;

    public KoreanCuisineAbility(AbilityRepository abilityRepository) {
        this.abilityRepository = abilityRepository;
    }

    private void increaseExp() {
        int curExp = abilityRepository.getCurrentExp(getAbilityName());
        abilityRepository.applyExp(getAbilityName(), ++curExp);
    }

    public void apply(List<String> ingredients) {

        this.increaseExp();

        String usedIngredients = String.join(" ", ingredients);
        System.out.println(usedIngredients + "를 끓여서 한국 음식을 요리했습니다!");

    }

    public int getExp() {
        return abilityRepository.getCurrentExp(getAbilityName());
    }

}
