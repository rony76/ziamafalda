#!/bin/bash

echo "Lancio il server MySql"
docker run -d --name mysql-mafalda -p 3306:3306 -e MYSQL_ROOT_PASSWORD=marione-docker mysql:latest

echo "OK!"
