INSERT INTO diploma.company (company_id, name, site_url, size) VALUES (1, 'Robot Morning', 'https://www.robotmorning.com/', '2500');
INSERT INTO diploma.company (company_id, name, site_url, size) VALUES (2, 'Impossible Foods', 'http://impossiblefoods.com/', '4000');
INSERT INTO diploma.company (company_id, name, site_url, size) VALUES (3, 'Tempest', 'https://www.jointempest.com/', '1500');
INSERT INTO diploma.company (company_id, name, site_url, size) VALUES (4, 'Het CAK', 'https://werkenbijhetcat.nl', '3000');
INSERT INTO diploma.company (company_id, name, site_url, size) VALUES (5, 'Ascension', 'https://jobs.ascension.org/', '5000');


INSERT INTO diploma.contact (contact_id, email, first_name, last_name, phone, companies_contact) VALUES (1, 'Lacy_Conroy@gmail.com', 'Lacy', 'Conroy', '123647899', 1);
INSERT INTO diploma.contact (contact_id, email, first_name, last_name, phone, companies_contact) VALUES (2, 'Ellesse_Redman@gmail.com', 'Ellesse', 'Redman', '321445566', 2);
INSERT INTO diploma.contact (contact_id, email, first_name, last_name, phone, companies_contact) VALUES (3, 'Darcie_Drew@gmail.com', 'Darcie', 'Drew', '879808343', 3);
INSERT INTO diploma.contact (contact_id, email, first_name, last_name, phone, companies_contact) VALUES (4, 'Lianne_Hicks@gmail.com', 'Lianne', 'Hicks', '436827345', 4);
INSERT INTO diploma.contact (contact_id, email, first_name, last_name, phone, companies_contact) VALUES (5, 'Mylo_Mata@gmail.com', 'Mylo', 'Mata', '374823746', 5);
INSERT INTO diploma.contact (contact_id, email, first_name, last_name, phone, companies_contact) VALUES (6, 'Darren_Wyatt@gmail.com', 'Darren', 'Wyatt', '378429187', 1);
INSERT INTO diploma.contact (contact_id, email, first_name, last_name, phone, companies_contact) VALUES (7, 'Kien_Mcfarland@gmail.com', 'Kien', 'Mcfarland', '237846237', 2);
INSERT INTO diploma.contact (contact_id, email, first_name, last_name, phone, companies_contact) VALUES (8, 'Ayyub_Amin@gmail.com', 'Ayyub', 'Amin', '897209203', 3);
INSERT INTO diploma.contact (contact_id, email, first_name, last_name, phone, companies_contact) VALUES (9, 'Bryan_Sheehan@gmail.com', 'Bryan', 'Sheehan', '381764324', 4);
INSERT INTO diploma.contact (contact_id, email, first_name, last_name, phone, companies_contact) VALUES (10, 'Kaylen_Drake@gmail.com', 'Kaylen', 'Drake', '082138344', 5);


INSERT INTO diploma.location (location_id, name, image_path) VALUES (1, 'Remote', '/static/img/location_default.png');
INSERT INTO diploma.location (location_id, name, image_path) VALUES (2, 'New York', '/static/img/location_default.png');
INSERT INTO diploma.location (location_id, name, image_path) VALUES (3, 'Den Haag', '/static/img/location_default.png');
INSERT INTO diploma.location (location_id, name, image_path) VALUES (4, 'Dordrecht', '/static/img/location_default.png');
INSERT INTO diploma.location (location_id, name, image_path) VALUES (5, 'Cincinnati', '/static/img/location_default.png');
INSERT INTO diploma.location (location_id, name, image_path) VALUES (6, 'Chicago, IL', '/static/img/location_default.png');
INSERT INTO diploma.location (location_id, name, image_path) VALUES (7, 'Austin, TX', '/static/img/location_default.png');
INSERT INTO diploma.location (location_id, name, image_path) VALUES (8, 'Cambridge', '/static/img/location_default.png');
INSERT INTO diploma.location (location_id, name, image_path) VALUES (9, 'Portland, Maine', '/static/img/location_default.png');
INSERT INTO diploma.location (location_id, name, image_path) VALUES (10, 'Berlin', '/static/img/location_default.png');


