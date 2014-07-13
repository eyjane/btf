CREATE DATABASE IF NOT EXISTS btf;

CREATE TABLE IF NOT EXISTS btf.category(
	categoryID int NOT NULL UNIQUE AUTO_INCREMENT,
	category varchar(100),
	PRIMARY KEY(categoryID)
);

INSERT INTO btf.category(categoryID, category) VALUES
(1, "No Category"),
(2, "Snowshine"),
(3, "Avalunch"),
(4, "Winter is Coming"),
(5, "Frozen"),
(6, "Hail-leluja"),
(7, "Ice Ice Baby");


CREATE TABLE IF NOT EXISTS btf.recipe(
	recipeID int NOT NULL UNIQUE AUTO_INCREMENT,
	recipe varchar(100) NOT NULL,
	cost float NOT NULL,
	stock float NOT NULL,
	rcstatus varchar(50) NOT NULL,
	categoryID int NOT NULL,
	PRIMARY KEY (recipeID),
	FOREIGN KEY (categoryID) REFERENCES btf.category(categoryID)
);

INSERT INTO btf.recipe(recipeID, recipe,cost, stock, rcstatus, categoryID) VALUES
(20001, "Strawberry Ice Cream", 120, 7, "available", 1),
(20002, "Chocolate Fountain", 140, 4, "available", 2),
(20003, "Banana Split", 180, 4, "available", 2),
(20004, "Vanilla Wonderland", 140, 4, "available", 3),
(20005, "Sweet Peppermint", 140, 4, "available", 4),
(20006, "Rock and Road", 150, 3, "available", 5),
(20007, "Cherry Garcia", 180, 7, "available", 6),
(20008, "The Simpsons", 140, 10, "available", 7),
(20009, "The Blueberry Diaries", 170, 10, "available", 6),
(20010, "White Collar", 120, 17, "available", 5),
(20011, "Strawberry Stark", 140, 5, "deleted", 7),
(20012, "Baelish", 130, 5, "available", 4),
(20013, "Elsa", 140, 12, "deleted", 3),
(20014, "Jon Snow", 120, 4, "deleted", 7),
(20015, "Targaryen", 140, 6, "available", 3);

CREATE TABLE IF NOT EXISTS btf.raw(
	rawID int NOT NULL UNIQUE AUTO_INCREMENT,
	raw varchar(100) NOT NULL,
	price float NOT NULL,
	stock float NOT NULL,
	critical float NOT NULL,
	rmstatus varchar(50) NOT NULL,
	uom varchar(50) NOT NULL,
	PRIMARY KEY (rawID)
);

INSERT INTO btf.raw(rawID, raw, price, stock, critical, rmstatus, uom) values
(30001, "Strawberry Ice Cream", 20, 10, 5, "available", "scoop"),
(30002, "Chocolate Ice Cream", 30, 2, 8, "available", "scoop"),
(30003, "Vanilla Ice Cream", 25,15, 10, "available", "scoop"),
(30004, "Wafers", 10, 15, 20, "available", "piece"),
(30005, "Peppermint Ice Cream", 40, 8, 10, "available", "scoop"),
(30006, "Ice Cream Cone", 15, 30, 20, "available", "piece"),
(30007, "Marshmallow", 5, 30, 15, "available", "pack"),
(30008, "Cherry", 40, 5, 15, "available", "kg"),
(30009, "Chocolate Syrup", 10, 100, 6, "available", "teaspoon"),
(30010, "Banana", 10, 20, 25, "available", "piece"),
(30011, "Chocolate Chunkie", 15, 30, 25, "available", "g"),
(30012, "Cheese Ice Cream", 20, 15, 20, "available", "scoop"),
(30013, "Lemon Ice Cream", 30, 10, 15, "available", "scoop"),
(30014, "Blueberry", 15, 30, 35, "available", "piece"),
(30015, "Peanuts", 5, 25, 20, "available", "g"),
(30016, "Almonds", 15, 20, 25, "available", "piece"),
(30017, "Peanut Butter", 10, 30, 15, "deleted", "spoon"),
(30018, "Caramel Syrup", 10, 20, 15, "available", "teaspoon"),
(30019, "Dried Mango", 5, 30, 20, "deleted", "piece"),
(30020, "Ginger Ale", 10, 20, 25, "deleted", "teaspoon");

