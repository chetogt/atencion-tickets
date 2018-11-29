# Build
mvn clean package && docker build -t gt.com.kinal/atencion-tickets .

# RUN

docker rm -f atencion-tickets || true && docker run -d -p 8080:8080 -p 4848:4848 --name atencion-tickets gt.com.kinal/atencion-tickets 