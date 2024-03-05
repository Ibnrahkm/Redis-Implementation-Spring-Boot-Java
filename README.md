# Redis implementation spring boot

start redis docker

```
sudo docker run --name redis -d -p 6379:6379 -e REDIS_PASSWORD=123456 redis sh -c 'exec redis-server --requirepass "$REDIS_PASSWORD"'

```

from project root directory

```
./gradlew clean build

```
after successful build run the project

```
java -jar <jarfile>

```

Test the APIs from postman

## Note
for redis template the bean is created.You just need to use it for direct execution on redis such as list,set,value etc.
I have used pre built functions for doing actions.but I also defined the custom redis template into the bean which could be used for more complex things.This redis template is also available by default.
