package com.rails.nmi.front;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.rails.nmi.front.module.config.DeviceConfig;

@SpringBootApplication
@EnableConfigurationProperties({ DeviceConfig.class })
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
