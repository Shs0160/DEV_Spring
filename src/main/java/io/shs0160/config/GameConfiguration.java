package io.shs0160.config;

import io.shs0160.app.Chief;
import io.shs0160.app.JapaneseCuisineAbility;
import io.shs0160.app.KoreanCuisineAbility;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "io.shs0160.app", "io.shs0160.repository" })
public class GameConfiguration {
}