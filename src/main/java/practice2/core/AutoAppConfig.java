package practice2.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 지정하지 않을 경우 AutoAppConfig(현재 이 클래스)가 있는 디렉토리로 설정이 됨
        basePackages = "practice2.core",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
