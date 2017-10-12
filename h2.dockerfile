FROM anapsix/alpine-java:8_server-jre

ENV H2_URL="http://www.h2database.com/h2-2017-04-23.zip"
ENV VERSION="0.1"
ENV APPROOT="/tmp/h2/bin"

WORKDIR $APPROOT

# Web Console port
EXPOSE 8082
# TCP port
EXPOSE 9092
# PG server port
EXPOSE 5435

RUN wget $H2_URL -O /tmp/h2.zip && \
	cd /tmp && \
	unzip -qq h2.zip 
	
RUN echo $PATH
	
CMD ["java", "-jar", "$APPROOT/h2-1.4.195.jar", "-webAllowOthers", "-tcpAllowOthers"]

