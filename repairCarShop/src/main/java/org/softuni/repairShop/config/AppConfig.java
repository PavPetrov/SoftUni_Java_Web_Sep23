package org.softuni.repairShop.config;


import jakarta.validation.constraints.NotNull;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.Provider;
import org.softuni.repairShop.model.dto.*;
import org.softuni.repairShop.model.entity.*;
import org.softuni.repairShop.model.enums.RoleEnum;
import org.softuni.repairShop.repository.ClientRepository;
import org.softuni.repairShop.repository.UserRoleRepository;
import org.springframework.context.annotation.Bean;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;


@Configuration
public class AppConfig {
    private final UserRoleRepository userRoleRepository;

    private final ClientRepository clientRepository;





    public AppConfig(UserRoleRepository userRoleRepository, ClientRepository clientRepository) {
        this.userRoleRepository = userRoleRepository;
        this.clientRepository = clientRepository;
    }

    @Bean
    public ModelMapper modelMapper(PasswordEncoder passwordEncoder) {
        final ModelMapper modelMapper = new ModelMapper();

        Converter<String, String> passwordConverter
                = ctx -> (ctx.getSource() == null)
                ? null
                : passwordEncoder.encode(ctx.getSource());

        Converter<List<RoleEnum>, List<Role>> roleEnumToRole
                = ctx -> (ctx.getSource() == null)
                ? null
                : userRoleRepository.getAllByuserRoleIn(ctx.getSource());

        Converter<List<Role>, List<RoleEnum>> roleTORoleEnum
                = ctx -> (ctx.getSource() == null)
                ? null
                : ctx.getSource().stream().map(Role::getUserRole).toList();


        Converter<String, Client> toClient
                = ctx -> (ctx.getSource() == null)
                ? null
                : clientRepository.getByUsername(ctx.getSource());

//        Provider<Client> clientProvider = req -> new Client()
//                .setRole(new Role().setUserRole(RoleEnum.CLIENT));


        modelMapper.createTypeMap(ClientRegisterDTO.class, Client.class)
         //       .setProvider(clientProvider)
                .addMappings(mapping -> mapping
                        .using(passwordConverter)
                        .map(ClientRegisterDTO::getPassword, Client::setPassword));



        modelMapper.createTypeMap(User.class, UserEditDTO.class)
                //       .setProvider(clientProvider)
                .addMappings(mapping -> mapping
                        .using(roleTORoleEnum)
                        .map(User::getRoles, UserEditDTO::setUserRoles));


//        modelMapper.createTypeMap(Task.class, TaskDTO.class )
//                        .addMappings(mapping -> mapping
//                                .map(Task::getCompleteByUsername, TaskDTO::setUserName));

        modelMapper.createTypeMap(UserRegisterDTO.class, User.class)
                .addMappings(mapping -> mapping
                        .using(roleEnumToRole)
                        .map(UserRegisterDTO::getUserRole, User::setRoles))
                .addMappings(mapping -> mapping
                        .using(passwordConverter)
                        .map(UserRegisterDTO::getPassword, User::setPassword));


        modelMapper.createTypeMap(VehicleDTO.class, Vehicle.class)
                .addMappings(mapping -> mapping
                        .using(toClient)
                        .map(VehicleDTO::getOwner, Vehicle::setOwner));

        modelMapper.createTypeMap(UserEditDTO.class, User.class)
                //Skip mappings
                .addMappings(mapping -> mapping
                        .skip(UserEditDTO::getFullName, User::setFullName))
                .addMappings(mapping -> mapping
                    .skip(UserEditDTO::getEmail, User::setEmail))
                .addMappings(mapping -> mapping
                        .skip(UserEditDTO::getActive, User::setActive))
                .addMappings(mapping -> mapping
                        .using(roleEnumToRole)
                        .map(UserEditDTO::getUserRoles, User::setRoles));



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