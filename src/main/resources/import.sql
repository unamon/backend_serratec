INSERT INTO categoria (nome_txt_categoria, desc_txt_categoria) VALUES ('informatica','materiais eletronicos');
INSERT INTO categoria (nome_txt_categoria, desc_txt_categoria) VALUES ('Eletronicos', 'Todos os materiais eletronicos');
INSERT INTO categoria (nome_txt_categoria, desc_txt_categoria) VALUES ('Mobiliarios', 'Todos os materiais de mobiliarios');
INSERT INTO categoria (nome_txt_categoria, desc_txt_categoria) VALUES ('Outros', 'Todos os materiais diferentes de eletronico e mobilia');

INSERT INTO endereco (end_txt_cep, end_txt_rua, end_txt_bairro, end_txt_cidade, end_txt_nr, end_txt_comp, end_txt_uf) VALUES ('25660-313', 'Rua Manoel Torres', 'Bingen', 'Petropolis', '688', 'Próximo ao unico orelhão', 'RJ');
INSERT INTO endereco (end_txt_cep, end_txt_rua, end_txt_bairro, end_txt_cidade, end_txt_nr, end_txt_comp, end_txt_uf) VALUES ('25660-060', 'Rua São Sebastião', 'São Sebastião', 'Petropolis', '5079', 'Depois do BNH', 'RJ');
INSERT INTO endereco (end_txt_cep, end_txt_rua, end_txt_bairro, end_txt_cidade, end_txt_nr, end_txt_comp, end_txt_uf) VALUES ('25660-003', 'Rua Bingen', 'Bingen', 'Petropolis', '51', 'Antes do deposito de gás ULTRAGAZ', 'RJ');
INSERT INTO endereco (end_txt_cep, end_txt_rua, end_txt_bairro, end_txt_cidade, end_txt_nr, end_txt_comp, end_txt_uf) VALUES ('25660-573', 'Av Barão do Rio Branco', 'Centro', 'Petropolis', '890P', 'Depois do SAMU', 'RJ');
INSERT INTO endereco (end_txt_cep, end_txt_rua, end_txt_bairro, end_txt_cidade, end_txt_nr, end_txt_comp, end_txt_uf) VALUES ('25660-119', 'Est União Indústria', 'Correas', 'Petropolis', '1028C', 'Antes do Condominio Palmeiras', 'RJ');

INSERT INTO perfil (nome_txt_perfil) VALUES ('ADMINISTRADOR');
INSERT INTO perfil (nome_txt_perfil) VALUES ('ALUNO');
INSERT INTO perfil (nome_txt_perfil) VALUES ('PARCEIRO');
INSERT INTO perfil (nome_txt_perfil) VALUES ('MANUTENCIONISTA');

