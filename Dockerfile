FROM eclipse-temurin:21-alpine AS base
WORKDIR /app
COPY . ./

# Build

FROM base AS build
RUN --mount=type=cache,id=gradle,target=/root/.gradle \
    ./gradlew --build-cache --no-daemon -x check build

# Default

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

RUN apk --no-cache add curl && \
    adduser -D user

COPY --from=build /app/build/libs/backend-0.0.1-SNAPSHOT.jar ./app.jar

USER user
EXPOSE 8020
CMD ["java", "-jar", "/app/app.jar"]


