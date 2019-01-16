package com.hly.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:common.properties")
public class CommonProperties {
    
	@Value("${attachment.upload}")
    public String upload;
	 @Value("${attachment.download}")
    public String download;
	
}
