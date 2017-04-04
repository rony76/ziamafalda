CREATE DATABASE ziamafalda;

GRANT ALL ON ziamafalda.* TO marione@'%' IDENTIFIED BY 'marione';

GRANT ALL ON ziamafalda.* TO marione@'localhost' IDENTIFIED BY 'marione';

FLUSH PRIVILEGES;

