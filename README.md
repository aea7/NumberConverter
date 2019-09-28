## Number Converter Backend

Run the Spring application (MySQL should be running locally) and then:

http://localhost:8080/option  ->  returns the format options GET
-

http://localhost:8080/convert  ->  returns the format options POST, body example:
-

{
 from: "Decimal",
 to: "Hexadecimal", 
 number: 123
}

http://localhost:8080/log  ->  Adds a log to the DB
-