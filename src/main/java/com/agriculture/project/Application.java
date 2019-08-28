package com.agriculture.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Transformers;
import org.springframework.integration.ip.dsl.Tcp;
import org.springframework.integration.ip.tcp.serializer.AbstractByteArraySerializer;
import org.springframework.integration.ip.tcp.serializer.TcpCodecs;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Bean
    public IntegrationFlow server() {
        return IntegrationFlows.from(Tcp.inboundGateway(
                Tcp.netServer(1234)
                        .serializer(codec()) // default is CRLF
                        .deserializer(codec()))) // default is CRLF
                .transform(Transformers.objectToString()) // byte[] -> String
                .<String, String>transform(p -> p.concat("aaa"))
                .get();
    }

    @Bean
    public IntegrationFlow client() {
        return IntegrationFlows.from(MyGateway.class)
                .handle(Tcp.outboundGateway(
                        Tcp.netClient("localhost", 1234)
                                .serializer(codec()) // default is CRLF
                                .deserializer(codec()))) // default is CRLF
                .transform(Transformers.objectToString()) // byte[] -> String
                .get();
    }

    @Bean
    public AbstractByteArraySerializer codec() {
        return TcpCodecs.lf();
    }

    @Bean
    @DependsOn("client")
    ApplicationRunner runner1(MyGateway gateway) {
        return args -> {
            System.out.println(gateway.exchange("foo"));
            System.out.println(gateway.exchange("bar"));
        };
    }

    @Bean
    @DependsOn("client")
    ApplicationRunner runner2(MyGateway gateway) {
        return args -> {
            System.out.println(gateway.exchange("foo"));
            System.out.println(gateway.exchange("bar"));
        };
    }

    @Bean
    @DependsOn("client")
    ApplicationRunner runner3(MyGateway gateway) {
        return args -> {
            System.out.println(gateway.exchange("foo"));
            System.out.println(gateway.exchange("bar"));
        };
    }

    @Bean
    @DependsOn("client")
    ApplicationRunner runner4(MyGateway gateway) {
        return args -> {
            System.out.println(gateway.exchange("foo"));
            System.out.println(gateway.exchange("bar"));
        };
    }

    @Bean
    @DependsOn("client")
    ApplicationRunner runner5(MyGateway gateway) {
        return args -> {
            System.out.println(gateway.exchange("foo"));
            System.out.println(gateway.exchange("bar"));
        };
    }

    @Bean
    @DependsOn("client")
    ApplicationRunner runner6(MyGateway gateway) {
        return args -> {
            System.out.println(gateway.exchange("foo"));
            System.out.println(gateway.exchange("bar"));
        };
    }

    @Bean
    @DependsOn("client")
    ApplicationRunner runner7(MyGateway gateway) {
        return args -> {
            System.out.println("password is : " + passwordEncoder.encode("1234"));

            System.out.println(gateway.exchange("foo"));
            System.out.println(gateway.exchange("bar"));
        };
    }

    @Bean
    @DependsOn("client")
    ApplicationRunner runner8(MyGateway gateway) {
        return args -> {
            System.out.println(gateway.exchange("foo"));
            System.out.println(gateway.exchange("bar"));
        };
    }

    @Bean
    @DependsOn("client")
    ApplicationRunner runner9(MyGateway gateway) {
        return args -> {
            System.out.println(gateway.exchange("foo"));
            System.out.println(gateway.exchange("bar"));
        };
    }

    @Bean
    @DependsOn("client")
    ApplicationRunner runner10(MyGateway gateway) {
        return args -> {
            System.out.println(gateway.exchange("foo"));
            System.out.println(gateway.exchange("bar"));
        };
    }

    @Bean
    @DependsOn("client")
    ApplicationRunner runner11(MyGateway gateway) {
        return args -> {
            System.out.println(gateway.exchange("foo"));
            System.out.println(gateway.exchange("bar"));
        };
    }

    @Bean
    @DependsOn("client")
    ApplicationRunner runner12(MyGateway gateway) {
        return args -> {
            System.out.println(gateway.exchange("foo"));
            System.out.println(gateway.exchange("bar"));
        };
    }


    @Component
    public interface MyGateway {
        String exchange(String out);
    }

}
