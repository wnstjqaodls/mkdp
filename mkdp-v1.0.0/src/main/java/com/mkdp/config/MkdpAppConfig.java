@Configuration
@ComponentScan(basePackages = {"com.mkdp.mkdpApp", "com.mkdp.service", "com.mkdp.mapper", "com.mkdp.vo"})
public class MkdpAppConfig {
    
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