INSERT INTO pessoa (tipo_pessoa, nome_txt_pessoa, email_txt_pessoa, senha_txt_pessoa, tel_txt_pessoa, cpf_txt_pessoaf, cargo_txt_pessoaJ, cnpj_txt_pessoaJ, nome_fant_txt_pessoaJ, razao_social_txt_pessoaJ, id_int_end, id_int_perfil) VALUES ('F', 'Silvana', 'silvana@serratec.com.br', '$2a$12$GAozphf8O2QDEC16P3nICOxH4NXmBk4aqXwn252kEFVpNoYlHXM6O', '12345678901','12345678910', '', '', '', '', 2, 1);
INSERT INTO pessoa (tipo_pessoa, nome_txt_pessoa, email_txt_pessoa, senha_txt_pessoa, tel_txt_pessoa, cpf_txt_pessoaf, cargo_txt_pessoaJ, cnpj_txt_pessoaJ, nome_fant_txt_pessoaJ, razao_social_txt_pessoaJ, id_int_end, id_int_perfil) VALUES ('F', 'Ceil', 'ceil@serratec.com.br', '$2a$12$GAozphf8O2QDEC16P3nICOxH4NXmBk4aqXwn252kEFVpNoYlHXM6O', '23456789011','23456789101', '', '', '', '', 1, 2);
INSERT INTO pessoa (tipo_pessoa, nome_txt_pessoa, email_txt_pessoa, senha_txt_pessoa, tel_txt_pessoa, cpf_txt_pessoaf, cargo_txt_pessoaJ, cnpj_txt_pessoaJ, nome_fant_txt_pessoaJ, razao_social_txt_pessoaJ, id_int_end, id_int_perfil) VALUES ('J', 'Bernardo', 'bernardo@serratec.com.br', '$2a$12$GAozphf8O2QDEC16P3nICOxH4NXmBk4aqXwn252kEFVpNoYlHXM6O', '34567890112','34567891012', 'Gerente', '12345678910123', 'TecnoProg', 'Bernards Tecnologia LTDA', 5, 3);
INSERT INTO pessoa (tipo_pessoa, nome_txt_pessoa, email_txt_pessoa, senha_txt_pessoa, tel_txt_pessoa, cpf_txt_pessoaf, cargo_txt_pessoaJ, cnpj_txt_pessoaJ, nome_fant_txt_pessoaJ, razao_social_txt_pessoaJ, id_int_end, id_int_perfil) VALUES ('J', 'Leonardo', 'leonardo@serratec.com.br', '$2a$12$GAozphf8O2QDEC16P3nICOxH4NXmBk4aqXwn252kEFVpNoYlHXM6O', '45678901123','45678910123', 'Desenvolvedor', '23456789101231', 'DesenTechPop', 'Suporte e Desenvolvimento SA', 3, 4);
INSERT INTO pessoa (tipo_pessoa, nome_txt_pessoa, email_txt_pessoa, senha_txt_pessoa, tel_txt_pessoa, cpf_txt_pessoaf, cargo_txt_pessoaJ, cnpj_txt_pessoaJ, nome_fant_txt_pessoaJ, razao_social_txt_pessoaJ, id_int_end, id_int_perfil) VALUES ('F', 'Matheus', 'matheus@serratec.com.br', '$2a$12$GAozphf8O2QDEC16P3nICOxH4NXmBk4aqXwn252kEFVpNoYlHXM6O', '56789011234','56789101234', '', '', '', '', 2, 2);
INSERT INTO pessoa (tipo_pessoa, nome_txt_pessoa, email_txt_pessoa, senha_txt_pessoa, tel_txt_pessoa, cpf_txt_pessoaf, cargo_txt_pessoaJ, cnpj_txt_pessoaJ, nome_fant_txt_pessoaJ, razao_social_txt_pessoaJ, id_int_end, id_int_perfil) VALUES ('F', 'Paulo', 'paulo@serratec.com.br', '$2a$12$GAozphf8O2QDEC16P3nICOxH4NXmBk4aqXwn252kEFVpNoYlHXM6O', '67890112345','67891012345', '', '', '', '', 4, 2);

