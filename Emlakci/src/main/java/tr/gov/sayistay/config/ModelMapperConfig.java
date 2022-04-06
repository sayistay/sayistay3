package tr.gov.sayistay.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
	@Bean
	public ModelMapper getModelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setFullTypeMatchingRequired(true);
		mapper.getConfiguration().setFieldMatchingEnabled(true);
		return mapper;
	}
}
