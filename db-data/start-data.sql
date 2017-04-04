CREATE TABLE ciclisti(
    id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(128) NOT NULL,
    cognome VARCHAR(128) NOT NULL,
    telefono VARCHAR(45) NOT NULL
);

CREATE UNIQUE INDEX ciclista_unique ON ciclisti (nome, cognome);
