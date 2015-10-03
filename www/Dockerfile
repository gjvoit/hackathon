FROM ubuntu

WORKDIR /code
COPY . /code

RUN apt-get update && sudo apt-get install -y npm nodejs  && \
    gpg --keyserver hkp://keys.gnupg.net --recv-keys 409B6B1796C275462A1703113804BB82D39DC0E3 && \
    ln -s /usr/bin/nodejs /usr/bin/node

RUN apt-get install -y ruby-dev && \
    npm install -g bower grunt

RUN apt-get install -y git && \
    bower install --allow-root && \
    bower install --allow-root grunt-cli

RUN npm install && \
    npm install -g grunt-cli && \
    gem install compass

CMD grunt serve


