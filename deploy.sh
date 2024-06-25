./gradlew clean
./gradlew build
scp -i /Users/terrylee/Workspace/AWS/myKeyPair.pem nba-stats-tracker-api-gateway/build/libs/*1.0.0.jar nba-stats-tracker-service-discovery/build/libs/*1.0.0.jar nba-stats-tracker-web-server/build/libs/*1.0.0.jar  ec2-user@18.223.10.154:/home/ec2-user

cd nba-stats-tracker-web-client
npm run build:production
ssh -i /Users/terrylee/Workspace/AWS/myKeyPair.pem ec2-user@18.223.10.154 "rm -rf /home/ec2-user/build/*"
scp -i /Users/terrylee/Workspace/AWS/myKeyPair.pem -r ./build/* ec2-user@18.223.10.154:/home/ec2-user/build/