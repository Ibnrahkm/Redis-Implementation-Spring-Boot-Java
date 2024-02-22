
# Redis implementation spring boot

Start redis docker



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
