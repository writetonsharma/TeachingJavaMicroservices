-- insert 20 courses
use coursedb;
insert into course (c_id, c_name, c_credit) values
('c101', 'data structures', 3),
('c102', 'database systems', 4),
('c103', 'operating systems', 3),
('c104', 'computer networks', 3),
('c105', 'software engineering', 4),
('c106', 'web development', 3),
('c107', 'machine learning', 4),
('c108', 'artificial intelligence', 4),
('c109', 'java', 3),
('c110', 'microservices in java', 4),
('c111', 'spring boot', 3),
('c112', 'cloud computing', 4),
('c113', 'big data', 4),
('c114', 'cyber security', 3),
('c115', 'mobile app development', 3),
('c116', 'devops practices', 4),
('c117', 'agile methodologies', 3),
('c118', 'data science', 4),
('c119', 'blockchain technology', 3),
('c120', 'internet of things (iot)', 4);

-- Every student is taking 4 courses
use enrollmentdb;
insert into enrollment (s_id, c_id) values
('S101', 'C101'), ('S101', 'C102'), ('S101', 'C103'), ('S101', 'C104'),
('S102', 'C105'), ('S102', 'C106'), ('S102', 'C107'), ('S102', 'C108'),
('S103', 'C109'), ('S103', 'C110'), ('S103', 'C111'), ('S103', 'C112'),
('S104', 'C113'), ('S104', 'C114'), ('S104', 'C115'), ('S104', 'C116'),
('S105', 'C117'), ('S105', 'C118'), ('S105', 'C119'), ('S105', 'C120'),
('S106', 'C101'), ('S106', 'C102'), ('S106', 'C103'), ('S106', 'C104'),
('S107', 'C105'), ('S107', 'C106'), ('S107', 'C107'), ('S107', 'C108'),
('S108', 'C109'), ('S108', 'C110'), ('S108', 'C111'), ('S108', 'C112'),
('S109', 'C113'), ('S109', 'C114'), ('S109', 'C115'), ('S109', 'C116'),
('S110', 'C117'), ('S110', 'C118'), ('S110', 'C119'), ('S110', 'C120'),
('S111', 'C101'), ('S111', 'C102'), ('S111', 'C103'), ('S111', 'C104'),
('S112', 'C105'), ('S112', 'C106'), ('S112', 'C107'), ('S112', 'C108'),
('S113', 'C109'), ('S113', 'C110'), ('S113', 'C111'), ('S113', 'C112'),
('S114', 'C113'), ('S114', 'C114'), ('S114', 'C115'), ('S114', 'C116'),
('S115', 'C117'), ('S115', 'C118'), ('S115', 'C119'), ('S115', 'C120'),
('S116', 'C101'), ('S116', 'C102'), ('S116', 'C103'), ('S116', 'C104'),
('S117', 'C105'), ('S117', 'C106'), ('S117', 'C107'), ('S117', 'C108'),
('S118', 'C109'), ('S118', 'C110'), ('S118', 'C111'), ('S118', 'C112');

-- There are 18 students
use studentdb;
insert into student (s_rollnumber, s_name, s_year, s_email) values
('S101', 'alice smith', 2021, 'Alice2021@ncuindia.edu'),
('S102', 'bob johnson', 2022, 'Bob2022@ncuindia.edu'),
('S103', 'charlie brown', 2023, 'Charlie2023@ncuindia.edu'),
('S104', 'diana prince', 2021, 'Diana2021@ncuindia.edu'),
('S105', 'ethan hunt', 2022, 'Ethan2022@ncuindia.edu'),
('S106', 'fiona gallagher', 2023, 'Fiona2023@ncuindia.edu'),
('S107', 'george costanza', 2021, 'George2021@ncuindia.edu'),
('S108', 'hannah montana', 2022, 'Hannah2022@ncuindia.edu'),
('S109', 'ian malcolm', 2023, 'Ian2023@ncuindia.edu'),
('S110', 'jenna ortega', 2021, 'Jenna2021@ncuindia.edu'),
('S111', 'kevin hart', 2022, 'Kevin2022@ncuindia.edu'),
('S112', 'liam neeson', 2023, 'Liam2023@ncuindia.edu'),
('S113', 'megan fox', 2021, 'Megan2021@ncuindia.edu'),
('S114', 'nicolas cage', 2022, 'Nicolas2022@ncuindia.edu'),
('S115', 'olivia wilde', 2023, 'Olivia2023@ncuindia.edu'),
('S116', 'paul rudd', 2021, 'Paul2021@ncuindia.edu'),
('S117', 'quentin tarantino', 2022, 'Quentin2022@ncuindia.edu'),
('S118', 'rihanna', 2023, 'Rihanna2023@ncuindia.edu');

-- There are 13 teachers
insert into teacher (t_id, t_name, t_email) values
('T101', 'Dr. John Doe', 'Johnt101@ncuindia.edu'),
('T102', 'Prof. Jane Smith', 'Janet102@ncuindia.edu'),
('T103', 'Dr. Emily Johnson', 'EmilyT103@ncuindia.edu'),
('T104', 'Prof. Michael Brown', 'Miket104@ncuindia.edu'),
('T105', 'Dr. Sarah Davis', 'Saraht105@ncuindia.edu'),
('T106', 'Prof. David Wilson', 'Davet106@ncuindia.edu'),
('T107', 'Dr. Laura Garcia', 'Laurat107@ncuindia.edu'),
('T108', 'Prof. James Martinez', 'Jamest108@ncuindia.edu'),
('T109', 'Dr. Patricia Rodriguez', 'Patt109@ncuindia.edu'),
('T110', 'Prof. Robert Lee', 'Robt110@ncuindia.edu'),
('T111', 'Dr. Linda Walker', 'Lindat111@ncuindia.edu'),
('T112', 'Prof. William Hall', 'Willt112@ncuindia.edu'),
('T113', 'Dr. Barbara Allen', 'Barbt113@ncuindia.edu');

insert into users (u_name, u_email, u_password) values
('naveen', 'naveen@gmail.com', 'test');
