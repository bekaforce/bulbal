FROM openjdk:11
VOLUME /rassrochka
COPY target/rassrochka-*.jar /app/app.jar
CMD ["java", "-jar", "/app/app.jar"]