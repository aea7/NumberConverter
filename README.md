## Number Converter Backend

Run the Spring application (MySQL should be running locally) and then:

Try out the api with http://localhost:8080/swagger-ui.html 

OR

http://localhost:8080/option  ->  returns the format options GET
-

http://localhost:8080/convert  ->  returns the format options POST, body example:
-

{
 from: "Decimal",
 to: "Hexadecimal", 
 number: 123
}