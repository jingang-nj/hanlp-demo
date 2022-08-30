FROM openjdk:8-jre-alpine

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone

ENV APP_NAME="web-demo" \
    APOLLO="-Dapollo.meta=http://192.168.8.6:8083" \
    LANG="en_US.UTF-8" \
    LANGUAGE="en" \
    TZ="Asia/Shanghai" \
    JVM_OPTS="-Xms512m -Xmx512m" \
    HEAP_DUMP_OPTS="-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/work/logs/"

COPY ${APP_NAME}.jar  /work/${APP_NAME}.jar

ENTRYPOINT java ${APOLLO} ${JVM_OPTS} ${HEAP_DUMP_OPTS}  -jar /work/${APP_NAME}.jar