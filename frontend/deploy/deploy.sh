npm run build
ssh -i /Users/terrylee/Workspace/myKeyPair.pem ec2-user@18.223.10.154 "rm -r /home/ec2-user/build/*"
scp -i /Users/terrylee/Workspace/myKeyPair.pem -r ../build/* ec2-user@18.223.10.154:/home/ec2-user/build