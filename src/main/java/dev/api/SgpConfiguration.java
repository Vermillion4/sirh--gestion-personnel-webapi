package dev.api;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import dev.api.configuration.AccessConfiguration;

@Import(AccessConfiguration.class)
@Configuration
public class SgpConfiguration {

	@Autowired
	EntityManagerFactory em;
}
