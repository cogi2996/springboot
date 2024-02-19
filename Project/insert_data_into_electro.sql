use  electro
-- insert user
INSERT INTO `User` (user_id, phone, create_date, first_name, last_name, address, major, department)
VALUES ('user123', '0987654321', NOW(), 'Nguyễn Văn', 'A', 'Hà Nội', 'Khoa học máy tính', 'Công nghệ thông tin');

INSERT INTO `User` (user_id, phone, create_date, first_name, last_name, address, biography, major, department, role)
VALUES ('user456', '0123456789', NOW(), 'Trần Thị', 'B', 'Đà Nẵng', 'Tôi là một sinh viên chuyên ngành marketing.', 'Marketing', 'Quản trị kinh doanh', 1);

INSERT INTO `User` (user_id, phone, create_date, first_name, mid_name, last_name, address, major, department)
VALUES ('user789', '0912345678', NOW(), 'Lê Thị', 'Thị', 'C', 'Hồ Chí Minh', 'Thiết kế đồ họa', 'Nghệ thuật');
