-- SCRIPT SIMPLE  SCHEMA  BOOKSTORE
-- ^[^INSERT].*$ > "" 
-- (\r\n)+  > \r\n
INSERT INTO BOOKSTORE.ROLE(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, ROLE) VALUES(52, TIMESTAMP '2017-07-31 15:37:58.955', TIMESTAMP '2017-07-31 15:37:58.955', 0, 'basic');
INSERT INTO BOOKSTORE.USER(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, ADDRESS, CITY, STATE, FIRST_NAME, LAST_NAME, LOGIN) VALUES(1, TIMESTAMP '2017-07-31 15:37:58.955', TIMESTAMP '2017-07-31 15:37:58.955', 0, NULL, NULL, NULL, 'James', 'Roberts', NULL);
INSERT INTO BOOKSTORE.USER(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, ADDRESS, CITY, STATE, FIRST_NAME, LAST_NAME, LOGIN) VALUES(2, TIMESTAMP '2017-07-31 15:37:58.955', TIMESTAMP '2017-07-31 15:37:58.955', 0, NULL, NULL, NULL, 'Michael', 'Brown', NULL);
INSERT INTO BOOKSTORE.USER(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, ADDRESS, CITY, STATE, FIRST_NAME, LAST_NAME, LOGIN) VALUES(3, TIMESTAMP '2017-07-31 15:37:58.955', TIMESTAMP '2017-07-31 15:37:58.955', 0, NULL, NULL, NULL, 'Linda', 'Roberts', NULL);
INSERT INTO BOOKSTORE.USER(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, ADDRESS, CITY, STATE, FIRST_NAME, LAST_NAME, LOGIN) VALUES(4, TIMESTAMP '2017-07-31 15:37:58.955', TIMESTAMP '2017-07-31 15:37:58.955', 0, NULL, NULL, NULL, 'Michael', 'Jones', NULL);
INSERT INTO BOOKSTORE.USER(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, ADDRESS, CITY, STATE, FIRST_NAME, LAST_NAME, LOGIN) VALUES(5, TIMESTAMP '2017-07-31 15:37:58.955', TIMESTAMP '2017-07-31 15:37:58.955', 0, NULL, NULL, NULL, 'Patricia', 'Taylor', NULL);
INSERT INTO BOOKSTORE.USER(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, ADDRESS, CITY, STATE, FIRST_NAME, LAST_NAME, LOGIN) VALUES(6, TIMESTAMP '2017-07-31 15:37:58.955', TIMESTAMP '2017-07-31 15:37:58.955', 0, NULL, NULL, NULL, 'Michael', 'Roberts', NULL);
INSERT INTO BOOKSTORE.USER(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, ADDRESS, CITY, STATE, FIRST_NAME, LAST_NAME, LOGIN) VALUES(7, TIMESTAMP '2017-07-31 15:37:58.955', TIMESTAMP '2017-07-31 15:37:58.955', 0, NULL, NULL, NULL, 'Patricia', 'Thomas', NULL);
INSERT INTO BOOKSTORE.USER(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, ADDRESS, CITY, STATE, FIRST_NAME, LAST_NAME, LOGIN) VALUES(8, TIMESTAMP '2017-07-31 15:37:58.955', TIMESTAMP '2017-07-31 15:37:58.955', 0, NULL, NULL, NULL, 'Michael', 'Thomas', NULL);
INSERT INTO BOOKSTORE.USER(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, ADDRESS, CITY, STATE, FIRST_NAME, LAST_NAME, LOGIN) VALUES(9, TIMESTAMP '2017-07-31 15:37:58.955', TIMESTAMP '2017-07-31 15:37:58.955', 0, NULL, NULL, NULL, 'John', 'Brown', NULL);
INSERT INTO BOOKSTORE.USER(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, ADDRESS, CITY, STATE, FIRST_NAME, LAST_NAME, LOGIN) VALUES(10, TIMESTAMP '2017-07-31 15:37:58.955', TIMESTAMP '2017-07-31 15:37:58.955', 0, NULL, NULL, NULL, 'Linda', 'Roberts', NULL);

