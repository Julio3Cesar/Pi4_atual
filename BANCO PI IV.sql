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
, COD_BARRAS		VARCHAR (100) NOT NULL UNIQUE
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
, CEP CHAR (8)
, LOGRADOURO VARCHAR (50)
, NUMERO VARCHAR(8)
, BAIRRO VARCHAR (50)
, CIDADE VARCHAR (50)
, UF CHAR (2)
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
, ID_ENDERECO_CLIENTE INT FOREIGN KEY REFERENCES ENDERECO_CLIENTE (ID_ENDERECO_CLIENTE)
, ID_CONTATO_CLIENTE INT FOREIGN KEY REFERENCES CONTATO_CLIENTE (ID_CONTATO_CLIENTE)	
);


-- VENDA SEGUNDA FASE:

CREATE TABLE VENDA (
  ID_VENDA   INT PRIMARY KEY IDENTITY
, ID_CLIENTE INT FOREIGN KEY REFERENCES CLIENTE (ID_CLIENTE)
, TIPO_PAGAMENTO VARCHAR (30)
, PARCELAS INT
, PRECO_TOTAL_VENDA MONEY
, DATA_DA_VENDA DATE
)

CREATE TABLE ITENS_VENDA (

  ID_VENDA INT FOREIGN KEY REFERENCES VENDA (ID_VENDA)
, ID_DESC_PRD INT FOREIGN KEY REFERENCES PRODUTO (ID_DESC_PRD) 
, CONSTRAINT ID_VENDA_PRODUTO PRIMARY KEY (ID_VENDA, ID_DESC_PRD)
, QTD INT
, PRECO_ORIGINAL_PRODUTO MONEY
)


GO

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- INSERTS NAS TABLES
INSERT INTO TIPO_PRODUTO VALUES ('CORDA','PRODUTO TESTE 1')
INSERT INTO TIPO_PRODUTO VALUES ('CORDA','PRODUTO TESTE 2')
INSERT INTO TIPO_PRODUTO VALUES ('CORDA','PRODUTO TESTE 3')
INSERT INTO TIPO_PRODUTO VALUES ('CORDA','PRODUTO TESTE 4')
INSERT INTO TIPO_PRODUTO VALUES ('CORDA','PRODUTO TESTE 5')
INSERT INTO TIPO_PRODUTO VALUES ('CORDA','PRODUTO TESTE 6')
INSERT INTO TIPO_PRODUTO VALUES ('CORDA','PRODUTO TESTE 7')
INSERT INTO TIPO_PRODUTO VALUES ('CORDA','PRODUTO TESTE 8')
INSERT INTO TIPO_PRODUTO VALUES ('CORDA','PRODUTO TESTE 9')
INSERT INTO TIPO_PRODUTO VALUES ('CORDA','PRODUTO TESTE 10')

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

INSERT INTO PRODUTO VALUES ('cod_111','MODELO TESTE 1','PRETO','100','10','1','1','1')
INSERT INTO PRODUTO VALUES ('asasas224a','MODELO TESTE 2','PRETO','100','10','1','2','2')
INSERT INTO PRODUTO VALUES ('asasas244a','MODELO TESTE 3','PRETO','100','10','1','3','3')
INSERT INTO PRODUTO VALUES ('asasas254a','MODELO TESTE 4','PRETO','100','10','1','4','4')
INSERT INTO PRODUTO VALUES ('asasas264a','MODELO TESTE 5','PRETO','100','10','1','5','5')
INSERT INTO PRODUTO VALUES ('asasas274a','MODELO TESTE 6','PRETO','100','10','1','6','6')
INSERT INTO PRODUTO VALUES ('asasas284a','MODELO TESTE 7','PRETO','100','10','1','7','7')
INSERT INTO PRODUTO VALUES ('asasas294a','MODELO TESTE 8','PRETO','100','10','1','8','8')
INSERT INTO PRODUTO VALUES ('asasas2124a','MODELO TESTE 9','PRETO','100','10','1','9','9')
INSERT INTO PRODUTO VALUES ('asasas21234a','MODELO TESTE 10','PRETO','100','10','1','10','10')

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


