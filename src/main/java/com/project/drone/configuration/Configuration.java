package com.project.drone.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("drone")
@EnableScheduling
public class Configuration {

}
