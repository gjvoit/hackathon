#!/usr/bin/env bash
echo Starting Selenium Container
sudo docker build -t hub .
HUB=$(sudo docker run -d -p 4444:4444 hub)
HUB_NAME=$(sudo docker inspect -f '{{ .Name  }}' $HUB | sed s:/::)
sleep 2

NODE_CHROME=$(sudo docker run -d --link $HUB_NAME:hub  selenium/node-chrome:2.47.1)
NODE_FIREFOX=$(sudo docker run -d --link $HUB_NAME:hub selenium/node-firefox:2.47.1)

docker logs -f $HUB &
docker logs -f $NODE_CHROME &
docker logs -f $NODE_FIREFOX &
sleep 2

function test_node {
  BROWSER=$1
  echo Running $BROWSER test...
  mvn clean test
  STATUS=$?

  if [ ! $STATUS == 0 ]; then
    echo Failed
    exit 1
  fi

}

test_node chrome
#test_node firefox

if [ ! "$CIRCLECI" ==  "true" ]; then
  echo Tearing down Selenium Chrome Node container
  sudo docker stop $NODE_CHROME
  sudo docker rm $NODE_CHROME

  echo Tearing down Selenium Firefox Node container
  sudo docker stop $NODE_FIREFOX
  sudo docker rm $NODE_FIREFOX

  echo Tearing down Selenium Hub container
  sudo docker stop $HUB
  sudo docker rm $HUB
fi

echo Done

