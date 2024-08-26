package com.api.ecommerce.util;

import com.api.ecommerce.client.EnderecoClient;
import feign.Feign;
import feign.Retryer;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FeignUtil {

    public static EnderecoClient getEnderecoFeing(String url) {
        return Feign.builder()
                .client(new OkHttpClient())
                .retryer(new Retryer.Default())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .target(EnderecoClient.class, url);
    }
}