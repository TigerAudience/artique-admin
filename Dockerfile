FROM openjdk:17
EXPOSE 8080
COPY ./src/main/resources/application-deploy.properties application-conf.properties
COPY ./build/libs/artique-admin-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar","--spring.config.location=/application-conf.properties"]