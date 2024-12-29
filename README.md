# Resource-Allocation-Service
The Resource Allocation Service is a Spring Boot application designed to manage and allocate resources for different types of projects based on their skills and experience levels. It provides RESTful APIs for querying resources that match specific criteria, such as required skills and maximum experience.

#Technologies Used
1.Java 21
2.Spring Boot
3.Spring Data JPA
4.Lombok
5.Jakarta Persistence
6.MySQL (or any relational database)
7.Maven

#Prerequisites
1.Java 21 installed
2.Maven installed
3.A relational database (e.g., MySQL)
4.Spring Boot-compatible IDE (e.g., Spring Tool Suite or IntelliJ IDEA)

#Installation
1.Clone the repository
  git clone https://github.com/your-username/resource-allocation-service.git
2.Navigate to the project directory
  cd resource-allocation-service
3.Build the project:
 mvn clean install
4.mvn spring-boot:run

#API Endpoints
1. Fetch Resources for Microservice Projects
   Endpoint: /api/resources/microservice
   Method: GET
     Parameters:
       skills (List<String>): Required skills for the project.
   curl -X GET "http://localhost:8080/api/resources/microservice?skills=java,springboot"

2.Fetch Resources for Cloud Projects
   Endpoint: /api/resources/cloud
   Method: GET
   Parameters:
      skills (List<String>): Required skills for the project.
      maxExperience (Integer): Maximum years of experience for the resource.
  curl -X GET "http://localhost:8080/api/resources/cloud?skills=aws,devops&maxExperience=7"

#Project Structure

src/
├── main/
│   ├── java/com/est/resource/allocation/
│   │   ├── ResourceAllocationApplication.java  # Main Application Class
│   │   ├── controller/
│   │   │   └── ResourceAllocationController.java
│   │   ├── entity/
│   │   │   └── Resource.java
│   │   ├── repository/
│   │   │   └── ResourceRepository.java
│   │   ├── service/
│   │   │   ├── ResourceAllocationService.java
│   │   │   └── ResourceAllocationServiceImpl.java
├── resources/
│   ├── application.properties  # Configuration
│   └── data.sql                # Optional Seed Data
└── test/                       # Unit Tests








