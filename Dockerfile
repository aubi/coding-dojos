FROM payara/server-full:6.2024.3-jdk21
COPY target/coding-dojo-concurrency-0.1-SNAPSHOT.war $DEPLOY_DIR
