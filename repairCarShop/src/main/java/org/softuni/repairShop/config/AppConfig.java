package org.softuni.repairShop.config;


import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.softuni.repairShop.model.dto.ClientRegisterDTO;
import org.softuni.repairShop.model.dto.UserRegisterDTO;
import org.softuni.repairShop.model.entity.Client;
import org.softuni.repairShop.model.entity.Role;
import org.softuni.repairShop.model.entity.User;
import org.softuni.repairShop.model.enums.RoleEnum;
import org.softuni.repairShop.repository.UserRoleRepository;
import org.springframework.context.annotation.Bean;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Set;


@Configuration
public class AppConfig {
    private final UserRoleRepository userRoleRepository;

    public AppConfig(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Bean
    public ModelMapper modelMapper(PasswordEncoder passwordEncoder) {
        final ModelMapper modelMapper = new ModelMapper();

        Converter<String, String> passwordConverter
                = ctx -> (ctx.getSource() == null)
                ? null
                : passwordEncoder.encode(ctx.getSource());

        Converter<List<RoleEnum>, List<Role>> toEntitySet
                = ctx -> (ctx.getSource() == null)
                ? null
                : userRoleRepository.getAllByuserRoleIn(ctx.getSource());


//        Provider<Client> clientProvider = req -> new Client()
//                .setRole(new Role().setUserRole(RoleEnum.CLIENT));


        modelMapper.createTypeMap(ClientRegisterDTO.class, Client.class)
         //       .setProvider(clientProvider)
                .addMappings(mapping -> mapping
                        .using(passwordConverter)
                        .map(ClientRegisterDTO::getPassword, Client::setPassword));

        modelMapper.createTypeMap(UserRegisterDTO.class, User.class)
                .addMappings(mapping -> mapping
                        .using(toEntitySet)
                        .map(UserRegisterDTO::getUserRole, User::setRoles))
                .addMappings(mapping -> mapping
                        .using(passwordConverter)
                        .map(UserRegisterDTO::getPassword, User::setPassword));


        return modelMapper;
    }
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