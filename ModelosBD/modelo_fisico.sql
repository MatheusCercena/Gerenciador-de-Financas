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

