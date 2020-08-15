package com.sample;

import com.sample.beans.*;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class AppConfig {

    @Bean
    public Player player1() {
        return new Player();
    }

    @Bean
    public Barcelona barcelona() {
        return new Barcelona();
    }

    @Bean
    public Juventus juventus() {
        return new Juventus();
    }

    @Bean
    public Shirt shirt() {
        return new Shirt();
    }

    @Bean
    public Mark mark() {
        return new Mark();
    }
}