INSERT INTO BOOKSTORE.USER_ROLE(ROLE_ID, USER_ID) VALUES(52, 1);
INSERT INTO BOOKSTORE.USER_ROLE(ROLE_ID, USER_ID) VALUES(52, 2);
INSERT INTO BOOKSTORE.USER_ROLE(ROLE_ID, USER_ID) VALUES(52, 3);
INSERT INTO BOOKSTORE.USER_ROLE(ROLE_ID, USER_ID) VALUES(52, 4);
INSERT INTO BOOKSTORE.USER_ROLE(ROLE_ID, USER_ID) VALUES(52, 5);
INSERT INTO BOOKSTORE.USER_ROLE(ROLE_ID, USER_ID) VALUES(52, 6);
INSERT INTO BOOKSTORE.USER_ROLE(ROLE_ID, USER_ID) VALUES(52, 7);
INSERT INTO BOOKSTORE.USER_ROLE(ROLE_ID, USER_ID) VALUES(52, 8);
INSERT INTO BOOKSTORE.USER_ROLE(ROLE_ID, USER_ID) VALUES(52, 9);
INSERT INTO BOOKSTORE.USER_ROLE(ROLE_ID, USER_ID) VALUES(52, 10);

INSERT INTO BOOKSTORE.USER_SETTINGS(USER_ID, SETTING_VALUE, SETTING_NAME) VALUES(1, 'en', 'locale');
INSERT INTO BOOKSTORE.USER_SETTINGS(USER_ID, SETTING_VALUE, SETTING_NAME) VALUES(2, 'en', 'locale');
INSERT INTO BOOKSTORE.USER_SETTINGS(USER_ID, SETTING_VALUE, SETTING_NAME) VALUES(3, 'en', 'locale');
INSERT INTO BOOKSTORE.USER_SETTINGS(USER_ID, SETTING_VALUE, SETTING_NAME) VALUES(4, 'en', 'locale');
INSERT INTO BOOKSTORE.USER_SETTINGS(USER_ID, SETTING_VALUE, SETTING_NAME) VALUES(5, 'en', 'locale');
INSERT INTO BOOKSTORE.USER_SETTINGS(USER_ID, SETTING_VALUE, SETTING_NAME) VALUES(6, 'en', 'locale');
INSERT INTO BOOKSTORE.USER_SETTINGS(USER_ID, SETTING_VALUE, SETTING_NAME) VALUES(7, 'en', 'locale');
INSERT INTO BOOKSTORE.USER_SETTINGS(USER_ID, SETTING_VALUE, SETTING_NAME) VALUES(8, 'en', 'locale');
INSERT INTO BOOKSTORE.USER_SETTINGS(USER_ID, SETTING_VALUE, SETTING_NAME) VALUES(9, 'en', 'locale');
INSERT INTO BOOKSTORE.USER_SETTINGS(USER_ID, SETTING_VALUE, SETTING_NAME) VALUES(10, 'en', 'locale');


INSERT INTO BOOKSTORE.AUTHOR(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, FIRST_NAME, LAST_NAME) VALUES(1, TIMESTAMP '2017-07-31 15:37:58.686', TIMESTAMP '2017-07-31 15:37:58.686', 0, 'Barbara', 'Smith');
INSERT INTO BOOKSTORE.AUTHOR(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, FIRST_NAME, LAST_NAME) VALUES(2, TIMESTAMP '2017-07-31 15:37:58.686', TIMESTAMP '2017-07-31 15:37:58.686', 0, 'Patricia', 'Brown');
INSERT INTO BOOKSTORE.AUTHOR(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, FIRST_NAME, LAST_NAME) VALUES(3, TIMESTAMP '2017-07-31 15:37:58.686', TIMESTAMP '2017-07-31 15:37:58.686', 0, 'Barbara', 'Wilson');
INSERT INTO BOOKSTORE.AUTHOR(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, FIRST_NAME, LAST_NAME) VALUES(4, TIMESTAMP '2017-07-31 15:37:58.686', TIMESTAMP '2017-07-31 15:37:58.686', 0, 'Mary', 'Jones');
INSERT INTO BOOKSTORE.AUTHOR(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, FIRST_NAME, LAST_NAME) VALUES(5, TIMESTAMP '2017-07-31 15:37:58.686', TIMESTAMP '2017-07-31 15:37:58.686', 0, 'Elizabeth', 'Williams');

