# Movie Spider

## Description

This project is a Java Spring Boot application that scrapes movie titles and URLs from the website `https://www.peiqi.tv/`.

## Technologies Used

- Java
- Spring Boot
- Jsoup
- Maven

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/gelinwangzi/test-tool.git
   ```
2. Navigate to the project directory:
   ```bash
   cd test-tool
   ```
3. Build the project using Maven:
   ```bash
   ./mvnw clean package
   ```
4. Run the application:
   ```bash
   java -jar target/spider-0.0.1-SNAPSHOT.jar
   ```

## Usage

The main scraping logic is in the `com.green.spider.JsoupTest` class. You can use the `getMovieList()` method to retrieve a list of movies.

Example:

```java
import com.green.spider.JsoupTest;
import com.green.spider.movie;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JsoupTest jsoupTest = new JsoupTest();
        try {
            List<movie> movieList = jsoupTest.getMovieList();
            for (movie movie : movieList) {
                System.out.println("Title: " + movie.getTitle());
                System.out.println("URL: " + movie.getUrl());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## Output

The `getMovieList()` method returns a `List<movie>`. Each `movie` object contains:

- `title`: The title of the movie.
- `url`: The URL to the movie on `https://www.peiqi.tv/`.
