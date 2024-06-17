cd ..
./gradlew clean build
scp -i /Users/terrylee/Workspace/myKeyPair.pem -r build/libs/*jar ec2-user@18.223.10.154:/home/ec2-user/