# contentlake

Application leverages the Azure SDK to save the documents, images & video to the Azure Blob storage. After successful save post the 
content details to the Queue.

To setup the Application , below properties should be updated under src/resource/application.properties

#Blob storage container name
azure.storage.container-name=<Storage Container Name>
azure.storage.connection.string=<Storage Connection String>

#service Bus queue
spring.jms.servicebus.connection-string=<Service Bus Queue Connection string>
spring.jms.servicebus.idle-timeout=1800000
azure.servicebus.queue-name=ingestion

This application is packaged as Docker Image using Jib plugin, below properties should be updated in pom.xml 

#Docker Repo Url 
<docker.image.prefix></docker.image.prefix>
<username></username>
<password></password>

The Application can be build and pushed to DOCKER REPO command > 

mvn compile jib:build
