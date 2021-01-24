package br.com.victsoft.simples.config.docs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Import(SpringDataRestConfiguration.class)
public class ApiDocumentationConfig {
    @Bean
    public Docket api() {
        ApiInfo info = new ApiInfo("Aplicação simples", "Exemplo de aplicação simples.", ApiInfo.DEFAULT.getVersion(), ApiInfo.DEFAULT.getTermsOfServiceUrl(), ApiInfo.DEFAULT.getContact(), ApiInfo.DEFAULT.getLicense(), ApiInfo.DEFAULT.getLicenseUrl(), ApiInfo.DEFAULT.getVendorExtensions());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(info)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.victsoft.simples.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}
