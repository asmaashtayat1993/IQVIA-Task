objective :

we have two microservices :

 1-  user-service : that  create user and store it in h2 database.
 
 2-  user-mamgmanr-service : User Management Service management tasks like fetching and modifying user details call microservice 1 using open open feign client.
  


  database :
  
   used H2 In memory database.
   
   accessible by (http://localhost:8080/h2-console) 
   
   with credinatial mentioned in application.properties file.
   

   
  
