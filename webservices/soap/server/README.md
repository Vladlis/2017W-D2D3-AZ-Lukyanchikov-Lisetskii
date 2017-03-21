To generate wsdl and sources:
- `mvn clean compile`
- `cd target/classes`
- `wsgen -verbose -keep -cp . FactorialService -wsdl`

The other way is to:
- start application
- go to `http://127.0.0.1:8081/FactorialService?wsdl` to get wsdl
- run `wsimport -verbose -Xnocompile "http://127.0.0.1:8081/FactorialService?wsdl`