1. Собрать докер образ командой
    docker build --build-arg JAR_FILE=service/target/otus-demo-file-spring-boot.jar --platform linux/amd64 -t response-ok-myapp .
2. Сделать тег
   docker tag response-ok-myapp maximchik40/response-ok-myapp
3. Залогиниться в докерхаб 
    docker login  -u maximchik40 
4. Запушить
   docker push maximchik40/response-ok-myapp   
5. Запустить локально и проверить
   docker run -d -p 8080:8080 response-ok-myapp 
   Запустить в удаленном формате по инструкции https://docs.docker.com/get-started/04_sharing_app/
