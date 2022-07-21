FROM amazoncorretto:17.0.4

COPY build/libs/*.jar /app/app.jar
CMD java -jar /app/app.jar