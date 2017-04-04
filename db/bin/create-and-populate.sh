#!/bin/bash

echo "Creazione DB e utente"
docker run --link mysql-mafalda:mysql -v "${PWD}"/../sql:/tmp --rm mysql\
    sh -c 'exec mysql -h"mysql" -uroot -pmarione-docker < /tmp/create.sql'

echo "Creazione Tabelle e utente"
docker run --link mysql-mafalda:mysql -v "${PWD}"/../sql:/tmp --rm mysql\
    sh -c 'exec mysql -h"mysql" -umarione -pmarione ziamafalda < /tmp/start-data.sql'

echo "OK!"
