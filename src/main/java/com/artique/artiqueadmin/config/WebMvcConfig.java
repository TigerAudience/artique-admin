package com.artique.artiqueadmin.config;

import com.artique.artiqueadmin.converter.ReportTypeConverter;
import com.artique.artiqueadmin.entity.ReportType;
import com.artique.artiqueadmin.interceptor.AuthorizationInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {
  private final ReportTypeConverter reportTypeConverter;
  private final AuthorizationInterceptor authorizationInterceptor;
  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverter(reportTypeConverter);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(authorizationInterceptor)
            .excludePathPatterns("/css/**", "/images/**", "/js/**","/favicon.ico","/webjars/**","/error/**",
                    "/swagger-ui/**","/swagger-resources/**","/v3/api-docs/**","META-INF/**",
                    "/login");
  }
}