CREATE TABLE IF NOT EXISTS btf.ingredients(
	recipeID int NOT NULL,
	rawID int NOT NULL,
	amount float NOT NULL,
	FOREIGN KEY (recipeID) REFERENCES btf.recipe(recipeID),
	FOREIGN KEY (rawID) REFERENCES btf.raw(rawID)
);

INSERT INTO btf.ingredients(recipeID, rawID, amount) VALUES
(20001, 30001, 3), (20001, 30006, 1),
(20002, 30002, 3), (20002, 30006, 1), (20002, 30009, 1),
(20003, 30001, 1), (20003, 30002, 1), (20003, 30003, 1), (20003, 30008, 1), (20003, 30010, 2),
(20004, 30003, 2), (20004, 30004, 3), (20004, 30007, 5),
(20005, 30005, 1), (20005, 30006, 1), (20005, 30010, 2),
(20006, 30002, 1), (20006, 30003, 1), (20006, 30011, 3), (20006, 30009, 2),
(20007, 30003, 2), (20007, 30008, 3),
(20008, 30013, 2), (20008, 30015, 4),
(20009, 30003, 2), (20009, 30014, 3),
(20010, 30003, 3), (20010, 30004, 3), (20010, 30009, 2),
(20011, 30001, 1), (20011, 30003, 1), (20011, 30007, 2),
(20012, 30005, 1), (20012, 30009, 1), (20012, 30016, 3),
(20013, 30003, 3), (20013, 30014, 2), (20013, 30010, 1),
(20014, 30003, 2), (20014, 30011, 3), (20014, 30009, 2),
(20015, 30003, 3), (20015, 30007, 3), (20015, 30011, 2);

CREATE TABLE IF NOT EXISTS btf.sales(
	salesID int NOT NULL UNIQUE AUTO_INCREMENT,
	ordernum int NOT NULL,
	sales_type varchar(50) NOT NULL,
	sales_date date NOT NULL,
	PRIMARY KEY (salesID)
);
INSERT INTO btf.sales(salesID, ordernum, sales_type, sales_date) values
(40001, 1, "sales", "2014-07-01"),
(40002, 1, "complimentary", "2014-07-01"),
(40003, 2, "sales", "2014-07-01"),
(40004, 2, "complimentary", "2014-07-01"),
(40005, 3, "sales", "2014-07-01"),
(40006, 3, "complimentary", "2014-07-01"),
(40007, 4, "sales", "2014-07-01"),
(40008, 4, "complimentary", "2014-07-01"),
(40009, 5, "sales", "2014-07-01"),
(40010, 5, "complimentary", "2014-07-01"),
(40011, 6, "sales", "2014-07-01"),
(40012, 6, "complimentary", "2014-07-01"),
(40013, 7, "sales", "2014-07-01"),
(40014, 7, "complimentary", "2014-07-01"),
(40015, 8, "sales", "2014-07-01"),
(40016, 8, "complimentary", "2014-07-01"),
(40017, 9, "sales", "2014-07-01"),
(40018, 9, "complimentary", "2014-07-01"),
(40019, 10, "sales", "2014-07-01"),
(40020, 10, "complimentary", "2014-07-01"),
(40021, 11, "sales", "2014-07-01"),
(40022, 11, "complimentary", "2014-07-01"),
(40023, 12, "sales", "2014-07-01"),
(40024, 12, "complimentary", "2014-07-01"),
(40025, 13, "sales", "2014-07-01"),
(40026, 13, "complimentary", "2014-07-01"),
(40027, 14, "sales", "2014-07-01"),
(40028, 14, "complimentary", "2014-07-01"),
(40029, 15, "sales", "2014-07-01"),
(40030, 15, "complimentary", "2014-07-01");
/* NEED WEEKLY, MONTHLY AND YEARLY */


CREATE TABLE IF NOT EXISTS btf.sold(
	salesID int NOT NULL,
	recipeID int NOT NULL,
	quantity float NOT NULL,
	FOREIGN KEY (salesID) REFERENCES btf.sales(salesID),	
	FOREIGN KEY (recipeID) REFERENCES btf.recipe(recipeID)
);

