USE master				
																  
if exists (SELECT * FROM SYS.DATABASES where name = 'LOJA_DE_MUSICA')					  
begin drop DATABASE LOJA_DE_MUSICA 														  
end		


CREATE DATABASE LOJA_DE_MUSICA;
GO

USE LOJA_DE_MUSICA;
GO

-- PRODUTO PRIMEIRA FASE:


CREATE TABLE TIPO_PRODUTO (
  ID_TIPO_PRD                       INT IDENTITY(1,1) PRIMARY KEY 
, TIPO_PRD                     VARCHAR (50)          NOT NULL
, NOME_PRD                      VARCHAR (50) UNIQUE	     NOT NULL 
);

CREATE TABLE MARCA_PRODUTO (	
  ID_MARCA_PRD                    INT IDENTITY(1,1) PRIMARY KEY 
, MARCA_PRD                    	   VARCHAR (50)	   UNIQUE NOT NULL
);

CREATE TABLE PRODUTO (
  ID_DESC_PRD              	INT IDENTITY(1,1) PRIMARY KEY 
, MODELO_PRD 			VARCHAR (50)	    NOT NULL
, COR_PRD                      	VARCHAR (20)	    NOT NULL
, PRECO_PRD                     MONEY		    NOT NULL
, QTD_EM_ESTOQUE_PRD            INT 		    NOT NULL
, ENABLE			BIT 	            NOT NULL
	
, ID_TIPO_PRD INT FOREIGN KEY REFERENCES TIPO_PRODUTO(ID_TIPO_PRD) NOT NULL
, ID_MARCA_PRD INT FOREIGN KEY REFERENCES MARCA_PRODUTO(ID_MARCA_PRD) NOT NULL

, CONSTRAINT UNIQUE_MARCA_PROD_MODEL UNIQUE (ID_TIPO_PRD, ID_MARCA_PRD, MODELO_PRD)
);



-- CLIENTE PRIMEIRA FASE: 

CREATE TABLE ENDERECO_CLIENTE (
  ID_ENDERECO_CLIENTE                  INT PRIMARY KEY IDENTITY
, CEP CHAR (8)	NOT NULL
, LOGRADOURO VARCHAR (50) NOT NULL
, NUMERO VARCHAR(8) NOT NULL
, BAIRRO VARCHAR (50) NOT NULL
, CIDADE VARCHAR (50) NOT NULL
, UF CHAR (2) NOT NULL
);

CREATE TABLE CONTATO_CLIENTE(
  ID_CONTATO_CLIENTE                  INT PRIMARY KEY IDENTITY
, TELEFONE CHAR (10)
, CELULAR CHAR (11)
, EMAIL VARCHAR (100)
);

CREATE TABLE CLIENTE (
  ID_CLIENTE                  INT PRIMARY KEY IDENTITY
, NOME_CLIENTE                VARCHAR (200)	 NOT NULL
, CPF_CLIENTE                 CHAR    (20) 	 NOT NULL
, RG_CLIENTE                  CHAR    (20)	 NOT NULL 
, SEXO_CLIENTE                CHAR    (1)	 NOT NULL
, ESTADO_CIVIL_CLIENTE        VARCHAR (30)	 NOT NULL
, DT_NASCIMENTO_CLIENTE       DATE	 NOT NULL
, ENABLE		      BIT                NOT NULL	
, ID_ENDERECO_CLIENTE INT FOREIGN KEY REFERENCES ENDERECO_CLIENTE (ID_ENDERECO_CLIENTE) NOT NULL
, ID_CONTATO_CLIENTE INT FOREIGN KEY REFERENCES CONTATO_CLIENTE (ID_CONTATO_CLIENTE) NOT NULL	 
);


-- VENDA SEGUNDA FASE:

CREATE TABLE VENDA (
  ID_VENDA INT PRIMARY KEY 
, ID_CLIENTE INT FOREIGN KEY REFERENCES CLIENTE (ID_CLIENTE) NOT NULL
, TIPO_PAGAMENTO VARCHAR (30) NOT NULL
, PARCELAS INT NOT NULL
, PRECO_TOTAL_VENDA MONEY NOT NULL
, DATA_DA_VENDA DATE NOT NULL
)

CREATE TABLE ITENS_VENDA (

  ID_VENDA INT FOREIGN KEY REFERENCES VENDA (ID_VENDA)
, ID_DESC_PRD INT FOREIGN KEY REFERENCES PRODUTO (ID_DESC_PRD) 
, CONSTRAINT ID_VENDA_PRODUTO PRIMARY KEY (ID_VENDA, ID_DESC_PRD)
, QTD INT NOT NULL
, PRECO_ORIGINAL_PRODUTO MONEY NOT NULL
)






