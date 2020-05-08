FROM openjdk:8

WORKDIR /usr/local/bin

EXPOSE 8080

COPY /target/SpringSnippets-0.0.1-SNAPSHOT.jar mvcapp.jar

CMD ["java" , "-jar" , "mvcapp.jar"]