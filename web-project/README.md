Usage
-----
- Build with gradle: `gradle war` or `gradle build`
- Build docker image: `docker build -t wp:wp .`
- Run container: `docker run -p 8080:8080 -p 8000:8000 wp:wp`
- Access on `http://localhost:8080/wp`. Port for debug is `8000`.
