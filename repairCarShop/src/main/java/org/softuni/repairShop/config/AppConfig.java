package org.softuni.repairShop.config;


import org.springframework.context.annotation.Bean;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;


@Configuration
public class AppConfig {


    }



//    @Bean
//    public ModelMapper modelMapper(PasswordEncoder passwordEncoder) {
//        final ModelMapper modelMapper = new ModelMapper();
//
////        Converter<Set<CategoryNames>, Set<Category>> toEntitySet
////                = ctx -> (ctx.getSource() == null)
////                ? null
////                : categoryService.getAllByNameIn(ctx.getSource());
//
//        Converter<String, String> encode11
//                = ctx -> (ctx.getSource() == null)
//                ? null
//                : passwordEncoder().encode(ctx.getSource());
//
//        Converter<String, String> passwordConverter
//                = ctx -> (ctx.getSource() == null)
//                ? null
//                : passwordEncoder().encode(ctx.getSource());
//
//        Provider<Client> newClientProvider = req -> new Client();
//
//        Converter<ClientRegisterDTO, Client> encode1 =
//                ctx -> ctx.getSource().getPassword() == null
//                        ? null
//                        : new Client().setPassword(passwordEncoder.encode(ctx.getSource().getPassword()));
//
////        Converter<String, String> encode3 = new AbstractConverter<String, String>() {
////            protected String convert(String source) {
////                return source == null ? null : passwordEncoder.encode(source);
////            }
////        };
//
//        modelMapper.createTypeMap(ClientRegisterDTO.class, Client.class)
//                .setProvider(newClientProvider)
//                .addMappings(mapping -> mapping
//                        .using(encode11)
//                        .map(ClientRegisterDTO::getPassword, Client::setPassword));
//
//
//        //  modelMapper.addConverter(encode3);
//
////
////
//
//
//        return modelMapper;
//    }