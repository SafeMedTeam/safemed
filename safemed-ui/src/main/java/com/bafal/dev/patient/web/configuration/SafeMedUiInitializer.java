package com.bafal.dev.patient.web.configuration;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;

import com.bafal.dev.patient.modele.SafeMedModeleApplication;

@SpringBootApplication(scanBasePackages = { "com.bafal.dev.patient.web", "it.ozimov.springboot" })
@Import(MvcConfig.class)
@PropertySource("classpath:safeMedUI.properties")
public class SafeMedUiInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SafeMedModeleApplication.class).sources(SafeMedUiInitializer.class);
    }

    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder().sources(SafeMedModeleApplication.class).sources(SafeMedUiInitializer.class)
            .run(args);

    }

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new ErreurCustomizer();
	}

	private static class ErreurCustomizer implements EmbeddedServletContainerCustomizer {

		@Override
		public void customize(ConfigurableEmbeddedServletContainer container) {
			container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/error"));
			container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error"));
			container.addErrorPages(new ErrorPage(HttpStatus.UNAUTHORIZED, "/error"));
			container.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/error"));
			container.addErrorPages(new ErrorPage(HttpStatus.METHOD_NOT_ALLOWED, "/error"));
			container.addErrorPages(new ErrorPage(HttpStatus.REQUEST_TIMEOUT, "/error"));
			container.addErrorPages(new ErrorPage(HttpStatus.BAD_GATEWAY, "/error"));
		}

	}


}
