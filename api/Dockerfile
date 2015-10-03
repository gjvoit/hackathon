FROM ruby:2.2.2

RUN apt-get update -y && \
    apt-get install -y && \
    apt-get install -y postgresql postgresql-contrib

RUN mkdir -p /code
WORKDIR /code

COPY . /code


RUN apt-get install -y sudo
COPY pg_hba.conf /etc/postgresql/9.3/main/pg_hba.conf
RUN service postgresql start && \
    sudo -u postgres psql -c "select pg_reload_conf();"


RUN bundle install


RUN service postgresql start && \
    sleep 5 && \
    sudo -u postgres psql -c "CREATE USER postadmin WITH PASSWORD 'hello' CREATEDB;"

RUN service postgresql start && \
    sleep 5 && \
    rake db:create db:migrate

EXPOSE 3000
CMD rails s -b 0.0.0.0 -p 3000 