GO

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO TIPO_PRODUTO VALUES ('TIPO 1','PRODUTO TESTE 1')
INSERT INTO TIPO_PRODUTO VALUES ('TIPO 2','PRODUTO TESTE 2')
INSERT INTO TIPO_PRODUTO VALUES ('TIPO 3','PRODUTO TESTE 3')
INSERT INTO TIPO_PRODUTO VALUES ('TIPO 4','PRODUTO TESTE 4')
INSERT INTO TIPO_PRODUTO VALUES ('TIPO 5','PRODUTO TESTE 5')
INSERT INTO TIPO_PRODUTO VALUES ('TIPO 6','PRODUTO TESTE 6')
INSERT INTO TIPO_PRODUTO VALUES ('TIPO 7','PRODUTO TESTE 7')
INSERT INTO TIPO_PRODUTO VALUES ('TIPO 8','PRODUTO TESTE 8')
INSERT INTO TIPO_PRODUTO VALUES ('TIPO 9','PRODUTO TESTE 9')
INSERT INTO TIPO_PRODUTO VALUES ('TIPO 10','PRODUTO TESTE 10')

INSERT INTO MARCA_PRODUTO VALUES ('MARCA TESTE 1')
INSERT INTO MARCA_PRODUTO VALUES ('MARCA TESTE 2')
INSERT INTO MARCA_PRODUTO VALUES ('MARCA TESTE 3')
INSERT INTO MARCA_PRODUTO VALUES ('MARCA TESTE 4')
INSERT INTO MARCA_PRODUTO VALUES ('MARCA TESTE 5')
INSERT INTO MARCA_PRODUTO VALUES ('MARCA TESTE 6')
INSERT INTO MARCA_PRODUTO VALUES ('MARCA TESTE 7')
INSERT INTO MARCA_PRODUTO VALUES ('MARCA TESTE 8')
INSERT INTO MARCA_PRODUTO VALUES ('MARCA TESTE 9')
INSERT INTO MARCA_PRODUTO VALUES ('MARCA TESTE 10')

INSERT INTO PRODUTO VALUES ('MODELO TESTE 1','PRETO','100','10','1','1','1')
INSERT INTO PRODUTO VALUES ('MODELO TESTE 2','PRETO','100','10','1','2','2')
INSERT INTO PRODUTO VALUES ('MODELO TESTE 3','PRETO','100','10','1','3','3')
INSERT INTO PRODUTO VALUES ('MODELO TESTE 4','PRETO','100','10','1','4','4')
INSERT INTO PRODUTO VALUES ('MODELO TESTE 5','PRETO','100','10','1','5','5')
INSERT INTO PRODUTO VALUES ('MODELO TESTE 6','PRETO','100','10','1','6','6')
INSERT INTO PRODUTO VALUES ('MODELO TESTE 7','PRETO','100','10','1','7','7')
INSERT INTO PRODUTO VALUES ('MODELO TESTE 8','PRETO','100','10','1','8','8')
INSERT INTO PRODUTO VALUES ('MODELO TESTE 9','PRETO','100','10','1','9','9')
INSERT INTO PRODUTO VALUES ('MODELO TESTE 10','PRETO','100','10','1','10','10')

INSERT INTO ENDERECO_CLIENTE VALUES ('11111111','RUA TESTE 1','1','BAIRRO TESTE 1','CIDADE TESTE 1','SP')
INSERT INTO ENDERECO_CLIENTE VALUES ('22222222','RUA TESTE 2','2','BAIRRO TESTE 2','CIDADE TESTE 2','MG')
INSERT INTO ENDERECO_CLIENTE VALUES ('33333333','RUA TESTE 3','3','BAIRRO TESTE 3','CIDADE TESTE 3','SP')
INSERT INTO ENDERECO_CLIENTE VALUES ('44444444','RUA TESTE 4','4','BAIRRO TESTE 4','CIDADE TESTE 4','SP')
INSERT INTO ENDERECO_CLIENTE VALUES ('55555555','RUA TESTE 5','5','BAIRRO TESTE 5','CIDADE TESTE 5','MG')
INSERT INTO ENDERECO_CLIENTE VALUES ('66666666','RUA TESTE 6','6','BAIRRO TESTE 6','CIDADE TESTE 6','SP')
INSERT INTO ENDERECO_CLIENTE VALUES ('77777777','RUA TESTE 7','7','BAIRRO TESTE 7','CIDADE TESTE 7','SP')
INSERT INTO ENDERECO_CLIENTE VALUES ('88888888','RUA TESTE 8','8','BAIRRO TESTE 8','CIDADE TESTE 8','MG')
INSERT INTO ENDERECO_CLIENTE VALUES ('99999999','RUA TESTE 9','9','BAIRRO TESTE 9','CIDADE TESTE 9','SP')
INSERT INTO ENDERECO_CLIENTE VALUES ('12121212','RUA TESTE 10','10','BAIRRO TESTE 10','CIDADE TESTE 10','SP')

