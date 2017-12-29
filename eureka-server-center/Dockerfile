FROM hub.c.163.com/wuxukun/maven-aliyun:3-jdk-8
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
#ARG JAR_FILE
#ADD /target/${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]