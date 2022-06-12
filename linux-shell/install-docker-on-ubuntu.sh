sudo apt-get update
sudo apt-get install apt-transport-https ca-certificates curl gnupg-agent software-properties-common
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(. /etc/os-release; echo "$UBUNTU_CODENAME") stable"
sudo apt-get update
sudo apt-get -y install docker-ce
sudo usermod -aG docker $USER
docker --version

sudo apt install docker-compose
docker-compose --version
# sudo mkdir /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose

#Docker Commands
# Images
docker build . -t expense:1.0.0 -t expense:latest
docker images
docker rmi 6c0db4beaf52

#Container
docker ps -a
docker start uzrnem
docker rm confident_kare
docker run -p 8082:8080 -d uzrnem
docker logs thirsty_zhukovsky
docker exec -it thirsty_zhukovsky bash
docker stop thirsty_zhukovsky
docker run -p 8000:8000 --name rest-server uzrnem
docker-compose up