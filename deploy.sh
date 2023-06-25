# docker buildx build -f Production.Dockerfile -t diegton/personal-finances-spring .
sudo rm -R ./target
docker-compose -f deploy-docker-compose.yml up java
docker buildx build --platform linux/arm64 -f Production.Dockerfile -t diegton/personal-finances-spring .
docker push diegton/personal-finances-spring:latest
sudo rm -R ./target