INSERT INTO btf.sold(salesID, recipeID, quantity) VALUES
(40001, 20006, 4),
(40002, 20006, 0),
(40003, 20007, 3),
(40004, 20007, 1),
(40005, 20008, 10),
(40006, 20008, 0),
(40007, 20009, 6),
(40008, 20009, 2),
(40009, 20010, 14),
(40010, 20010, 0),
(40011, 20011, 5),
(40012, 20011, 0),
(40013, 20012, 6),
(40014, 20012, 0),
(40015, 20013, 9),
(40016, 20013, 1),
(40017, 20014, 8),
(40018, 20014, 0),
(40019, 20015, 12),
(40020, 20015, 0),
(40021, 20005, 20),
(40022, 20005, 0),
(40023, 20004, 12),
(40024, 20004, 1),
(40025, 20003, 13),
(40026, 20003, 0),
(40027, 20002, 12),
(40028, 20002, 0),
(40029, 20001, 7),
(40030, 20001, 0);
/* NEED WEEKLY, MONTHLY AND YEARLY */




CREATE TABLE IF NOT EXISTS btf.transactions(
	transactionID int NOT NULL UNIQUE AUTO_INCREMENT,
	transaction_date date NOT NULL,
	transaction_type varchar(50) NOT NULL,
	PRIMARY KEY (transactionID)
);

INSERT INTO btf.transactions(transactionID, transaction_date, transaction_type) VALUES
(50001, "2014-07-01", "transfer"), (50002, "2014-07-01", "used"), (50003, "2014-07-01", "actual"), (50004, "2014-07-01", "deliver"), (50005, "2014-07-01", "wastage"),
(50006, "2014-07-01", "transfer"), (50007, "2014-07-01", "used"), (50008, "2014-07-01", "actual"), (50009, "2014-07-01", "deliver"), (50010, "2014-07-01", "wastage"),
(50011, "2014-07-01", "transfer"), (50012, "2014-07-01", "used"), (50013, "2014-07-01", "actual"), (50014, "2014-07-01", "deliver"), (50015, "2014-07-01", "wastage"),
(50016, "2014-07-01", "transfer"), (50017, "2014-07-01", "used"), (50018, "2014-07-01", "actual"), (50019, "2014-07-01", "deliver"), (50020, "2014-07-01", "wastage"),
(50021, "2014-07-01", "transfer"), (50022, "2014-07-01", "used"), (50023, "2014-07-01", "actual"), (50024, "2014-07-01", "deliver"), (50025, "2014-07-01", "wastage"),
(50026, "2014-07-01", "transfer"), (50027, "2014-07-01", "used"), (50028, "2014-07-01", "actual"), (50029, "2014-07-01", "deliver"), (50030, "2014-07-01", "wastage"),
(50031, "2014-07-01", "transfer"), (50032, "2014-07-01", "used"), (50033, "2014-07-01", "actual"), (50034, "2014-07-01", "deliver"), (50035, "2014-07-01", "wastage"),
(50036, "2014-07-01", "transfer"), (50037, "2014-07-01", "used"), (50038, "2014-07-01", "actual"), (50039, "2014-07-01", "deliver"), (50040, "2014-07-01", "wastage"),
(50041, "2014-07-01", "transfer"), (50042, "2014-07-01", "used"),(50043, "2014-07-01", "actual"), (50044, "2014-07-01", "deliver"), (50045, "2014-07-01", "wastage"),
(50046, "2014-07-01", "transfer"), (50047, "2014-07-01", "used"), (50048, "2014-07-01", "actual"), (50049, "2014-07-01", "deliver"), (50050, "2014-07-01", "wastage"),
(50051, "2014-07-01", "transfer"), (50052, "2014-07-01", "used"), (50053, "2014-07-01", "actual"), (50054, "2014-07-01", "deliver"),(50055, "2014-07-01", "wastage"),
(50056, "2014-07-01", "transfer"), (50057, "2014-07-01", "used"), (50058, "2014-07-01", "actual"), (50059, "2014-07-01", "deliver"), (50060, "2014-07-01", "wastage"),
(50061, "2014-07-01", "transfer"), (50062, "2014-07-01", "used"), (50063, "2014-07-01", "actual"), (50064, "2014-07-01", "deliver"), (50065, "2014-07-01", "wastage"),
(50066, "2014-07-01", "transfer"), (50067, "2014-07-01", "used"), (50068, "2014-07-01", "actual"), (50069, "2014-07-01", "deliver"), (50070, "2014-07-01", "wastage"),
(50071, "2014-07-01", "transfer"), (50072, "2014-07-01", "used"), (50073, "2014-07-01", "actual"), (50074, "2014-07-01", "deliver"), (50075, "2014-07-01", "wastage"),
(50076, "2014-07-01", "transfer"), (50077, "2014-07-01", "used"), (50078, "2014-07-01", "actual"), (50079, "2014-07-01", "deliver"), (50080, "2014-07-01", "wastage"),
(50081, "2014-07-01", "transfer"), (50082, "2014-07-01", "used"), (50083, "2014-07-01", "actual"), (50084, "2014-07-01", "deliver"), (50085, "2014-07-01", "wastage"),
(50086, "2014-07-01", "transfer"), (50087, "2014-07-01", "used"), (50088, "2014-07-01", "actual"), (50089, "2014-07-01", "deliver"), (50090, "2014-07-01", "wastage"),
(50091, "2014-07-01", "transfer"), (50092, "2014-07-01", "used"), (50093, "2014-07-01", "actual"), (50094, "2014-07-01", "deliver"), (50095, "2014-07-01", "wastage"),
(50096, "2014-07-01", "transfer"), (50097, "2014-07-01", "used"), (50098, "2014-07-01", "actual"), (50099, "2014-07-01", "deliver"), (50100, "2014-07-01", "wastage");

