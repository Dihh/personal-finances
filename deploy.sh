# docker buildx build -f Production.Dockerfile -t diegton/personal-finances-spring .
docker buildx build --platform linux/arm64 -f Production.Dockerfile -t diegton/personal-finances-spring .
docker push diegton/personal-finances-spring:latest