# CAR REPAIR SHOP

Car Repair Shop is a simple web application that helps to organize work in a car service shop. The app can be used by autoservice administrators, autoservice workers and clients. This is my project for the Java Web course at SoftUni.
[https://repairshop.mangobush-4c8ab9c0.westeurope.azurecontainerapps.io/](https://repairshop.mangobush-4c8ab9c0.westeurope.azurecontainerapps.io/)

## Features & Usage
* ### Autoservice administrator
#### username:  admin / password: 12345

Service tab is showing after login as admin.
* Administrator can approve service tasks added by [client users](#autoservice-workers).

![admin-service](https://github.com/PavPetrov/SoftUni_Java_Web_Sep23/assets/102189350/c6e1be86-583b-4cb7-955b-7202a6e6fc70)

* Administrator can activate and  edit autoservice [workers](#autoservice-workers) in which division(s) are occupied
![admin-users](https://github.com/PavPetrov/SoftUni_Java_Web_Sep23/assets/102189350/5ddd62ff-ffac-44e8-ac89-a1c70ba4118c)

* Administrator can change Full name, e-mail and username on seting section.
New users can register at [https://repairshop.mangobush-4c8ab9c0.westeurope.azurecontainerapps.io/users/register](https://repairshop.mangobush-4c8ab9c0.westeurope.azurecontainerapps.io/users/register).
New users are not active until admin approve and activate at users tab.

##
* ### Autoservice workers
#### username:  gumcho / password: 12345     ---> division -> tires
#### username:  bai-ivan / password: 12345   ---> divisions -> engine, suspension
#### username:  drago / password: 12345      ---> divisions -> tires, suspension
#### username:  shkurka / password: 12345    ---> divisions -> body

When logging in, users will see only the tasks of their division(s).
Users can complete tasks.
Users can change full name, e-mail and username on the settings tab.

##
* ### Autoservice clients
#### username:  client1 / password: 12345    
#### username:  client2 / password: 12345 

New clients can register at [https://repairshop.mangobush-4c8ab9c0.westeurope.azurecontainerapps.io/clients/register](https://repairshop.mangobush-4c8ab9c0.westeurope.azurecontainerapps.io/clients/register)

* ADD TASK  
Clients can add task by clicking on devision link or ADD TASK link.
![add-task](https://github.com/PavPetrov/SoftUni_Java_Web_Sep23/assets/102189350/d27f1f5f-ef4f-4c20-bd2b-1873eaabcc16)
On ADD TASK tab client must choose vehicle and service category(s).
  
*ADD VEHICLE  
Clients can add a new vehicle in the add-vehicle form
![add-vehicle (2)](https://github.com/PavPetrov/SoftUni_Java_Web_Sep23/assets/102189350/76e07bfa-840d-465c-b1b0-1dbc59db3945)

*MY TASKS  
Clients can view uncompleted and completed own tasks
![my-tasks](https://github.com/PavPetrov/SoftUni_Java_Web_Sep23/assets/102189350/ba3bc14b-80e0-4729-a3c0-9a16e41718fc)

*MY VEHICLES  
Clients can view and delete their own vehicles.  
Clients can change  their full name, e-mail and username on the settings tab.  

