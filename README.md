# Extendi-Mail  
Register user  

```json
{
    "email" : "vincenzoemanuele.carusotto@gmail.com",
    "password" : "test",
    "apiKey" : "not_the_real_api_key"
}
```  
![image](https://user-images.githubusercontent.com/12442767/159501492-63ae871a-b796-490e-b5a0-cf2fb48e3dba.png)  
Send Text Mail  
```json
{
    "receiverList" : ["mail1@test.com", "mail2@test.com"],
    "carbonCopyList" : ["mail3@test.com"],
    "blindCarbonCopyList" : ["mail4@test.com"],
    "subject" : "Subject test",

    "type" :"text",
    "text" : "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
}
```  
No authentication  
![image](https://user-images.githubusercontent.com/12442767/159502299-5d55ba32-7c75-49a0-98ef-51a7673734bd.png)  
With authentication  
![image](https://user-images.githubusercontent.com/12442767/159502406-15636c56-3bdd-49cf-9a5c-f3b7085712af.png)  
With attachments  
![image](https://user-images.githubusercontent.com/12442767/159502812-6b3e324b-6157-4749-81c2-2b5e37494136.png)
Static Template Mail  
```json
{
    "receiverList" : ["mail1@test.com", "mail2@test.com"],
    "carbonCopyList" : ["mail3@test.com"],
    "blindCarbonCopyList" : ["mail4@test.com"],
    "subject" : "Subject test",

    "type" :"template",
    "template" : "d-d5719877c9484ef2b9b7731148668df7"
}
```  
![image](https://user-images.githubusercontent.com/12442767/159503278-13058b8f-a037-4fe1-b6a9-1578c821180e.png)  
Dynamic Template Mail 1  
```json
{
    "receiverList" : ["mail1@test.com", "mail2@test.com"],
    "carbonCopyList" : ["mail3@test.com"],
    "blindCarbonCopyList" : ["mail4@test.com"],
    "subject" : "Subject test",

    "type" :"dynamicNameDay",
    "template" : "d-949a70ed9ac94f218da8756818745c0d",
    "name" : "Vincenzo",
    "day" : "Saturday"
}  
```  
![image](https://user-images.githubusercontent.com/12442767/159503600-0913a8ba-62f3-40d6-8bca-ee0749b289e4.png)  
Dynamic Template Mail 2  
```json
{
    "receiverList" : ["mail1@test.com", "mail2@test.com"],
    "carbonCopyList" : ["mail3@test.com"],
    "blindCarbonCopyList" : ["mail4@test.com"],
    "subject" : "Subject test",

    "type" :"dynamicNameService",
    "template" : "d-f28e63c103c641eea6c87b85fe420135",
    "name" : "Vincenzo",
    "service" : "Extendi"
}
```  
![image](https://user-images.githubusercontent.com/12442767/159504036-8737d071-9562-4269-8c5a-fc65a9273da5.png)



