CREATE TABLE IF NOT EXISTS categorias (
    id_categoria SERIAL PRIMARY KEY,
    nome_categoria VARCHAR(100) NOT NULL UNIQUE,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS fornecedores (
    id_fornecedor SERIAL PRIMARY KEY,
    nome_fornecedor VARCHAR(120) NOT NULL UNIQUE,
    cnpj_fornecedor VARCHAR(14) NOT NULL UNIQUE,
    endereco_fornecedor VARCHAR(300) NOT NULL,
    telefone_fornecedor VARCHAR(15) NOT NULL,
    email_fornecedor VARCHAR(100) NOT NULL UNIQUE,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status_fornecedor BOOLEAN NOT NULL DEFAULT TRUE,
    uf_fornecedor VARCHAR(2) NOT NULL,
    cidade_fornecedor VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS produtos (
    id_produto SERIAL PRIMARY KEY,
    id_categoria INT NOT NULL,
    id_fornecedor INT NOT NULL,
    nome_produto VARCHAR(200) NOT NULL,
    sku_produto VARCHAR(100) NOT NULL UNIQUE,
    descricao_produto VARCHAR(500) NOT NULL,
    preco_produto DECIMAL(10,2) NOT NULL,
    quantidade_estoque INT NOT NULL,
    status_produto BOOLEAN NOT NULL DEFAULT TRUE,
    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria),
    FOREIGN KEY (id_fornecedor) REFERENCES fornecedores(id_fornecedor)
);