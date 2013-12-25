package eu.haslgruebler.core.webapp;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import eu.haslgruebler.core.data.MongoConfiguration;

/**
 * Spring Configuration for Application
 * 
 * @author Michael Haslgrübler
 * 
 */
@Configuration
@Import(MongoConfiguration.class)
public class AppConfig {

}
