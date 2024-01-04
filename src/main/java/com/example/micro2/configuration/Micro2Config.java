package com.example.micro2.configuration;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.propagation.TextMapSetter;
//import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Micro2Config {
//    @Bean
//    public OpenTelemetry openTelemetry() {
//        OtlpGrpcSpanExporter spanExporter = OtlpGrpcSpanExporter.builder()
//                .setEndpoint("http://localhost:9411") // Endpoint for the OTLP collector
//                .build();
//
//        SdkTracerProvider sdkTracerProvider = SdkTracerProvider.builder()
//                .addSpanProcessor(BatchSpanProcessor.builder(spanExporter).build())
//                .build();
//
//        return OpenTelemetrySdk.builder()
//                .setTracerProvider(sdkTracerProvider)
//                .buildAndRegisterGlobal();
//    }
    @Bean
    public RestTemplate restTemplate()
    {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.getInterceptors().add((request, body, execution) -> {
            GlobalOpenTelemetry.getPropagators().getTextMapPropagator().inject(Context.current(), request.getHeaders(),
                    (TextMapSetter<HttpHeaders>) HttpHeaders::set);
            return execution.execute(request, body);
        });

        return restTemplate;
    }
}