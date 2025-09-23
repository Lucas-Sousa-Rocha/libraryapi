-- AUTORES
INSERT INTO autor (id, nome, dt_nascimento, nacionalidade, dt_cadastro, dt_ultima_atualizacao)
VALUES
    ('f47ac10b-58cc-4372-a567-0e02b2c3d479', 'Gabriel García Márquez', '1927-03-06', 'Colombiano', NOW(), NOW()),
    ('c9bf9e57-1685-4c89-bafb-ff5af830be8a', 'Jane Austen', '1775-12-16', 'Britânica', NOW(), NOW()),
    ('1c6b147e-3e9c-4f3c-9f2e-2e9d9f3f8c91', 'J.K. Rowling', '1965-07-31', 'Britânica', NOW(), NOW()),
    ('a3bb189e-8bf9-3888-9912-ace4e6543002', 'Paulo Coelho', '1947-08-24', 'Brasileiro', NOW(), NOW()),
    ('d94f3f01-5b2b-4d23-9d6f-90c1f9e5f1e8', 'Isaac Asimov', '1920-01-02', 'Americano', NOW(), NOW()),
    ('2c4f0f27-9fef-44a1-bb5f-f8c17a1fbd2f', 'Haruki Murakami', '1949-01-12', 'Japonês', NOW(), NOW()),
    ('3fa85f64-5717-4562-b3fc-2c963f66afa6', 'Clarice Lispector', '1920-12-10', 'Brasileira', NOW(), NOW()),
    ('6fa459ea-ee8a-3ca4-894e-db77e160355e', 'George Orwell', '1903-06-25', 'Britânico', NOW(), NOW()),
    ('16fd2706-8baf-433b-82eb-8c7fada847da', 'Tolkien', '1892-01-03', 'Britânico', NOW(), NOW()),
    ('123e4567-e89b-12d3-a456-426614174000', 'Agatha Christie', '1890-09-15', 'Britânica', NOW(), NOW());

-- LIVROS
INSERT INTO livro (id, isbn, titulo, dt_publicacao, genero, preco, id_autor, dt_cadastro, dt_ultima_atualizacao)
VALUES
    ('c56a4180-65aa-42ec-a945-5fd21dec0538', '978-3-16-148410-0', 'Cem Anos de Solidão', '1967-06-05', 'FICCAO', 49.90, 'f47ac10b-58cc-4372-a567-0e02b2c3d479', NOW(), NOW()),
    ('c56a4180-65aa-42ec-a945-5fd21dec0539', '978-1-56619-909-4', 'Orgulho e Preconceito', '1813-01-28', 'ROMANCE', 39.90, 'c9bf9e57-1685-4c89-bafb-ff5af830be8a', NOW(), NOW()),
    ('c56a4180-65aa-42ec-a945-5fd21dec0540', '978-0-7475-3269-9', 'Harry Potter e a Pedra Filosofal', '1997-06-26', 'FANTASIA', 59.90, '1c6b147e-3e9c-4f3c-9f2e-2e9d9f3f8c91', NOW(), NOW()),
    ('c56a4180-65aa-42ec-a945-5fd21dec0541', '978-0-06-112241-5', 'O Alquimista', '1988-05-01', 'ROMANCE', 29.90, 'a3bb189e-8bf9-3888-9912-ace4e6543002', NOW(), NOW()),
    ('c56a4180-65aa-42ec-a945-5fd21dec0542', '978-0-553-80370-4', 'Fundação', '1951-06-01', 'CIENCIA', 69.90, 'd94f3f01-5b2b-4d23-9d6f-90c1f9e5f1e8', NOW(), NOW()),
    ('c56a4180-65aa-42ec-a945-5fd21dec0543', '978-0-14-303943-3', 'Kafka à Beira-Mar', '2002-09-12', 'FICCAO', 59.90, '2c4f0f27-9fef-44a1-bb5f-f8c17a1fbd2f', NOW(), NOW()),
    ('c56a4180-65aa-42ec-a945-5fd21dec0544', '978-85-359-0277-2', 'A Paixão Segundo G.H.', '1964-01-01', 'FICCAO', 49.90, '3fa85f64-5717-4562-b3fc-2c963f66afa6', NOW(), NOW()),
    ('c56a4180-65aa-42ec-a945-5fd21dec0545', '978-0-452-28423-4', '1984', '1949-06-08', 'MISTERIO', 39.90, '6fa459ea-ee8a-3ca4-894e-db77e160355e', NOW(), NOW()),
    ('c56a4180-65aa-42ec-a945-5fd21dec0546', '978-0-618-00222-8', 'O Senhor dos Anéis', '1954-07-29', 'FANTASIA', 99.90, '16fd2706-8baf-433b-82eb-8c7fada847da', NOW(), NOW()),
    ('c56a4180-65aa-42ec-a945-5fd21dec0547', '978-0-06-207348-8', 'Assassinato no Expresso do Oriente', '1934-01-01', 'MISTERIO', 39.90, '123e4567-e89b-12d3-a456-426614174000', NOW(), NOW());