INSERT INTO material (nome_txt_material, num_serie_txt_material, desc_txt_material, data_devol_dt_origem, data_ent_dt_origem, tipo_origem, id_int_categoria, id_int_pessoa) VALUES ('Notebook', '658A75BT5190QP5', 'Notebook HP Intel i5 4GB RAM Windows 10', '2022-12-15 21:02:10.376', '2022-12-15 21:02:10.376', 'ALUGUEL', 1, 2);
INSERT INTO material (nome_txt_material, num_serie_txt_material, desc_txt_material, data_devol_dt_origem, data_ent_dt_origem, tipo_origem, id_int_categoria, id_int_pessoa) VALUES ('Desktop', '123A75BT5190QP5', 'Desktop Dell Intel i7 8GB RAM Windows 11', '2022-12-15 21:02:10.376', '2022-12-15 21:02:10.376', 'DOACAO', 2, 5);
INSERT INTO material (nome_txt_material, num_serie_txt_material, desc_txt_material, data_devol_dt_origem, data_ent_dt_origem, tipo_origem, id_int_categoria, id_int_pessoa) VALUES ('Monitor', '852A75BT5190QP5', 'Monitor Positivo 17,5" HD', '2022-12-15 21:02:10.376', '2022-12-15 21:02:10.376', 'EMPRESTIMO', 3, 4);
INSERT INTO material (nome_txt_material, num_serie_txt_material, desc_txt_material, data_devol_dt_origem, data_ent_dt_origem, tipo_origem, id_int_categoria, id_int_pessoa) VALUES ('Cadeira', '', 'Cadeira com braços giratória tipo escritório', '2022-12-15 21:02:10.376', '2022-12-15 21:02:10.376', 'AQUISICAO', 1, 1);
INSERT INTO material (nome_txt_material, num_serie_txt_material, desc_txt_material, data_devol_dt_origem, data_ent_dt_origem, tipo_origem, id_int_categoria, id_int_pessoa) VALUES ('Mesa', '', 'Mesa tipo escritório medindo 1,60m X 2,10m', '2022-12-15 21:02:10.376', '2022-12-15 21:02:10.376', 'DOACAO', 2, 3);

INSERT INTO status (boolativo, nome_txt_status, desc_txt_status) VALUES ('true', 'Disponível', 'Material está em nosso estoque');
INSERT INTO status (boolativo, nome_txt_status, desc_txt_status) VALUES ('true', 'Empréstimo', 'Material está emprestado com aluno ou parceiro');
INSERT INTO status (boolativo, nome_txt_status, desc_txt_status) VALUES ('true', 'Manutenção', 'Material está em manutenção');
INSERT INTO status (boolativo, nome_txt_status, desc_txt_status) VALUES ('true', 'Indisponível', 'Material não tem reparo e está aguardando baixa');

INSERT INTO historico (data_hist, obs_txt_hist, id_int_material, id_int_pessoa, id_int_status) VALUES ('2022-12-12 12:02:10.376', 'Material incluído no estoque.', 1, 2, 1);
INSERT INTO historico (data_hist, obs_txt_hist, id_int_material, id_int_pessoa, id_int_status) VALUES ('2022-12-12 12:02:10.376', 'Material incluído no estoque.', 2, 3, 1);
INSERT INTO historico (data_hist, obs_txt_hist, id_int_material, id_int_pessoa, id_int_status) VALUES ('2022-12-12 12:02:10.376', 'Material incluído no estoque.', 3, 1, 1);
INSERT INTO historico (data_hist, obs_txt_hist, id_int_material, id_int_pessoa, id_int_status) VALUES ('2022-12-12 12:02:10.376', 'Material incluído no estoque.', 4, 2, 1);
INSERT INTO historico (data_hist, obs_txt_hist, id_int_material, id_int_pessoa, id_int_status) VALUES ('2022-12-12 12:02:10.376', 'Material incluído no estoque.', 5, 4, 1);
INSERT INTO historico (data_hist, obs_txt_hist, id_int_material, id_int_pessoa, id_int_status) VALUES ('2022-12-14 15:02:10.376', 'Material emprestado ao aluno.', 1, 5, 2);
INSERT INTO historico (data_hist, obs_txt_hist, id_int_material, id_int_pessoa, id_int_status) VALUES ('2022-12-15 17:02:10.376', 'Material emprestado ao aluno.', 2, 6, 2);
INSERT INTO historico (data_hist, obs_txt_hist, id_int_material, id_int_pessoa, id_int_status) VALUES ('2022-12-15 17:02:10.376', 'Material emprestado ao aluno.', 3, 6, 2);
INSERT INTO historico (data_hist, obs_txt_hist, id_int_material, id_int_pessoa, id_int_status) VALUES ('2022-12-16 10:02:10.376', 'Material enviado para manutenção.', 5, 4, 3);

