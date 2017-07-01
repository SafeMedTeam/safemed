package com.bafal.dev.patient.web.configuration;

/*@SpringBootApplication(exclude = { EmbeddedServletContainerAutoConfiguration.class }, scanBasePackages = { "com.bafal.dev.patient.web" })
@Import(MvcConfig.class)
@PropertySource("classpath:applicationWeb.properties")*/
public class SafeMedInitializerDev {

	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder application) { return
	 * application.sources(SafeMedModeleApplication.class).sources(
	 * SafeMedInitializerDev.class); }
	 * 
	 * public static void main(String[] args) throws Exception { new
	 * SpringApplicationBuilder().sources(SafeMedModeleApplication.class).
	 * sources(SafeMedInitializerDev.class) .run(args);
	 * 
	 * }
	 */

    /*
     * @Bean public EmbeddedServletContainerFactory servletContainer() {
     * TomcatEmbeddedServletContainerFactory factory = new
     * TomcatEmbeddedServletContainerFactory(); factory.setPort(8080);
     * factory.setSessionTimeout(10, TimeUnit.MINUTES); //factory.addErrorPages(new
     * ErrorPage(HttpStatus.404, "/notfound.html")); return factory; }
     */

    /*
     * @Bean public EmbeddedServletContainerCustomizer containerCustomizer() { return new
     * ErreurCustomizer(); }
     * 
     * private static class ErreurCustomizer implements EmbeddedServletContainerCustomizer
     * {
     * 
     * @Override public void customize(ConfigurableEmbeddedServletContainer container) {
     * container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/erreur"));
     * container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,
     * "/erreur")); }
     * 
     * }
     */

    /*
     * @Override public void onStartup(ServletContext servletContext) throws
     * ServletException { AnnotationConfigWebApplicationContext rootContext = new
     * AnnotationConfigWebApplicationContext();
     * rootContext.register(ApplicationContext.class); rootContext.setDisplayName("Test");
     * 
     * servletContext.addListener(new ContextLoaderListener(rootContext));
     * 
     * ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",
     * new DispatcherServlet(rootContext)); dispatcher.setLoadOnStartup(1);
     * dispatcher.addMapping("/");
     * 
     * FilterRegistration.Dynamic filter =
     * servletContext.addFilter("openEntityManagerInViewFilter",
     * OpenEntityManagerInViewFilter.class); filter.setInitParameter("singleSession",
     * "true"); filter.addMappingForServletNames(null, true, "dispatcher"); }
     */

}
