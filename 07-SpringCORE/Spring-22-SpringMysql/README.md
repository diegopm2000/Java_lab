# Spring JDBC Template

Spring Complete Sample using Spring JDBC Template to connect to Mysql

## 1. Database

In the database folder, there is the next files:

- docker-compose.yml: docker-compose configuration of the database
- sample_db_schema.mwb: sample database model
- init_db.sql: script for the creation of the database

## 2. Steps to start up the database

- First, start the docker mysql container

```shell
$ docker-compose up -d
``

- Using the Mysql Workbench, execute the script init_db.sql to set the schema 