INSERT INTO diploma.user (user_id, full_name, email, password, phone, active) VALUES (1, 'Darcie Wagner', 'Darcie_Wagner@gmail.com', 'dw1234', '234548865', true);
INSERT INTO diploma.user (user_id, full_name, email, password, phone, active) VALUES (2, 'Cassidy Howe', 'Cassidy_Howe@gmail.com', 'ch1234', '350234504', true);
INSERT INTO diploma.user (user_id, full_name, email, password, phone, active) VALUES (3, 'Ansh Corona', 'Ansh_Corona', 'ac1234', '324265065', true);
INSERT INTO diploma.user (user_id, full_name, email, password, phone, active) VALUES (4, 'Elen Smart', 'Elen_Smart@gmail.com', 'es1234', '234324523', true);
INSERT INTO diploma.user (user_id, full_name, email, password, phone, active) VALUES (5, 'Thalia Ballard', 'Thalia_Ballard@gmail.com', 'tb1234', '234234534', true);
INSERT INTO diploma.user (user_id, full_name, email, password, phone, active) VALUES (6, 'Morwenna King', 'Morwenna_King@gmail.com', 'mk1234', '123141242', false);
INSERT INTO diploma.user (user_id, full_name, email, password, phone, active) VALUES (7, 'Roshan Frey', 'Roshan_Frey@gmail.com', 'rf1234', '235086341', false);
INSERT INTO diploma.user (user_id, full_name, email, password, phone, active) VALUES (8, 'Roberta Schaefer', 'Roberta_Schaefer@gmail.com', 'rs1234', '234523467', false);
INSERT INTO diploma.user (user_id, full_name, email, password, phone, active) VALUES (9, 'Shelley Harding', 'Shelley_Harding', 'sh1234', '456485894', false);
INSERT INTO diploma.user (user_id, full_name, email, password, phone, active) VALUES (10, 'Taybah House', 'Taybah_House@gmail.com', 'th1234', '083474234', false);


INSERT INTO diploma.cv (cv_id, title, file_path, users_cv) VALUES (1, 'Junior Java Developer', '/static/cv_default.pdf', 1);
INSERT INTO diploma.cv (cv_id, title, file_path, users_cv) VALUES (2, 'Front-end Developer', '/static/cv_default.pdf', 2);
INSERT INTO diploma.cv (cv_id, title, file_path, users_cv) VALUES (3, 'ML Engineer', '/static/cv_default.pdf', 3);
INSERT INTO diploma.cv (cv_id, title, file_path, users_cv) VALUES (4, 'Senior Back-end Developer', '/static/cv_default.pdf', 4);
INSERT INTO diploma.cv (cv_id, title, file_path, users_cv) VALUES (5, 'JavaScript Developer', '/static/cv_default.pdf', 5);
INSERT INTO diploma.cv (cv_id, title, file_path, users_cv) VALUES (6, 'Full-stack Developer', '/static/cv_default.pdf', 6);
INSERT INTO diploma.cv (cv_id, title, file_path, users_cv) VALUES (7, 'Unity Developer', '/static/cv_default.pdf', 7);
INSERT INTO diploma.cv (cv_id, title, file_path, users_cv) VALUES (8, 'Python Developer', '/static/cv_default.pdf', 8);
INSERT INTO diploma.cv (cv_id, title, file_path, users_cv) VALUES (9, 'Network Architect', '/static/cv_default.pdf', 9);
INSERT INTO diploma.cv (cv_id, title, file_path, users_cv) VALUES (10, 'DevOps', '/static/cv_default.pdf', 10);