INSERT INTO VENDA VALUES ('1','CR�DITO','6','100','2017-11-25')
INSERT INTO VENDA VALUES ('1','CR�DITO','4','100','2017-11-25')
INSERT INTO VENDA VALUES ('2','CR�DITO','2','100','2017-11-25')
INSERT INTO VENDA VALUES ('2','D�BITO','1','100','2017-11-25')
INSERT INTO VENDA VALUES ('3','DINHEIRO','1','100','2017-11-25')
INSERT INTO VENDA VALUES ('4','DINHEIRO','1','100','2017-11-25')
INSERT INTO VENDA VALUES ('1','CR�DITO','6','100','2017-10-21')
INSERT INTO VENDA VALUES ('1','CR�DITO','4','100','2017-10-22')
INSERT INTO VENDA VALUES ('2','CR�DITO','2','100','2017-10-22')
INSERT INTO VENDA VALUES ('2','D�BITO','1','100','2017-09-01')
INSERT INTO VENDA VALUES ('3','DINHEIRO','1','100','2017-09-01')
INSERT INTO VENDA VALUES ('4','DINHEIRO','1','100','2017-09-01')
INSERT INTO VENDA VALUES ('1','CART�O','6','100','2017-11-25')
INSERT INTO VENDA VALUES ('1','CART�O','4','100','2017-11-25')
INSERT INTO VENDA VALUES ('2','CART�O','2','100','2017-11-25')
INSERT INTO VENDA VALUES ('2','D�BITO','1','100','2017-11-25')
INSERT INTO VENDA VALUES ('3','DINHEIRO','1','100','2017-11-25')
INSERT INTO VENDA VALUES ('4','DINHEIRO','1','100','2017-11-25')
INSERT INTO VENDA VALUES ('1','BOLETO','6','100','2017-10-21')
INSERT INTO VENDA VALUES ('1','BOLETO','4','100','2017-10-22')
INSERT INTO VENDA VALUES ('2','BOLETO','2','100','2017-10-22')
INSERT INTO VENDA VALUES ('2','D�BITO','1','100','2017-09-01')
INSERT INTO VENDA VALUES ('3','DINHEIRO','1','100','2017-09-01')
INSERT INTO VENDA VALUES ('4','DINHEIRO','1','100','2017-09-01')

INSERT INTO ITENS_VENDA VALUES ('1','1','1','100')
INSERT INTO ITENS_VENDA VALUES ('2','2','1','100')
INSERT INTO ITENS_VENDA VALUES ('3','3','1','100')
INSERT INTO ITENS_VENDA VALUES ('4','4','1','100')
INSERT INTO ITENS_VENDA VALUES ('5','1','1','100')
INSERT INTO ITENS_VENDA VALUES ('6','2','1','100')
INSERT INTO ITENS_VENDA VALUES ('7','1','1','100')
INSERT INTO ITENS_VENDA VALUES ('8','2','1','100')
INSERT INTO ITENS_VENDA VALUES ('9','3','1','100')
INSERT INTO ITENS_VENDA VALUES ('10','4','1','100')
INSERT INTO ITENS_VENDA VALUES ('11','1','1','100')
INSERT INTO ITENS_VENDA VALUES ('12','2','1','100')
INSERT INTO ITENS_VENDA VALUES ('13','1','1','100')
INSERT INTO ITENS_VENDA VALUES ('14','2','1','100')
INSERT INTO ITENS_VENDA VALUES ('15','3','1','100')
INSERT INTO ITENS_VENDA VALUES ('16','4','1','100')
INSERT INTO ITENS_VENDA VALUES ('17','1','1','100')
INSERT INTO ITENS_VENDA VALUES ('18','2','1','100')
INSERT INTO ITENS_VENDA VALUES ('19','1','1','100')
INSERT INTO ITENS_VENDA VALUES ('20','2','1','100')
INSERT INTO ITENS_VENDA VALUES ('21','3','1','100')
INSERT INTO ITENS_VENDA VALUES ('22','4','1','100')
INSERT INTO ITENS_VENDA VALUES ('23','1','1','100')
INSERT INTO ITENS_VENDA VALUES ('24','2','1','100')

--- SELECT EM TODAS AS TABLES:


SELECT * FROM TIPO_PRODUTO
SELECT * FROM MARCA_PRODUTO
SELECT * FROM PRODUTO
SELECT * FROM ENDERECO_CLIENTE
SELECT * FROM CONTATO_CLIENTE
SELECT * FROM CLIENTE
SELECT * FROM VENDA
SELECT * FROM ITENS_VENDA
SELECT MAX(ID_VENDA) AS "ID_VENDA" FROM VENDA

--DROP VIEW RELATORIO3

-- VIEW DO RELAT�RIO	

-- CREATE VIEW :

GO

CREATE VIEW RELATORIO_DETALHADO
AS
SELECT 
  a.DATA_DA_VENDA
, E.NOME_PRD 
, B.PRECO_ORIGINAL_PRODUTO
, count (E.NOME_PRD) as [QTD]
, sum (A.PRECO_TOTAL_VENDA) AS [TOTAL_PERIODO]
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

-- CREATE VIEW :

CREATE VIEW RELATORIO_GERAL AS

SELECT DATA_DA_VENDA
, COUNT (ID_VENDA) [TOTAL_DE_VENDAS]
, COUNT (CASE WHEN PARCELAS = 1 THEN 1 ELSE NULL END) AS 'A_VISTA'
, COUNT (CASE WHEN PARCELAS > 1 THEN 1 ELSE NULL END) AS 'PARCELADO'
FROM VENDA
GROUP BY DATA_DA_VENDA
GO


------------------- SELECT NAS VIEWS: 


-- VIEW 1

SELECT * FROM RELATORIO_DETALHADO
WHERE DATA_DA_VENDA BETWEEN '2017-01-01' AND '2017-12-30'
ORDER BY DATA_DA_VENDA


---- VIEW 2

SELECT * FROM RELATORIO_GERAL 
WHERE 
DATA_DA_VENDA BETWEEN '2017-01-01' AND '2017-12-30'
ORDER BY DATA_DA_VENDA



