# summerization afterwards
CREATE DATABASE sys;
use sys;
CREATE USER 'admin'@'%' IDENTIFIED BY 'admin123';
GRANT ALL PRIVILEGES ON librarysystem.* TO 'admin'@'%';
FLUSH PRIVILEGES;


CREATE TABLE User (
    UserId INT AUTO_INCREMENT PRIMARY KEY,
    PhoneNumber VARCHAR(20) UNIQUE NOT NULL,
    Password VARCHAR(255) NOT NULL, 
    UserName VARCHAR(100),
    RegistrationTime TIMESTAMP,
    LastLoginTime TIMESTAMP
);


CREATE TABLE Inventory (
    InventoryId INT AUTO_INCREMENT PRIMARY KEY,
    ISBN VARCHAR(13) UNIQUE,
    StoreTime TIMESTAMP,
    Status ENUM('在庫', '出借中', '整理中', '遺失', '損毀', '廢棄') DEFAULT '在庫',
    FOREIGN KEY (ISBN) REFERENCES Book (ISBN)
);


CREATE TABLE Book (
    ISBN VARCHAR(13) PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Author VARCHAR(100) NOT NULL,
    Introduction TEXT
);


CREATE TABLE BorrowingRecord (
    UserId INT NOT NULL,
    InventoryId INT NOT NULL,
    BorrowingTime TIMESTAMP,
    ReturnTime TIMESTAMP,
    INDEX (UserId),
    INDEX (InventoryId),
    FOREIGN KEY (UserId) REFERENCES User(UserId),
    FOREIGN KEY (InventoryId) REFERENCES Inventory(InventoryId)
);