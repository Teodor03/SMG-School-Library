drop database if exists SchoolLibrary;
create database SchoolLibrary;

create table SchoolLibrary.Authors(

	authorID int unsigned not null auto_increment,

	authorFirstName tinytext not null,
    authorFamilyName tinytext not null,

    primary key(authorID)

);

create table SchoolLibrary.Genres(

	genreID int unsigned not null auto_increment,

	genreName tinytext not null,

    primary key(genreID)

);

create table SchoolLibrary.Books(

	bookID int unsigned auto_increment,

	bookName tinytext not null,
    physicalLocation tinytext,
    bookDescription text, 
    
    authorID int unsigned not null,
    genreID int unsigned not null,
    
    foreign key (authorID) references Authors(authorID),
	foreign key (genreID) references Genres(genreID),
    
    primary key(bookID)

);