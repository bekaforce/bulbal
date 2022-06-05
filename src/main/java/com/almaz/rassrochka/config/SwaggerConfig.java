package com.almaz.rassrochka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.almaz.rassrochka.controller"))
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
                //.apiInfo(metaData())
                //.securitySchemes(Lists.newArrayList(apiKey()))
                //.securityContexts(Collections.singletonList(securityContext()));
    }

//    private ApiKey apiKey() {
//        return new ApiKey(
//                "Authorization", // name: My key - Authorization
//                "api_key", // keyname: api_key
//                "header");
//    }

//    private SecurityContext securityContext() {
//        return SecurityContext.builder().securityReferences(defaultAuth())
//                .forPaths(PathSelectors.any()).build();
//    }

//    private List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope = new AuthorizationScope(
//                "global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return Collections.singletonList(new SecurityReference("apiKey",
//                authorizationScopes));
//    }

//    @Override
//    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html").addResourceLocations(
//                "classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**").addResourceLocations(
//                "classpath:/META-INF/resources/webjars/");
//    }

//    @Bean
//    SecurityConfiguration security() {
//        return new SecurityConfiguration(
//                null, null, null,
//                "Docserver2_fwk", // app name
//                "Bearer", // api key value
//                ApiKeyVehicle.HEADER, "Authorization", ",");
//    }

//    private ApiInfo metaData() {
//        return new ApiInfo(
//                "SMS Survey REST API",
//                "REST API to handle rassrochka",
//                "1.0",
//                "Free to use",
//                new Contact("Almaz", "http://rassrochka", "almazv@rassrochka.com"),
//                "API Lisence",
//                "https://www.apache.org/licenses/LICENSE-2.0",
//                Collections.EMPTY_LIST);
//    }




//}
