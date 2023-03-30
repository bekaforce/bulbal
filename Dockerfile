FROM openjdk:11
VOLUME /admin_bulbal
COPY target/admin_bulbal-*.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]
