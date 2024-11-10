FROM openjdk:17

EXPOSE 8085
ADD target/Reservation-5.0.0.jar Reservation-dk.jar
ENTRYPOINT ["java", "-jar", "Reservation-dk.jar"]
