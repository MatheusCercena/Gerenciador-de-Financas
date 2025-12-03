CREATE DATABASE financas;

CREATE TABLE categoria (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE origem (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE transacao (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo ENUM('RECEITA', 'DESPESA') NOT NULL,
    id_categoria INT,
    id_origem INT,
    valor DECIMAL(10,2) NOT NULL,
    data_transacao DATE NOT NULL,
    observacoes varchar(200),
	FOREIGN KEY (id_categoria) REFERENCES categoria(id),    
	FOREIGN KEY (id_origem) REFERENCES origem(id)
);

insert into categoria(nome) values("Teste");
insert into origem(nome) values("TesteOrigem");

INSERT INTO origem (nome) VALUES 
("Conta Corrente (CC)"),
("Cartão de Crédito"),
("PIX/Transferência"),
("Cesta de Ações"),
("Emprego Principal");

INSERT INTO categoria (nome) VALUES 
("Salário"),
("Aluguel/Moradia"),
("Alimentação"),
("Transporte"),
("Lazer"),
("Investimentos"),
("Saúde"),
("Educação"),
("Serviços Públicos"),
("Renda Extra");

INSERT INTO transacao (tipo, id_categoria, id_origem, valor, data_transacao, observacoes) VALUES
('RECEITA', 1, 5, 4500.00, '2025-01-05', 'Salário Mensal - Janeiro'),
('RECEITA', 1, 5, 4500.00, '2025-02-05', 'Salário Mensal - Fevereiro'),
('RECEITA', 10, 3, 350.00, '2025-02-15', 'Freelance de design'),
('RECEITA', 1, 5, 4500.00, '2025-03-05', 'Salário Mensal - Março'),
('RECEITA', 6, 4, 120.50, '2025-03-22', 'Dividendos de Ações'),
('RECEITA', 1, 5, 4500.00, '2025-04-05', 'Salário Mensal - Abril'),
('RECEITA', 1, 5, 4500.00, '2025-05-05', 'Salário Mensal - Maio'),
('RECEITA', 10, 3, 50.00, '2025-05-18', 'Reembolso de amigo'),
('RECEITA', 1, 5, 4500.00, '2025-06-05', 'Salário Mensal - Junho'),
('RECEITA', 1, 5, 4500.00, '2025-07-05', 'Salário Mensal - Julho'),
('RECEITA', 6, 4, 180.75, '2025-08-10', 'Venda de Fundo Imobiliário'),
('RECEITA', 1, 5, 4500.00, '2025-08-05', 'Salário Mensal - Agosto'),
('RECEITA', 1, 5, 4500.00, '2025-09-05', 'Salário Mensal - Setembro'),
('RECEITA', 10, 3, 200.00, '2025-10-14', 'Venda de item usado'),
('RECEITA', 1, 5, 4500.00, '2025-10-05', 'Salário Mensal - Outubro'),
('RECEITA', 1, 5, 4500.00, '2025-11-05', 'Salário Mensal - Novembro'),
('RECEITA', 1, 5, 4500.00, '2025-12-05', 'Salário Mensal - Dezembro'),
('DESPESA', 2, 1, 1500.00, '2025-01-08', 'Aluguel - Vencimento fixo'),
('DESPESA', 9, 1, 180.50, '2025-01-15', 'Conta de Energia Elétrica'),
('DESPESA', 9, 1, 95.00, '2025-01-16', 'Conta de Água/Saneamento'),
('DESPESA', 2, 1, 1500.00, '2025-02-08', 'Aluguel - Fevereiro'),
('DESPESA', 9, 1, 160.00, '2025-02-15', 'Conta de Energia Elétrica'),
('DESPESA', 2, 1, 1500.00, '2025-03-08', 'Aluguel - Março'),
('DESPESA', 3, 2, 450.30, '2025-01-10', 'Compras de mercado do mês'),
('DESPESA', 4, 1, 180.00, '2025-01-20', 'Passe mensal de transporte público'),
('DESPESA', 5, 2, 85.00, '2025-01-25', 'Jantar fora com amigos'),
('DESPESA', 7, 3, 120.00, '2025-02-01', 'Consulta de rotina ao dentista'),
('DESPESA', 3, 2, 380.70, '2025-02-10', 'Compras de mercado do mês'),
('DESPESA', 4, 1, 180.00, '2025-02-20', 'Passe mensal de transporte'),
('DESPESA', 8, 2, 99.90, '2025-02-28', 'Mensalidade de curso online'),
('DESPESA', 5, 3, 35.00, '2025-03-01', 'Cinema e pipoca'),
('DESPESA', 3, 2, 420.00, '2025-03-10', 'Compras de mercado do mês'),
('DESPESA', 4, 1, 180.00, '2025-03-20', 'Passe mensal de transporte'),
('DESPESA', 7, 2, 50.00, '2025-03-25', 'Compra de medicamentos'),
('DESPESA', 5, 3, 60.00, '2025-04-01', 'Assinatura de streaming (Netflix/Spotify)'),
('DESPESA', 3, 2, 405.50, '2025-04-10', 'Compras de mercado do mês'),
('DESPESA', 6, 1, 500.00, '2025-04-15', 'Aporte mensal em fundo de investimento'),
('DESPESA', 4, 1, 180.00, '2025-04-20', 'Passe mensal de transporte'),
('DESPESA', 2, 1, 1500.00, '2025-04-08', 'Aluguel - Abril'),
('DESPESA', 3, 2, 390.00, '2025-05-10', 'Compras de mercado do mês'),
('DESPESA', 7, 3, 250.00, '2025-05-20', 'Fisioterapia'),
('DESPESA', 5, 2, 150.00, '2025-05-25', 'Ingresso para show'),
('DESPESA', 8, 2, 199.90, '2025-06-15', 'Renovação de licença de software'),
('DESPESA', 6, 1, 300.00, '2025-06-20', 'Compra de criptomoeda'),
('DESPESA', 3, 2, 410.20, '2025-07-10', 'Compras de mercado do mês'),
('DESPESA', 4, 1, 180.00, '2025-07-20', 'Passe mensal de transporte');



-- SELECT transacao.id, transacao.data_transacao, transacao.tipo, transacao.valor, categoria.nome AS nome_categoria, origem.nome AS nome_origem 
-- FROM transacao
-- INNER JOIN categoria ON transacao.id_categoria = categoria.id
-- INNER JOIN origem ON transacao.id_origem = origem.id;

-- SELECT transacao.id, transacao.data_transacao, transacao.valor, patrimonio.saldo AS saldo_apos_transacao
-- FROM transacao
-- INNER JOIN patrimonio ON transacao.id = patrimonio.id_transacao
-- WHERE transacao.tipo = 'receita'; 

