rm key.pem cert.pem keystore.p12
openssl req -x509 -newkey rsa:4096 -keyout key.pem -out cert.pem -days 365 -nodes
openssl pkcs12 -export -in cert.pem -inkey key.pem -out keystore.p12 -name tomcat -CAfile cert.pem -caname root

