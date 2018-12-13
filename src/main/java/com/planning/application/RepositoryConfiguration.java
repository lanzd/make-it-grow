package com.planning.application;

import com.planning.application.order.OrderEntityEventHandler;
import com.planning.application.vegetable.VegetableEntityEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Bean
    OrderEntityEventHandler orderEntityEventHandler() {
        return new OrderEntityEventHandler();
    }

    @Bean
    VegetableEntityEventHandler vegetableEntityEventHandler(){
        return new VegetableEntityEventHandler();
    }
}
