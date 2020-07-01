FROM oracle/graalvm-ce:20.1.0-java11 as graalvm
RUN gu install native-image

COPY . /home/app/brunobarinconfigdemo
WORKDIR /home/app/brunobarinconfigdemo

RUN native-image --no-server -cp build/libs/brunobarinconfigdemo-*-all.jar

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/brunobarinconfigdemo/brunobarinconfigdemo /app/brunobarinconfigdemo
ENTRYPOINT ["/app/brunobarinconfigdemo"]
