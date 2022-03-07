package az.coders.grouppersonal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    @Bean
    public Docket swaggerSettings() {
        return new Docket(DocumentationType.SWAGGER_2)
                .consumes(Stream.of(MediaType.APPLICATION_JSON_VALUE,
                                MediaType.APPLICATION_PDF_VALUE,
                                MediaType.APPLICATION_XML_VALUE,
                                MediaType.APPLICATION_CBOR_VALUE,
                                MediaType.APPLICATION_XHTML_XML_VALUE)
                        .collect(Collectors.toSet()))
                .produces(Stream.of(MediaType.APPLICATION_JSON_VALUE,
                                MediaType.APPLICATION_PDF_VALUE,
                                MediaType.APPLICATION_XML_VALUE,
                                MediaType.APPLICATION_CBOR_VALUE,
                                MediaType.APPLICATION_XHTML_XML_VALUE)
                        .collect(Collectors.toSet()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("az.coders.grouppersonal"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo())
                .securitySchemes(Collections.singletonList(apiKey()));
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/api/swagger-ui.html**")
                .addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
        registry.addResourceHandler("/api/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Scraper Microservice", "Scraper Microservice for scrap data from web", "API", "Terms of service",
                new Contact("Khayal Farziyev", "https://www.facebook.com/profile.php?id=100012272370580", "khayalfarzi@gmail.com"), "License of API", "API license URL",
                Collections.emptyList());
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }
}