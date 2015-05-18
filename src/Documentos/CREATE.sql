-- CREATE DATABASE SALAO;
-- USE SALAO;
CREATE TABLE CARGO (CODCARGO int(10) NOT NULL AUTO_INCREMENT, DESCRICAO varchar(255) NOT NULL, PRIMARY KEY (CODCARGO));
CREATE TABLE USUARIO (CODUSUARIO int(10) NOT NULL AUTO_INCREMENT, USUARIO varchar(100) NOT NULL UNIQUE, SENHA varchar(150) NOT NULL, STATUS char(1) NOT NULL, PRIMARY KEY (CODUSUARIO));
CREATE TABLE SERVICO (CODSERVICO int(10) NOT NULL AUTO_INCREMENT, DESCRICAO varchar(255) NOT NULL UNIQUE, VALOR decimal(19, 2) NOT NULL, CODAGENDAMENTO int(10) NOT NULL, PRIMARY KEY (CODSERVICO));
CREATE TABLE AGENDAMENTO (CODAGENDAMENTO int(10) NOT NULL AUTO_INCREMENT, DATA_AGENDAMENTO datetime NOT NULL UNIQUE, CODPESSOA int(10) NOT NULL, `Column` int(10) NOT NULL, PRIMARY KEY (CODAGENDAMENTO));
CREATE TABLE ESTADO (CODESTADO int(10) NOT NULL AUTO_INCREMENT, DESCRICAO char(2) NOT NULL UNIQUE, PRIMARY KEY (CODESTADO));
CREATE TABLE CIDADE (CODCIDADE int(10) NOT NULL AUTO_INCREMENT, DESCRICAO varchar(255) NOT NULL UNIQUE, CODESTADO int(10) NOT NULL, PRIMARY KEY (CODCIDADE));
CREATE TABLE ENDERECO (CODENDERECO int(10) NOT NULL AUTO_INCREMENT, LOGRADOURO varchar(255) NOT NULL, NUMERO int(10) NOT NULL, COMPLEMENTO varchar(150), BAIRRO varchar(255) NOT NULL, CODCIDADE int(10) NOT NULL, CODPESSOA int(10) NOT NULL, PRIMARY KEY (CODENDERECO));
CREATE TABLE TELEFONE (CODTELEFONE int(10) NOT NULL AUTO_INCREMENT, NUMERO varchar(13) NOT NULL UNIQUE, CODPESSOA int(10) NOT NULL, PRIMARY KEY (CODTELEFONE));
CREATE TABLE PESSOA (CODPESSOA int(10) NOT NULL AUTO_INCREMENT, NOME varchar(200) NOT NULL, CPF varchar(14) NOT NULL UNIQUE, CODCARGO int(10), PRIMARY KEY (CODPESSOA));
ALTER TABLE AGENDAMENTO ADD INDEX FKAGENDAMENT172304 (`Column`), ADD CONSTRAINT FKAGENDAMENT172304 FOREIGN KEY (`Column`) REFERENCES PESSOA (CODPESSOA);
ALTER TABLE PESSOA ADD INDEX FKPESSOA70197 (CODCARGO), ADD CONSTRAINT FKPESSOA70197 FOREIGN KEY (CODCARGO) REFERENCES CARGO (CODCARGO);
ALTER TABLE SERVICO ADD INDEX FKSERVICO649313 (CODAGENDAMENTO), ADD CONSTRAINT FKSERVICO649313 FOREIGN KEY (CODAGENDAMENTO) REFERENCES AGENDAMENTO (CODAGENDAMENTO);
ALTER TABLE ENDERECO ADD INDEX FKENDERECO364126 (CODPESSOA), ADD CONSTRAINT FKENDERECO364126 FOREIGN KEY (CODPESSOA) REFERENCES PESSOA (CODPESSOA);
ALTER TABLE ENDERECO ADD INDEX FKENDERECO485117 (CODCIDADE), ADD CONSTRAINT FKENDERECO485117 FOREIGN KEY (CODCIDADE) REFERENCES CIDADE (CODCIDADE);
ALTER TABLE CIDADE ADD INDEX FKCIDADE570081 (CODESTADO), ADD CONSTRAINT FKCIDADE570081 FOREIGN KEY (CODESTADO) REFERENCES ESTADO (CODESTADO);
ALTER TABLE TELEFONE ADD INDEX FKTELEFONE803698 (CODPESSOA), ADD CONSTRAINT FKTELEFONE803698 FOREIGN KEY (CODPESSOA) REFERENCES PESSOA (CODPESSOA);