INSERT INTO BOOKSTORE.CONTENT(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, CONTENT, CONTENT_TYPE) VALUES(2, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, X'4920436170747572652054686520436173746c65', 'text');
INSERT INTO BOOKSTORE.CONTENT(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, CONTENT, CONTENT_TYPE) VALUES(4, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, X'416e6f746865722042756c6c73686974204e6967687420696e205375636b2043697479', 'text');
INSERT INTO BOOKSTORE.CONTENT(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, CONTENT, CONTENT_TYPE) VALUES(6, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, X'546f204b696c6c2041204d6f636b696e6762697264', 'text');
INSERT INTO BOOKSTORE.CONTENT(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, CONTENT, CONTENT_TYPE) VALUES(8, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, X'4e6f20436f756e74727920466f72204f6c64204d656e', 'text');
INSERT INTO BOOKSTORE.CONTENT(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, CONTENT, CONTENT_TYPE) VALUES(10, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, X'546865697220457965732057657265205761746368696e6720476f64', 'text');
INSERT INTO BOOKSTORE.CONTENT(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, CONTENT, CONTENT_TYPE) VALUES(12, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, X'54686520477261706573204f66205772617468', 'text');
INSERT INTO BOOKSTORE.CONTENT(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, CONTENT, CONTENT_TYPE) VALUES(14, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, X'4e6f20436f756e74727920466f72204f6c64204d656e', 'text');
INSERT INTO BOOKSTORE.CONTENT(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, CONTENT, CONTENT_TYPE) VALUES(16, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, X'54686520477261706573204f66205772617468', 'text');
INSERT INTO BOOKSTORE.CONTENT(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, CONTENT, CONTENT_TYPE) VALUES(18, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, X'4920436170747572652054686520436173746c65', 'text');
INSERT INTO BOOKSTORE.CONTENT(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, CONTENT, CONTENT_TYPE) VALUES(20, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, X'4e6f20436f756e74727920466f72204f6c64204d656e', 'text');
INSERT INTO BOOKSTORE.CONTENT(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, CONTENT, CONTENT_TYPE) VALUES(22, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, X'41732049204c6179204479696e67', 'text');
INSERT INTO BOOKSTORE.CONTENT(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, CONTENT, CONTENT_TYPE) VALUES(24, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, X'41732049204c6179204479696e67', 'text');
INSERT INTO BOOKSTORE.CONTENT(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, CONTENT, CONTENT_TYPE) VALUES(26, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, X'546865697220457965732057657265205761746368696e6720476f64', 'text');
INSERT INTO BOOKSTORE.CONTENT(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, CONTENT, CONTENT_TYPE) VALUES(28, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, X'4120436f6e6665646572616379204f662044756e636573', 'text');
INSERT INTO BOOKSTORE.CONTENT(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, CONTENT, CONTENT_TYPE) VALUES(30, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, X'416e6f746865722042756c6c73686974204e6967687420696e205375636b2043697479', 'text');



