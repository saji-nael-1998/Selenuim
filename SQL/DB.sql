create database assignguru;

use assignguru;
CREATE TABLE website (
    webiste_id INT AUTO_INCREMENT PRIMARY KEY,
    website_url Text NOT NULL,
    website_name Text NOT NULL,
    website_total_flashcards INT NOT NULL
);
CREATE TABLE category (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    website_id int ,
    category Text NOT NULL,
    category_url Text NOT NULL,
    category_total_flashcards INT NOT NULL,
    FOREIGN KEY (website_id) REFERENCES website(webiste_id)
);

CREATE TABLE category_group (
    group_id INT AUTO_INCREMENT PRIMARY KEY,
    category_id int not null,
    group_name Text NOT NULL,
    group_url Text NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(category_id)
);



CREATE TABLE question (
    question_id INT AUTO_INCREMENT PRIMARY KEY,
    group_id INT NOT NULL,
    question Text NOT NULL,
    answer Text NOT NULL,
    FOREIGN KEY (group_id)
        REFERENCES category_group (group_id)
);





