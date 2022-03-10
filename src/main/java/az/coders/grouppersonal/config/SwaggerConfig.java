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
                .apis(RequestHandlerSelectors.basePackage("az.coders.grouppersonal.controller"))
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
        return new ApiInfo("Group Personal Lessons",
                "Personal group lessons",
                "API",
                "https://www.google.com/url?sa=i&url=https%3A%2F%2Fhealthrecipe.xyz%2Fterms-of-use%2F&psig=AOvVaw27OksNGfrDuSBSO8RMu9cz&ust=1646929052607000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCPi86v22ufYCFQAAAAAdAAAAABAD",
                new Contact("Khayal Farziyev",
                        "https://github.com/khayalfarzi/group-personal-firstapp",
                        "khayalfarzi@gmail.com"),
                "License of API",
                "https://www.google.com/url?sa=i&url=https%3A%2F%2Fmarketplace.visualstudio.com%2Fitems%3FitemName%3Dbenemohamed.licence-snippets&psig=AOvVaw1Vlew3zjB2pWNwKL-3WZxp&ust=1646929117641000&source=images&cd=vfe&ved=0CAsQjRxqFwoTCNCzzJy3ufYCFQAAAAAdAAAAABAD",
                Collections.emptyList());
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }
}