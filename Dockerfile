FROM airhacks/glassfish
COPY ./target/atencion-tickets.war ${DEPLOYMENT_DIR}