INSERT INTO CONTATO_CLIENTE VALUES ('1111111111','11911111111','EMAILTESTE1@TESTE.COM')
INSERT INTO CONTATO_CLIENTE VALUES ('2222222222','11922222222','EMAILTESTE2@TESTE.COM')
INSERT INTO CONTATO_CLIENTE VALUES ('3333333333','11933333333','EMAILTESTE3@TESTE.COM')
INSERT INTO CONTATO_CLIENTE VALUES ('4444444444','11944444444','EMAILTESTE4@TESTE.COM')
INSERT INTO CONTATO_CLIENTE VALUES ('5555555555','11955555555','EMAILTESTE5@TESTE.COM')
INSERT INTO CONTATO_CLIENTE VALUES ('6666666666','11966666666','EMAILTESTE6@TESTE.COM')
INSERT INTO CONTATO_CLIENTE VALUES ('7777777777','11977777777','EMAILTESTE7@TESTE.COM')
INSERT INTO CONTATO_CLIENTE VALUES ('8888888888','11988888888','EMAILTESTE8@TESTE.COM')
INSERT INTO CONTATO_CLIENTE VALUES ('9999999999','11999999999','EMAILTESTE9@TESTE.COM')
INSERT INTO CONTATO_CLIENTE VALUES ('1212121212','12011111110','EMAILTESTE10@TESTE.COM')

INSERT INTO CLIENTE VALUES ('JO�O ARLINDO','44455566633','41658024X','M','SOLTEIRO','19901010','1','1','1')
INSERT INTO CLIENTE VALUES ('CLENILDO JONILDO','55566677744','45325486X','F','SOLTEIRO','19901010','1','2','2')
INSERT INTO CLIENTE VALUES ('DORIVAL CLAUDISON','66677788855','31515652X','M','SOLTEIRO','19901010','1','3','3')
INSERT INTO CLIENTE VALUES ('DIVSON MULTIPLICASON','77788899966','41864652X','F','SOLTEIRO','19901010','1','4','4')
INSERT INTO CLIENTE VALUES ('MENOS MAISON','88900011077','16845213X','M','SOLTEIRO','19901010','1','5','5')
INSERT INTO CLIENTE VALUES ('OLDSON NEWSON','11122233344','65132123X','F','SOLTEIRO','19901010','1','6','6')
INSERT INTO CLIENTE VALUES ('NEWSON OLDSON','22233344455','68412321X','M','SOLTEIRO','19901010','1','7','7')
INSERT INTO CLIENTE VALUES ('EDUARDO EDUARDSON','33344455566','51612313X','F','SOLTEIRO','19901010','1','8','8')
INSERT INTO CLIENTE VALUES ('JUCA PINDUCA','44422233344','84913253X','M','SOLTEIRO','19901010','1','9','9')
INSERT INTO CLIENTE VALUES ('MONICA MAGALISON','88866644422','84613284X','F','SOLTEIRO','19901010','1','10','10')

INSERT INTO VENDA VALUES ('1','1','CART�O DE CR�DITO - PARCELADO','6','100','2017-11-25')
INSERT INTO VENDA VALUES ('2','1','CART�O DE CR�DITO - PARCELADO','4','100','2017-11-25')
INSERT INTO VENDA VALUES ('3','2','CART�O DE CR�DITO - PARCELADO','2','100','2017-11-25')
INSERT INTO VENDA VALUES ('4','2','A VISTA - D�BITO','1','100','2017-11-25')
INSERT INTO VENDA VALUES ('5','3','A VISTA - DINHEIRO','1','100','2017-11-25')
INSERT INTO VENDA VALUES ('6','4','A VISTA - DINHEIRO','1','100','2017-11-25')

INSERT INTO ITENS_VENDA VALUES ('1','1','1','100')
INSERT INTO ITENS_VENDA VALUES ('2','2','1','100')
INSERT INTO ITENS_VENDA VALUES ('3','3','1','100')
INSERT INTO ITENS_VENDA VALUES ('4','4','1','100')
INSERT INTO ITENS_VENDA VALUES ('5','1','1','100')
INSERT INTO ITENS_VENDA VALUES ('6','2','1','100')


SELECT * FROM TIPO_PRODUTO
SELECT * FROM MARCA_PRODUTO
SELECT * FROM PRODUTO
SELECT * FROM ENDERECO_CLIENTE
SELECT * FROM CONTATO_CLIENTE
SELECT * FROM CLIENTE
SELECT * FROM VENDA
SELECT * FROM ITENS_VENDA

--DROP VIEW RELATORIO3

-- VIEW DO RELAT�RIO	
GO

CREATE VIEW RELATORIO
AS
SELECT 
  E.NOME_PRD 
, B.PRECO_ORIGINAL_PRODUTO
, a.DATA_DA_VENDA
, count (E.NOME_PRD) as [QTD]
, sum (A.PRECO_TOTAL_VENDA) AS [TOTAL]
FROM
VENDA A 
INNER JOIN 
ITENS_VENDA B 
ON 
A.ID_VENDA = B.ID_VENDA
INNER JOIN 
PRODUTO C 
ON 
B.ID_DESC_PRD = C.ID_DESC_PRD
INNER JOIN 
TIPO_PRODUTO E 
ON 
E.ID_TIPO_PRD = C.ID_TIPO_PRD
GROUP BY 
  E.NOME_PRD 
, B.PRECO_ORIGINAL_PRODUTO
, a.DATA_DA_VENDA
GO

SELECT * FROM RELATORIO
WHERE DATA_DA_VENDA BETWEEN '2017-11-10' AND '2017-11-25'