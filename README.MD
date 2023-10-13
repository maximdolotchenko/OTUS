1. Собрать докер образ командой
   docker build --build-arg JAR_FILE=service/target/otus-demo-file-spring-boot.jar --platform linux/amd64 -t
   response-ok-myapp .
2. Сделать тег
   docker tag response-ok-myapp maximchik40/response-ok-myapp
3. Залогиниться в докерхаб
   docker login -u maximchik40
4. Запушить
   docker push maximchik40/response-ok-myapp
5. Запустить локально и проверить
   docker run -d -p 8080:8080 response-ok-myapp
   Запустить в удаленном формате по инструкции https://docs.docker.com/get-started/04_sharing_app/

ДЗ 3

1) хелм чарты для инициализации БД лежит тут:
   https://github.com/maximdolotchenko/OTUS/tree/homework_3_ConfigMap_Secrets_Job/helmpostgres
   для запуска выполнить команду: helm install helmpostgres ./helmpostgres
2) конфиги кубера лежат тут:
   https://github.com/maximdolotchenko/OTUS/tree/homework_3_ConfigMap_Secrets_Job/k8s
   для применения выполнить команду kubectl apply -f configmap.yml -f secret.yml -f service.yml -f deployment.yml -f
   ingress.yml
3) коллеция постман для проверки лежит тут:
   https://github.com/maximdolotchenko/OTUS/tree/homework_3_ConfigMap_Secrets_Job/postman