INSERT INTO BOOKSTORE.PRODUCT(PRODUCT_TYPE, ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, DESCRIPTION, NAME, CONTENT_ID, PRICE) VALUES('BOOK', 1, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, 'I Capture The Castle', 'As I Lay Dying', 2, 8.99);
INSERT INTO BOOKSTORE.PRODUCT(PRODUCT_TYPE, ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, DESCRIPTION, NAME, CONTENT_ID, PRICE) VALUES('BOOK', 3, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, 'Another Bullshit Night in Suck City', 'For Whom The Bell Tolls', 4, 5.89);
INSERT INTO BOOKSTORE.PRODUCT(PRODUCT_TYPE, ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, DESCRIPTION, NAME, CONTENT_ID, PRICE) VALUES('BOOK', 5, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, 'To Kill A Mockingbird', 'Another Bullshit Night in Suck City', 6, 9.50);
INSERT INTO BOOKSTORE.PRODUCT(PRODUCT_TYPE, ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, DESCRIPTION, NAME, CONTENT_ID, PRICE) VALUES('BOOK', 7, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, 'No Country For Old Men', 'No Country For Old Men', 8, 9.99);
INSERT INTO BOOKSTORE.PRODUCT(PRODUCT_TYPE, ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, DESCRIPTION, NAME, CONTENT_ID, PRICE) VALUES('BOOK', 9, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, 'Their Eyes Were Watching God', 'Another Bullshit Night in Suck City', 10, 12.99);
INSERT INTO BOOKSTORE.PRODUCT(PRODUCT_TYPE, ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, DESCRIPTION, NAME, CONTENT_ID, PRICE) VALUES('BOOK', 11, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, 'The Grapes Of Wrath', 'Of Mice And Men', 12, 8.99);
INSERT INTO BOOKSTORE.PRODUCT(PRODUCT_TYPE, ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, DESCRIPTION, NAME, CONTENT_ID, PRICE) VALUES('BOOK', 13, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, 'No Country For Old Men', 'No Country For Old Men', 14, 6.99);
INSERT INTO BOOKSTORE.PRODUCT(PRODUCT_TYPE, ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, DESCRIPTION, NAME, CONTENT_ID, PRICE) VALUES('BOOK', 15, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, 'The Grapes Of Wrath', 'As I Lay Dying', 16, 6.99);
INSERT INTO BOOKSTORE.PRODUCT(PRODUCT_TYPE, ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, DESCRIPTION, NAME, CONTENT_ID, PRICE) VALUES('BOOK', 17, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, 'I Capture The Castle', 'No Country For Old Men', 18, 7.99);
INSERT INTO BOOKSTORE.PRODUCT(PRODUCT_TYPE, ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, DESCRIPTION, NAME, CONTENT_ID, PRICE) VALUES('BOOK', 19, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, 'No Country For Old Men', 'No Country For Old Men', 20, 5.99);
INSERT INTO BOOKSTORE.PRODUCT(PRODUCT_TYPE, ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, DESCRIPTION, NAME, CONTENT_ID, PRICE) VALUES('BOOK', 21, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, 'As I Lay Dying', 'Of Mice And Men', 22, 8.99);
INSERT INTO BOOKSTORE.PRODUCT(PRODUCT_TYPE, ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, DESCRIPTION, NAME, CONTENT_ID, PRICE) VALUES('BOOK', 23, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, 'As I Lay Dying', 'A Confederacy Of Dunces', 24, 8.99);
INSERT INTO BOOKSTORE.PRODUCT(PRODUCT_TYPE, ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, DESCRIPTION, NAME, CONTENT_ID, PRICE) VALUES('BOOK', 25, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, 'Their Eyes Were Watching God', 'I Capture The Castle', 26, 10.29);
INSERT INTO BOOKSTORE.PRODUCT(PRODUCT_TYPE, ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, DESCRIPTION, NAME, CONTENT_ID, PRICE) VALUES('BOOK', 27, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, 'A Confederacy Of Dunces', 'Another Bullshit Night in Suck City', 28, 9.99);
INSERT INTO BOOKSTORE.PRODUCT(PRODUCT_TYPE, ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, DESCRIPTION, NAME, CONTENT_ID, PRICE) VALUES('BOOK', 29, TIMESTAMP '2017-07-31 15:37:58.802', TIMESTAMP '2017-07-31 15:37:58.802', 0, 'Another Bullshit Night in Suck City', 'As I Lay Dying', 30, 8.99);

INSERT INTO BOOKSTORE.PRODUCT_BOOK(ISBN, ID) VALUES('ISBN1501508278802', 1);
INSERT INTO BOOKSTORE.PRODUCT_BOOK(ISBN, ID) VALUES('ISBN1501508278802', 3);
INSERT INTO BOOKSTORE.PRODUCT_BOOK(ISBN, ID) VALUES('ISBN1501508278802', 5);
INSERT INTO BOOKSTORE.PRODUCT_BOOK(ISBN, ID) VALUES('ISBN1501508278802', 7);
INSERT INTO BOOKSTORE.PRODUCT_BOOK(ISBN, ID) VALUES('ISBN1501508278802', 9);
INSERT INTO BOOKSTORE.PRODUCT_BOOK(ISBN, ID) VALUES('ISBN1501508278802', 11);
INSERT INTO BOOKSTORE.PRODUCT_BOOK(ISBN, ID) VALUES('ISBN1501508278802', 13);
INSERT INTO BOOKSTORE.PRODUCT_BOOK(ISBN, ID) VALUES('ISBN1501508278802', 15);
INSERT INTO BOOKSTORE.PRODUCT_BOOK(ISBN, ID) VALUES('ISBN1501508278802', 17);
INSERT INTO BOOKSTORE.PRODUCT_BOOK(ISBN, ID) VALUES('ISBN1501508278802', 19);
INSERT INTO BOOKSTORE.PRODUCT_BOOK(ISBN, ID) VALUES('ISBN1501508278802', 21);
INSERT INTO BOOKSTORE.PRODUCT_BOOK(ISBN, ID) VALUES('ISBN1501508278802', 23);
INSERT INTO BOOKSTORE.PRODUCT_BOOK(ISBN, ID) VALUES('ISBN1501508278802', 25);
INSERT INTO BOOKSTORE.PRODUCT_BOOK(ISBN, ID) VALUES('ISBN1501508278802', 27);
INSERT INTO BOOKSTORE.PRODUCT_BOOK(ISBN, ID) VALUES('ISBN1501508278802', 29);


