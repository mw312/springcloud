# 独立的Dockerfile镜像构建文件
FROM maven:3.5.2-jdk-8-alpine
MAINTAINER momo
ADD pom.xml /tmp/build/
ADD src /tmp/build/src
#构建应用
RUN cd /tmp/build && mvn clean package \
#拷贝编译结果到指定目录
&& mv target/*.jar /app.jar \
#清理编译痕迹
&& cd / && rm -rf /tmp/build
VOLUME /tmp
ENTRYPOINT ["java", "-jar", "/app.jar"]