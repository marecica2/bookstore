FROM njmittet/alpine-wildfly:10.1.0.Final
RUN /opt/jboss/wildfly/bin/add-user.sh admin Admin#70365 --silent
EXPOSE 8080
EXPOSE 9990

#RUN cd $JBOSS_HOME/standalone/deployments/ && \
#	wget http://repo1.maven.org/maven2/org/apache/activemq/activemq-rar/5.10.0/activemq-rar-5.10.0.rar    

ADD standalone-full-ha-bookstore.xml /opt/jboss/wildfly/standalone/configuration/

CMD ["/opt/jboss/wildfly/bin/standalone.sh", "-c", "standalone-full-ha-bookstore.xml", "-b", "0.0.0.0", "-bmanagement", "0.0.0.0"]