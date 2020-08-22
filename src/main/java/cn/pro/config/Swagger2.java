package cn.pro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan(basePackages = "cn.pro.controller")
@EnableSwagger2
@Configuration
public class Swagger2 {
    @Bean
    Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.pro.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(new ApiInfoBuilder().description("线下教育接口测试文档").contact(new Contact("冯世昊","https://LitterBitchFeng.github.io","1843924240@qq.com")).version("v1.0").title("API测试文档").license("Apache2.0").licenseUrl("http://www.apache.orrg/licenses/LICESENS-@.0").build());
    }
}
