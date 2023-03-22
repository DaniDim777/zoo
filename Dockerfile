FROM maven:4.0.0-jdk-11
ADD . /home/workdir
WORKDIR /home/workdir/
RUN mvn install -Dmaven.test.skip=true

FROM openjdk:11

COPY --from=0 /home/workdir/zoo/target/zoo-0.0.1-SNAPSHOT.jar /home/wordir/zoo.jar
WORKDIR /home/workdir/
CMD ["java", "-jar", "zoo.jar"]