# INSERT INTO `clients` (`address`, `email`, `full_name`, `password`, `phone_number`, `role`, `username`)
# VALUES ('Client Address', 'client_test@test.test', 'Client Testov',
#         '7703e410bb469748013005dc0a5c29c5a840761613a758827a5ea0a84cbdbe80160021866f4cfaadd807c9a9c502b2f3',
#         '089880890808', 'CLIENT', 'client'),
#        ('Client Address', 'client1_test@test.test', 'Client Testov 1',
#         '1a058fb73565a9a7415d5c735bdb8cb75e8d7ebfa360d10368d9ce7aeadd35b65487962060a8e23e51d95d08b0f0408a',
#         '089880890808', 'CLIENT', 'client1'),
#        ('Client Address2', 'client2_test@test.test', 'Client Testov 2',
#         '5502c473a1275e334613b95a36fd2fe6f3b038b5338a3fcc6edb021e8a4f862dcc933623d0249f751d2503031958d811',
#         '089880890808', 'CLIENT', 'client2'),
#        ('Client Address3', 'client3_test@test.test', 'Client Testov3',
#         '1e93c01ffcfa56d1d3bc6a06e372c8da66567d2d2a0c3224d498a6fb233ca5133d5287b4c250b2edd3a347d3ebd33531',
#         '089880890808', 'CLIENT', 'client3');


INSERT INTO vehicle (`brand`, `category`, `color`, `engine`, `model`, `year`, `owner_id`,`deleted`)
VALUES ('Toyota', 'SUV', 'silver', 'PETROL', 'RAV', 2010, 1, false),
       ('Opel', 'COMBI', 'white', 'DIESEL', 'Corsa', 2003, 1, false),
       ('Toyota', 'CAR', 'red', 'HYBRID', 'Corrola', 2020, 1, false),
       ('Tesla', 'SUV', 'yellow', 'ELECTRIC', 'X', 2021, 2, false),
       ('Opel', 'TRUCK', 'green', 'DIESEL', 'NAVARA', 2003, 3, false),
       ('VW', 'COMBI', 'pink', 'DIESEL', 'Polo', 2003, 3, false),
       ('Subaru', 'CAR', 'black', 'PETROL', 'Impreza', 2000, 4, false);

INSERT INTO `tasks` (`approved`, `completed`, `created`, `repair_category`, `owner_id`, `vehicle_id`)
VALUES (b'0', b'0', '2023-11-30 19:54:29.762704', 'TIRES', 1, 1),
       (b'0', b'0', '2023-11-30 19:54:29.793954', 'ENGINE', 1, 1),
       (b'0', b'0', '2023-11-30 19:54:29.778328', 'SUSPENSION', 1, 1),
       (b'0', b'0', '2023-11-30 19:54:29.793954', 'BODY', 1, 1),
       (b'0', b'0', '2023-11-30 19:54:29.762704', 'SUSPENSION', 2, 4),
       (b'0', b'0', '2023-12-01 17:08:48.351466', 'TIRES', 3, 6),
       (b'0', b'0', '2023-12-01 17:08:48.411503', 'ENGINE', 3, 6),
       (b'0', b'0', '2023-12-01 17:08:48.423510', 'BODY', 3, 6),
       (b'0', b'0', '2023-12-01 17:09:51.775872', 'TIRES', 4, 7),
       (b'0', b'0', '2023-12-01 17:09:51.791486', 'SUSPENSION', 4, 7),
       (b'0', b'0', '2023-12-01 17:09:51.807107', 'ENGINE', 4, 7);
