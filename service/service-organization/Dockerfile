FROM java:8
EXPOSE 8080

VOLUME /tmp
ADD s7.jar  /app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Xms100m","-Xmx100m","-jar","/app.jar","--spring.profiles.active=prod"]
