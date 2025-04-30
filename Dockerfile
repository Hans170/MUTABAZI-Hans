FROM eclipse-temurin:21
WORKDIR /app

COPY ./src /app/src

RUN mkdir out

RUN find src -name "*.java" > sources.txt && javac @sources.txt -d out

CMD ["java", "-cp", "out", "Question1.Main1"]
