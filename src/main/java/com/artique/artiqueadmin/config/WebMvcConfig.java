package com.artique.artiqueadmin.config;

import com.artique.artiqueadmin.converter.ReportTypeConverter;
import com.artique.artiqueadmin.entity.ReportType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {
  private final ReportTypeConverter reportTypeConverter;
  @Override
  public void addFormatters(FormatterRegistry registry) {
    registry.addConverter(reportTypeConverter);
  }
}
