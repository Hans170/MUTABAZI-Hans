# Use OpenJDK image
FROM openjdk:17

# Set working directory inside the container
WORKDIR /app

# Copy your source code into the container
COPY ./src /app/src

# Compile the Java files
RUN javac $(find src -name "*.java")

# Set the main class to run (adjust Main1, Main3, or Mainn depending on your main class)
CMD ["java", "src.Question1.Main1"]
