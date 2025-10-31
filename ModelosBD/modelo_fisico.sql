CREATE DATABASE financas;

CREATE TABLE transacao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo ENUM('receita', 'despesa') NOT NULL,
    id_categoria INT,
    id_origem INT,
    valor DECIMAL(10,2) NOT NULL,
    data_transacao DATE NOT NULL,
	FOREIGN KEY (id_categoria) REFERENCES categoria(id),    
	FOREIGN KEY (id_origem) REFERENCES origem(id)
);

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome varchar(50) NOT NULL,
	senha varchar(16)
);

CREATE TABLE patrimonio (
    id_transacao INT PRIMARY KEY,
    saldo DECIMAL(10,2) NOT NULL,
	FOREIGN KEY (id_transacao) REFERENCES transacao(id)
);

CREATE TABLE categoria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE origem (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

SELECT transacao.id, transacao.data_transacao, transacao.tipo, transacao.valor, categoria.nome AS nome_categoria, origem.nome AS nome_origem 
FROM transacao
INNER JOIN categoria ON transacao.id_categoria = categoria.id
INNER JOIN origem ON transacao.id_origem = origem.id;

SELECT transacao.id, transacao.data_transacao, transacao.valor, patrimonio.saldo AS saldo_apos_transacao
FROM transacao
INNER JOIN patrimonio ON transacao.id = patrimonio.id_transacao
WHERE transacao.tipo = 'receita'; 

