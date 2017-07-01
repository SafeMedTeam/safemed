package com.bafal.dev.patient.web.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.bafal.dev.patient.web.configuration.intercepteur.DmeAuthIntercepteur;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{

	@Autowired
	private DmeAuthIntercepteur dmeIntercepteur;
	@Override
	public void addArgumentResolvers(
			List<HandlerMethodArgumentResolver> argumentResolvers) {
		PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
		resolver.setFallbackPageable(new PageRequest(1, 5));
		argumentResolvers.add(resolver);

	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		// TODO Mettre ICI le formatage pour les numeriques et les dates et
		// utiliser les double brace "${{...}}"
		super.addFormatters(registry);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(dmeIntercepteur).addPathPatterns("/", "/accueil").excludePathPatterns("/login",
				"/reset/**");
	}
}
