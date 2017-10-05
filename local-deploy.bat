cd C:\Work\workspace\bookstore\
call mvn clean install -DskipTests=true
call mvn dependency:copy@local-wildfly-deploy -Plocal-wildfly-deploy