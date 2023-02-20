FROM openjdk:11
COPY "./target/busqueda-0.0.1-SNAPSHOT.jar" "busqueda.jar"
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "busqueda.jar"]