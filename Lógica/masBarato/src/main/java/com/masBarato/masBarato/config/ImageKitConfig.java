package com.masBarato.masBarato.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import io.imagekit.sdk.ImageKit;

@Configuration
public class ImageKitConfig {

    @Value("${imagekit.public-key}")
    private String publicKey;

    @Value("${imagekit.private-key}")
    private String privateKey;

    @Value("${imagekit.url-endpoint}")
    private String urlEndpoint;

    @Bean
    public ImageKit imageKitClient() {
        ImageKit imageKit = ImageKit.getInstance();
        io.imagekit.sdk.config.Configuration config =
                new io.imagekit.sdk.config.Configuration(publicKey, privateKey, urlEndpoint);
        imageKit.setConfig(config);
        return imageKit;
    }
}
