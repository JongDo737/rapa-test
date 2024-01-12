FROM mysql:5.7.43

COPY ./utf8.cnf /etc/mysql/conf.d/

COPY ./Dump.sql /docker-entrypoint-initdb.d/

ENV MYSQL_ROOT_PASSWORD=frodo5020!!
ENV MYSQL_DATABASE=boot_board
ENV MYSQL_USER=frodo
ENV MYSQL_PASSWORD=frodo5020!!

# docker build --platform=linux/amd64 -t jongdo737/rapa-challange:db .
# docker run -p 3306:3306 --rm --name mysql-svc jongdo737/rapa-challange:db