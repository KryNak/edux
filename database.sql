-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2020-08-04 08:36:22.798

-- tables
-- Table: answer
CREATE TABLE answer (
    id_answer bigint  NOT NULL,
    answer_contend text  NOT NULL,
    is_truth boolean  NOT NULL,
    id_question bigint  NOT NULL,
    CONSTRAINT answer_pk PRIMARY KEY (id_answer)
);

-- Table: person
CREATE TABLE person (
    id_person bigint  NOT NULL,
    first_name text  NOT NULL,
    last_name text  NOT NULL,
    CONSTRAINT person_pk PRIMARY KEY (id_person)
);

-- Table: question
CREATE TABLE question (
    id_question bigint  NOT NULL,
    question_content text  NOT NULL,
    id_subject bigint  NOT NULL,
    CONSTRAINT question_pk PRIMARY KEY (id_question)
);

-- Table: student
CREATE TABLE student (
    id_person bigint  NOT NULL,
    login text  NOT NULL,
    password text  NOT NULL,
    CONSTRAINT student_pk PRIMARY KEY (id_person)
);

-- Table: student_subject
CREATE TABLE student_subject (
    id_student bigint  NOT NULL,
    id_subject bigint  NOT NULL,
    CONSTRAINT student_subject_pk PRIMARY KEY (id_student,id_subject)
);

-- Table: subject
CREATE TABLE subject (
    id_subject bigint  NOT NULL,
    subject_name text  NOT NULL,
    CONSTRAINT subject_pk PRIMARY KEY (id_subject)
);

-- foreign keys
-- Reference: Answer_Question (table: answer)
ALTER TABLE answer ADD CONSTRAINT Answer_Question
    FOREIGN KEY (id_question)
    REFERENCES question (id_question)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: Question_Subject (table: question)
ALTER TABLE question ADD CONSTRAINT Question_Subject
    FOREIGN KEY (id_subject)
    REFERENCES subject (id_subject)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: Student_Person (table: student)
ALTER TABLE student ADD CONSTRAINT Student_Person
    FOREIGN KEY (id_person)
    REFERENCES person (id_person)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: Student_Subject_Student (table: student_subject)
ALTER TABLE student_subject ADD CONSTRAINT Student_Subject_Student
    FOREIGN KEY (id_student)
    REFERENCES student (id_person)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

-- Reference: Student_Subject_Subject (table: student_subject)
ALTER TABLE student_subject ADD CONSTRAINT Student_Subject_Subject
    FOREIGN KEY (id_subject)
    REFERENCES subject (id_subject)
    NOT DEFERRABLE
    INITIALLY IMMEDIATE
;

--subject
INSERT INTO subject values (1, 'history');
INSERT INTO subject values (2, 'biology');
INSERT INTO subject values (3, 'chemistry');

--question
INSERT INTO question
values (1, '___ are composed of extra-chromosomal DNA and are present in many species of bacteria and archaea.', 2),
(2, 'The Rickettisa that causes typhus and Rocky Mountain spotted fever belongs to the ___ class of the phylum Proteobacteria.', 2),
(3, '___ is a nitrogen-fixing endosymbiont associated with the roots of legumes.', 2),
(4, 'What is the species of beta proteobacteria that causes rat-bite fever?', 2),
(5, 'Which of the following extremophiles needs a high sugar concentration for optimal growth?', 2),
(6, 'When did Dimitri Ivanovsky showed that a disease could be trasmitted even after the Chamberland-Pasteur filter removed all visible bacteria from an extract?', 2),
(7, 'Viruses were initially classified based on which of the following?', 2),
(8, 'Who demonstrated that a disease of tobacco plants could be transferred from a diseased plant to a healthy one?', 2),
(9, 'A viron has an outer protein coating or ___.', 2),
(10, 'Invention of the ___ helped to discovery many viruses through direct visualization.', 2);

--answer
INSERT INTO answer
values (1, 'Fiber', false, 1),
(2, 'Pilus', false, 1),
(3, 'Plasmids', true, 1),
(4, 'Chitin', false, 1),
(5, 'Betaproteobacteria', false, 2),
(6, 'Gammaproteobacteria', false, 2),
(7, 'Myxobacteria', false, 2),
(8, 'Alphaproteobacteria', true, 2),
(9, 'Spirillum minus', false, 3),
(10, 'Nitrosomonas', false, 3),
(11, 'Rickettsia', false, 3),
(12, 'Rhizobium', true, 3),
(13, 'Rhizobium', false, 4),
(14, 'Nitrosomonas', false, 4),
(15, 'Spirillum minus', true, 4),
(16, 'Rickettsia', false, 4),
(17, 'Halophiles', false, 5),
(18, 'Acidophiles', false, 5),
(19, 'Osomophiles', true, 5),
(20, 'Thermophiles', false, 5),
(21, '1930', false, 6),
(22, '1892', true, 6),
(23, '1970', false, 6),
(24, '1886', false, 6),
(25, 'Molecular analysis of viral replicative cycles', false, 7),
(26, 'Shared morphology', true, 7),
(27, 'Viral receptors', false, 7),
(28, 'Strands of nucleic acid', false, 7),
(29, 'Stanley Prusiner', false, 8),
(30, 'David Baltimore', false, 8),
(31, 'Adolph Meyer', true, 8),
(32, 'Dmitri Ivanovsky', false, 8),
(33, 'capsomere', false, 9),
(34, 'enzyme', false, 9),
(35, 'ribosome', false, 9),
(36, 'capsid', true, 9),
(37, 'transmission electron microscope', true, 10),
(38, 'light microscope', false, 10),
(39, 'vaccine', false, 10),
(40, 'chamberland-Pasteur filter', false, 10);

--person
INSERT INTO person values (1, 'Mateusz', 'Kieliszkowski');

--student
INSERT INTO student values (1, 'mateo55', 'mt55');

--student_subject
INSERT INTO student_subject values (1, 1), (1, 2), (1, 3);

--post alter
ALTER TABLE student_subject RENAME COLUMN id_student TO id_person;

--Spring security
create table users(
    username text not null primary key,
    password text not null,
    enabled boolean not null
);

create table authorities (
    username text not null,
    authority text not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

--queries
SELECT subject.subject_name FROM subject
    INNER JOIN student_subject ON subject.id_subject = student_subject.id_subject
    INNER JOIN student ON student_subject.id_person = student.id_person WHERE student.id_person = 1;

SELECT a.subject_name FROM subject a;