INSERT INTO diploma.skill (skill_id, name) VALUES (1, 'Java');
INSERT INTO diploma.skill (skill_id, name) VALUES (2, 'Java EE');
INSERT INTO diploma.skill (skill_id, name) VALUES (3, 'Spring');
INSERT INTO diploma.skill (skill_id, name) VALUES (4, 'Hibernate ORM');
INSERT INTO diploma.skill (skill_id, name) VALUES (5, 'Unit Testing');
INSERT INTO diploma.skill (skill_id, name) VALUES (6, 'JavaScript');
INSERT INTO diploma.skill (skill_id, name) VALUES (7, 'HTML');
INSERT INTO diploma.skill (skill_id, name) VALUES (8, 'CSS');
INSERT INTO diploma.skill (skill_id, name) VALUES (9, 'Git');
INSERT INTO diploma.skill (skill_id, name) VALUES (10, 'XML');
INSERT INTO diploma.skill (skill_id, name) VALUES (11, 'MySQL');
INSERT INTO diploma.skill (skill_id, name) VALUES (12, 'Docker');
INSERT INTO diploma.skill (skill_id, name) VALUES (13, 'SASS');
INSERT INTO diploma.skill (skill_id, name) VALUES (14, 'Angular');
INSERT INTO diploma.skill (skill_id, name) VALUES (15, 'Reactjs');
INSERT INTO diploma.skill (skill_id, name) VALUES (16, 'ReactNative');
INSERT INTO diploma.skill (skill_id, name) VALUES (17, 'Angularjs');
INSERT INTO diploma.skill (skill_id, name) VALUES (18, 'Nodejs');
INSERT INTO diploma.skill (skill_id, name) VALUES (19, 'Express');
INSERT INTO diploma.skill (skill_id, name) VALUES (20, 'Python');
INSERT INTO diploma.skill (skill_id, name) VALUES (21, 'Machine Learning');
INSERT INTO diploma.skill (skill_id, name) VALUES (22, 'Data Analytics');


INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (1, 1);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (1, 2);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (1, 3);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (1, 4);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (1, 5);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (1, 9);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (2, 6);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (2, 7);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (2, 8);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (2, 9);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (3, 20);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (3, 21);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (3, 10);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (2, 17);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (2, 14);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (4, 6);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (4, 7);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (4, 8);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (4, 9);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (4, 15);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (4, 16);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (4, 18);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (4, 19);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (4, 11);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (5, 6);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (5, 7);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (5, 8);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (5, 9);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (5, 13);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (5, 14);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (5, 15);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (5, 16);
INSERT INTO diploma.skills_for_cv (cv_id, skill_id) VALUES (5, 17);


INSERT INTO diploma.job (job_id, description, post_date, title, companies_job, job_location) VALUES (1, 'description for Midlle Java Developer', '2020-01-15', 'Midlle Java Developer', 1, 1);
INSERT INTO diploma.job (job_id, description, post_date, title, companies_job, job_location) VALUES (2, 'description for Front-end Developer', '2020-01-15', 'Front-end Developer', 2, 2);
INSERT INTO diploma.job (job_id, description, post_date, title, companies_job, job_location) VALUES (3, 'description for Python Developer', '2020-01-15', 'Python Developer', 3, 3);
INSERT INTO diploma.job (job_id, description, post_date, title, companies_job, job_location) VALUES (4, 'description for Senior Front-end Developer', '2020-01-15', 'Senior Front-end Developer', 4, 4);
INSERT INTO diploma.job (job_id, description, post_date, title, companies_job, job_location) VALUES (5, 'description for Juniour Java Developer', '2020-01-15', 'Junior Java Developer', 5, 5);


INSERT INTO diploma.skills_for_job (job_id, skill_id) VALUES (1, 1);
INSERT INTO diploma.skills_for_job (job_id, skill_id) VALUES (1, 2);
INSERT INTO diploma.skills_for_job (job_id, skill_id) VALUES (2, 3);
INSERT INTO diploma.skills_for_job (job_id, skill_id) VALUES (2, 4);
INSERT INTO diploma.skills_for_job (job_id, skill_id) VALUES (3, 5);
INSERT INTO diploma.skills_for_job (job_id, skill_id) VALUES (3, 6);
INSERT INTO diploma.skills_for_job (job_id, skill_id) VALUES (4, 7);
INSERT INTO diploma.skills_for_job (job_id, skill_id) VALUES (4, 8);
INSERT INTO diploma.skills_for_job (job_id, skill_id) VALUES (5, 9);
INSERT INTO diploma.skills_for_job (job_id, skill_id) VALUES (5, 10);
INSERT INTO diploma.skills_for_job (job_id, skill_id) VALUES (1, 11);
INSERT INTO diploma.skills_for_job (job_id, skill_id) VALUES (2, 12);
INSERT INTO diploma.skills_for_job (job_id, skill_id) VALUES (3, 13);
INSERT INTO diploma.skills_for_job (job_id, skill_id) VALUES (4, 14);
INSERT INTO diploma.skills_for_job (job_id, skill_id) VALUES (5, 15);
INSERT INTO diploma.skills_for_job (job_id, skill_id) VALUES (1, 16);
INSERT INTO diploma.skills_for_job (job_id, skill_id) VALUES (2, 17);
