FROM ruby:2.2.2

RUN apt-get update -y && \
    apt-get install -y && \
    apt-get install -y postgresql postgresql-contrib

RUN mkdir -p /code
WORKDIR /code

COPY . /code

RUN bundle install --allow-root

EXPOSE 3000
CMD rails s -b 0.0.0.0 -p 3000 
