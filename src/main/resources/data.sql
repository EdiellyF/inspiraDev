INSERT  INTO tb_roles(role_id, name) values (1, 'admin') ON CONFLICT(role_id) DO NOTHING;
INSERT  INTO tb_roles(role_id, name) values (2, 'basic') ON CONFLICT(role_id) DO NOTHING;