CREATE TABLE IF NOT EXISTS btf.transact(
	transactionID int NOT NULL,
	rawID int NOT NULL,
	quantity float NOT NULL,
	FOREIGN KEY (transactionID) REFERENCES btf.transactions(transactionID),	
	FOREIGN KEY (rawID) REFERENCES btf.raw(rawID)
);

INSERT INTO btf.transact(transactionID, rawID, quantity) values
(50001, 30015, 3), (50002, 30015, 1), (50003, 30015, 2), (50004, 30015, 1), (50005, 30015, 0),
(50006, 30016, 3), (50007, 30016, 0), (50008, 30016, 1), (50009, 30016, 2), (50010, 30016, 0),
(50011, 30017, 1), (50012, 30017, 2), (50013, 30017, 0), (50014, 30017, 2), (50015, 30017, 1),
(50016, 30018, 4), (50017, 30018, 0), (50018, 30018, 3), (50019, 30018, 7), (50020, 30018, 0),
(50021, 30019, 5), (50022, 30019, 2), (50023, 30019, 2), (50024, 30019, 10), (50025, 30019, 1),
(50026, 30020, 5), (50027, 30020, 1), (50028, 30020, 17), (50029, 30020, 15), (50030, 30020, 1),
(50031, 30014, 7), (50032, 30014, 1), (50033, 30014, 15), (50034, 30014, 10), (50035, 30014, 2),
(50036, 30013, 9), (50037, 30013, 3), (50038, 30013, 15), (50039, 30013, 10), (50040, 30013, 1),
(50041, 30012, 0), (50042, 30012, 1), (50043, 30012, 10), (50044, 30012, 10), (50045, 30012, 2),
(50046, 30011, 2), (50047, 30011, 1), (50048, 30011, 17), (50049, 30011, 10), (50050, 30011, 2),
(50051, 30010, 2), (50052, 30010, 1), (50053, 30010, 17), (50054, 30010, 12), (50055, 30010, 1),
(50056, 30001, 10), (50057, 30001, 0), (50058, 30001, 12), (50059, 30001, 7), (50060, 30001, 0),
(50061, 30002, 9), (50062, 30002, 2), (50063, 30002, 18), (50064, 30002, 7), (50065, 30002, 2),
(50066, 30003, 15), (50067, 30003, 4), (50068, 30003, 12), (50069, 30003, 25), (50070, 30003, 0),
(50071, 30004, 3), (50072, 30004, 7), (50073, 30004, 1), (50074, 30004, 13), (50075, 30004, 2),
(50076, 30005, 12), (50077, 30005, 1), (50078, 30005, 19), (50079, 30005, 14), (50080, 30005, 1),
(50081, 30009, 3), (50082, 30009, 2), (50083, 30009, 17), (50084, 30009, 12), (50085, 30009, 1),
(50086, 30008, 10), (50087, 30008, 5), (50088, 30008, 22), (50089, 30008, 19), (50090, 30008, 1),
(50091, 30007, 12), (50092, 30007, 2), (50093, 30007, 18), (50094, 30007, 10), (50095, 30007, 2),
(50096, 30006, 6), (50097, 30006, 3), (50098, 30006, 15), (50099, 30006, 9), (50100, 30006, 2)
/* TO BE CONTINUED*/;