INSERT INTO BOOKSTORE.BOOK_AUTHOR(BOOKS_ID, AUTHORS_ID) VALUES(1, 4);
INSERT INTO BOOKSTORE.BOOK_AUTHOR(BOOKS_ID, AUTHORS_ID) VALUES(3, 2);
INSERT INTO BOOKSTORE.BOOK_AUTHOR(BOOKS_ID, AUTHORS_ID) VALUES(5, 4);
INSERT INTO BOOKSTORE.BOOK_AUTHOR(BOOKS_ID, AUTHORS_ID) VALUES(7, 4);
INSERT INTO BOOKSTORE.BOOK_AUTHOR(BOOKS_ID, AUTHORS_ID) VALUES(9, 3);
INSERT INTO BOOKSTORE.BOOK_AUTHOR(BOOKS_ID, AUTHORS_ID) VALUES(11, 3);
INSERT INTO BOOKSTORE.BOOK_AUTHOR(BOOKS_ID, AUTHORS_ID) VALUES(13, 2);
INSERT INTO BOOKSTORE.BOOK_AUTHOR(BOOKS_ID, AUTHORS_ID) VALUES(15, 1);
INSERT INTO BOOKSTORE.BOOK_AUTHOR(BOOKS_ID, AUTHORS_ID) VALUES(17, 1);
INSERT INTO BOOKSTORE.BOOK_AUTHOR(BOOKS_ID, AUTHORS_ID) VALUES(19, 2);
INSERT INTO BOOKSTORE.BOOK_AUTHOR(BOOKS_ID, AUTHORS_ID) VALUES(21, 4);
INSERT INTO BOOKSTORE.BOOK_AUTHOR(BOOKS_ID, AUTHORS_ID) VALUES(23, 1);
INSERT INTO BOOKSTORE.BOOK_AUTHOR(BOOKS_ID, AUTHORS_ID) VALUES(25, 1);
INSERT INTO BOOKSTORE.BOOK_AUTHOR(BOOKS_ID, AUTHORS_ID) VALUES(27, 1);
INSERT INTO BOOKSTORE.BOOK_AUTHOR(BOOKS_ID, AUTHORS_ID) VALUES(29, 1);


