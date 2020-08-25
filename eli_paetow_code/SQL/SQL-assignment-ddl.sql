/* *
 * 2.1 SELECT
Task – Select all records from the Employee table. 
*/
SELECT * 
FROM "Employee" ;
/*
Task – Select all records from the Employee table where last name is King.

*/
SELECT * 
FROM "Employee" 
WHERE "LastName" = 'King'; 
/*
Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.

*/
SELECT * 
FROM "Employee" 
WHERE "FirstName" = 'Andrew'
AND "ReportsTo" is Null;
/*
2.2 ORDER BY
Task – Select all albums in album table and sort result set in descending order

*/
SELECT * 
FROM "Album" 
ORDER BY "Album" DESC ;
/*
Task – Select first name from Customer and sort result set in ascending order

*/

SELECT "FirstName" 
FROM "Customer" 
ORDER BY "FirstName" asc; 
/*
2.3 INSERT INTO
Task – Insert two new records into Genre table
*/
--SELECT "GenreId" 
--FROM "Genre" ;
INSERT INTO "Genre" ("GenreId" , "Name" )
VALUES (26, 'Junk');
INSERT INTO "Genre" ("GenreId" , "Name" )
VALUES (27, 'Genre-Bending');

/*

Task – Insert two new records into Employee table
*/
--SELECT * 
--FROM "Employee" ;
INSERT INTO "Employee" ("EmployeeId" , "FirstName" , "LastName" )
VALUES (9, 'Eli' , 'Paetow'), (10, 'Wezley' , 'Singleton');


/*

Task – Insert two new records into Customer table

 */
--SELECT * 
--FROM "Customer" ;
INSERT INTO "Customer" ("CustomerId" , "FirstName" , "LastName" , "Company" , "Email" )
VALUES (60, 'Bruce' , 'Wayne' , 'Wayne Enterprises' , 'notBatman.com'), (61, 'Tony' , 'Stark', 'Stark Labs' , 'iAmIronMan.com');


/*
 * 
 * 2.4 UPDATE
Task – Update Aaron Mitchell in Customer table to Robert Walter
*/
UPDATE "Customer" SET "FirstName" = 'Robert' , "LastName" = 'Walker'
WHERE 
"FirstName" = 'Aaron' AND  "LastName" = 'Mitchell';

--SELECT * 
--FROM "Customer" 
--WHERE "FirstName" = 'Robert' AND  "LastName" = 'Walker';

/*
Task – Update name of artist “Creedence Clearwater Revival” to “CCR”

 */
UPDATE "Artist" SET "Name" = 'CCR' 
WHERE "Name" = 'Creedence Clearwater Revival';

--SELECT * 
--FROM "Artist" 
--WHERE "Name" = 'CCR';

/*
 * 2.5 LIKE
Task – Select all invoices with a billing address like “T”
*/

SELECT *
FROM "Invoice" 
WHERE "BillingAddress" LIKE 'T%';
/*
2.6 BETWEEN
Task – Select all invoices that have a total between 15 and 50
*/
SELECT *
FROM "Invoice" 
WHERE "Total" BETWEEN 15 AND 50;

/*
Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
*/
SELECT *
FROM "Employee" 
WHERE "HireDate" BETWEEN '01-JUN-2003' AND '01-MAR-2004';
/*
2.7 DELETE
Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
*/
ALTER TABLE "Invoice" 
DROP CONSTRAINT "FK_InvoiceCustomerId"
DELETE 
FROM "Customer" 
WHERE "FirstName" = 'Robert' AND "LastName" = 'Walter';

--SELECT * 
--FROM "Customer" 
--WHERE "FirstName" = 'Robert' AND "LastName" = 'Walter';

/*
3.0 SQL Functions
In this section you will be using the PostGreSQL system functions, as well as your own functions, to perform various actions against the database
3.1 System Defined Functions

Task – Create a function that returns the current time.
*/

select current_timestamp;


/*
Task – create a function that returns the length of a mediatype from the mediatype table
*/
SELECT length(mt."Name") 
FROM "MediaType" mt ;

/*
 * 3.2 System Defined Aggregate Functions
Task –Create a function that returns the average total of all invoices
*/
SELECT avg(i."Total" ) AS "average total" 
FROM "Invoice" i;


/*
Task – Create a function that returns the most expensive track
*/

SELECT max(t."UnitPrice") AS "most expensive track" 
FROM "Track" t; 

/*
3.3 User Defined Scalar Functions
Task – Create a function that returns the average price of invoice-line items in the invoice-line table
*/
SELECT avg(il."UnitPrice") AS "average price"
FROM "InvoiceLine" il;


/*
3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.
*/

SELECT  * 
FROM "Employee" e 
WHERE  e."BirthDate" > '1968-12-31';
/*
5.0 JOINS
In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
5.1 INNER
Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
*/
SELECT i2."InvoiceId", c2."FirstName", c2."LastName"
FROM "Customer" c2
INNER JOIN "Invoice" i2 
ON c2."CustomerId" = i2."CustomerId";

/*
5.2 OUTER

Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, last name, invoiceId, and total.
*/
SELECT c2."CustomerId", c2."FirstName", c2."LastName", i2."InvoiceId", i2."Total" 
FROM "Customer" c2
FULL OUTER JOIN "Invoice" i2 
ON c2."CustomerId" = i2."CustomerId";

/*
5.3 RIGHT
Task – Create a right join that joins album and artist specifying artist name and title.
*/
SELECT ar."Name", al."Title" 
FROM "Artist" ar 
right JOIN  "Album" al 
ON ar."ArtistId" = al."ArtistId";

/*
5.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
*/
SELECT *
FROM "Artist" ar 
CROSS JOIN "Album" al
ORDER BY ar."Name";

/*
5.5 SELF
Task – Perform a self-join on the employee table, joining on the reports to column.

 */
SELECT * 
FROM "Employee" e1
JOIN "Employee" e2
ON e2."EmployeeId" = e1."ReportsTo";






