# Getting started

This project uses the next Docker images: [mysql](https://hub.docker.com/_/mysql)  [adminer](https://hub.docker.com/_/adminer)

## Commands to create containers

`docker run --name mysql -e MYSQL_ROOT_PASSWORD=root -d -p 3306:3306 mysql`

`docker run --name adminer -d -p 8080:8080 adminer`

## Before execution

You've already created a database.
The `persistense.xml` needs to have the right name of connection, port and database.
