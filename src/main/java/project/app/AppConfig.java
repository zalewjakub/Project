package project.app;

import java.util.Locale;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import project.converter.AdminConverter;
import project.converter.BuildingConverter;
import project.converter.FlatConverter;
import project.converter.HomeovnerConverter;
import project.converter.NotesConverter;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "project")
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "project.repository")
public class AppConfig extends WebMvcConfigurerAdapter{
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(getHomeovnerConverter());
		registry.addConverter(getBuildingConverter());
		registry.addConverter(getFlatConverter());
		registry.addConverter(getNotesConverter());
		registry.addConverter(getAdminConverter());
	}

	@Bean
	public NotesConverter getNotesConverter() {
		return new NotesConverter();
	}

	@Bean
	public FlatConverter getFlatConverter() {
		return new FlatConverter();
	}
	@Bean
	public BuildingConverter getBuildingConverter() {
		return new BuildingConverter();
	}

	@Bean
	public HomeovnerConverter getHomeovnerConverter() {
		return new HomeovnerConverter();
	}
	
	@Bean
	public AdminConverter getAdminConverter() {
		return new AdminConverter();
	}
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
		emfb.setPersistenceUnitName("commonholdPersistenceUnit");
		return emfb;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager tm = new JpaTransactionManager(emf);
		return tm;
	}

	@Bean(name = "localeResolver")
	public LocaleContextResolver getLocaleContextResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("pl", "PL"));
		return localeResolver;
	}

	@Bean
	public Validator validator() {
		return new LocalValidatorFactoryBean();
	}
}