INSERT INTO BOOKSTORE."ORDER"(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, STATUS, USER_ID) VALUES(1, TIMESTAMP '2017-07-31 15:37:59.04', TIMESTAMP '2017-07-31 15:37:59.071', 3, 'NEW', 1);
INSERT INTO BOOKSTORE."ORDER"(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, STATUS, USER_ID) VALUES(2, TIMESTAMP '2017-07-31 15:37:59.071', TIMESTAMP '2017-07-31 15:37:59.071', 2, 'NEW', 1);
INSERT INTO BOOKSTORE."ORDER"(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, STATUS, USER_ID) VALUES(3, TIMESTAMP '2017-07-31 15:37:59.071', TIMESTAMP '2017-07-31 15:37:59.087', 2, 'NEW', 1);
INSERT INTO BOOKSTORE."ORDER"(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, STATUS, USER_ID) VALUES(4, TIMESTAMP '2017-07-31 15:37:59.087', TIMESTAMP '2017-07-31 15:37:59.087', 1, 'NEW', 1);
INSERT INTO BOOKSTORE."ORDER"(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, STATUS, USER_ID) VALUES(5, TIMESTAMP '2017-07-31 15:37:59.087', TIMESTAMP '2017-07-31 15:37:59.102', 3, 'NEW', 2);
INSERT INTO BOOKSTORE."ORDER"(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, STATUS, USER_ID) VALUES(6, TIMESTAMP '2017-07-31 15:37:59.102', TIMESTAMP '2017-07-31 15:37:59.124', 3, 'NEW', 2);
INSERT INTO BOOKSTORE."ORDER"(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, STATUS, USER_ID) VALUES(7, TIMESTAMP '2017-07-31 15:37:59.124', TIMESTAMP '2017-07-31 15:37:59.124', 1, 'NEW', 4);
INSERT INTO BOOKSTORE."ORDER"(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, STATUS, USER_ID) VALUES(8, TIMESTAMP '2017-07-31 15:37:59.124', TIMESTAMP '2017-07-31 15:37:59.14', 1, 'NEW', 5);
INSERT INTO BOOKSTORE."ORDER"(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, STATUS, USER_ID) VALUES(9, TIMESTAMP '2017-07-31 15:37:59.14', TIMESTAMP '2017-07-31 15:37:59.14', 2, 'NEW', 6);
INSERT INTO BOOKSTORE."ORDER"(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, STATUS, USER_ID) VALUES(10, TIMESTAMP '2017-07-31 15:37:59.155', TIMESTAMP '2017-07-31 15:37:59.155', 1, 'NEW', 7);
INSERT INTO BOOKSTORE."ORDER"(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, STATUS, USER_ID) VALUES(11, TIMESTAMP '2017-07-31 15:37:59.155', TIMESTAMP '2017-07-31 15:37:59.155', 1, 'NEW', 8);
INSERT INTO BOOKSTORE."ORDER"(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, STATUS, USER_ID) VALUES(12, TIMESTAMP '2017-07-31 15:37:59.171', TIMESTAMP '2017-07-31 15:37:59.171', 2, 'NEW', 8);
INSERT INTO BOOKSTORE."ORDER"(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, STATUS, USER_ID) VALUES(13, TIMESTAMP '2017-07-31 15:37:59.187', TIMESTAMP '2017-07-31 15:37:59.187', 1, 'NEW', 9);
INSERT INTO BOOKSTORE."ORDER"(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, STATUS, USER_ID) VALUES(14, TIMESTAMP '2017-07-31 15:37:59.187', TIMESTAMP '2017-07-31 15:37:59.202', 2, 'NEW', 9);
INSERT INTO BOOKSTORE."ORDER"(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, STATUS, USER_ID) VALUES(15, TIMESTAMP '2017-07-31 15:37:59.202', TIMESTAMP '2017-07-31 15:37:59.202', 1, 'NEW', 9);
INSERT INTO BOOKSTORE."ORDER"(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, STATUS, USER_ID) VALUES(16, TIMESTAMP '2017-07-31 15:37:59.202', TIMESTAMP '2017-07-31 15:37:59.224', 2, 'NEW', 9);
INSERT INTO BOOKSTORE."ORDER"(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, STATUS, USER_ID) VALUES(17, TIMESTAMP '2017-07-31 15:37:59.224', TIMESTAMP '2017-07-31 15:37:59.24', 3, 'NEW', 10);
INSERT INTO BOOKSTORE."ORDER"(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, STATUS, USER_ID) VALUES(18, TIMESTAMP '2017-07-31 15:37:59.24', TIMESTAMP '2017-07-31 15:37:59.24', 1, 'NEW', 10);
INSERT INTO BOOKSTORE."ORDER"(ID, CREATEDDATE, LASTMODIFIEDDATE, VERSION, STATUS, USER_ID) VALUES(19, TIMESTAMP '2017-07-31 15:37:59.24', TIMESTAMP '2017-07-31 15:37:59.255', 2, 'NEW', 10);

INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(1, 9, 3);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(1, 11, 3);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(1, 3, 1);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(2, 19, 3);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(2, 27, 2);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(3, 25, 2);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(3, 13, 2);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(4, 27, 2);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(5, 5, 4);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(5, 25, 2);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(5, 11, 1);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(6, 23, 2);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(6, 11, 2);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(6, 9, 1);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(7, 11, 3);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(8, 23, 2);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(9, 13, 2);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(9, 27, 4);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(10, 1, 4);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(11, 25, 4);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(12, 19, 4);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(12, 21, 3);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(13, 9, 4);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(14, 9, 4);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(14, 17, 3);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(15, 5, 2);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(16, 27, 4);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(16, 11, 1);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(17, 1, 3);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(17, 11, 4);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(17, 19, 4);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(18, 1, 2);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(19, 15, 4);
INSERT INTO BOOKSTORE.ORDER_PRODUCT(ORDER_ID, PRODUCT_ID, QUANTITY) VALUES(19, 23, 4);

ALTER SEQUENCE bookstore.seq_product RESTART WITH 10000;
ALTER SEQUENCE bookstore.seq_author RESTART WITH 10000;
ALTER SEQUENCE bookstore.seq_content RESTART WITH select max(id)+1 from bookstore.CONTENT;
ALTER SEQUENCE bookstore.seq_order RESTART WITH 10000;
ALTER SEQUENCE bookstore.seq_user RESTART WITH 10000;
ALTER SEQUENCE bookstore.seq_role RESTART WITH 10000;
