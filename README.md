# Spring MVC - Building Spring Web Apps

**What is Spring MVC?**
+ Framework for building web applications in Java
+ Based on Model-View-Controller design pattern
+ Leverages feature of the Core Spring Framework(IoC, DI)

**Model-View-Controller(MVC)**



**Spring MVC Benefits**
+ The Spring way of building web app UIs in Java
+ Leverage a set of reusable UI-components
+ Help manage application state for web requests
+ Process form data: validation, conversion etc
+ Flexible configuration for the vie layer 

**Components of a Spring MVC Application**

<img align="right" width="100" height="100" src="https://user-images.githubusercontent.com/80107049/187021071-989e2734-3c4c-4edf-9f06-28665490ba5e.png"></br>


+ A set of web pages to layout UI components

</br>

<img align="right" width="100" height="100" src="https://user-images.githubusercontent.com/80107049/187021104-c4df60f6-4721-4794-92e4-1b42937aa3af.png"></br>



+ A collection of Spring beans(controllers, service, etc...)
</br>


<img align="right" width="100" height="100" src="https://user-images.githubusercontent.com/80107049/187021135-bb55f8ff-eb2b-4124-a5d1-0573f21bef89.png"></br>



+ Spring configuration(XML, Annotations or Java)

**Spring MVC Front Controller**

+ Front controller known as **DispatcherServlet**
  + Part of the Spring Framwork
  + Already developed by Spring Dev Team


<img align="right" width="100" height="100" src="https://user-images.githubusercontent.com/80107049/187021164-d0b730d7-3a7e-4239-8698-c5cd6c255c0a.png">

+ you will create
  + **M**odel object (orange)
  + **V**iew templates (dark green)
  + **C**ontroller classes (yellow)


**Controller**
+ Code created by developer

+ Contains your business logic 
  + Handle the request
  + Store/retrieve data(db,web service...)
  + Place data in model

+ Send to appropriate view template

**Model**
+ Model: contains your data

+ Store/retrieve data via backend systems
  + database, web service, etc...
  + Use a Spring bean if you like 

+ Place your data in the model
  + Data can be any Java object/collection


**View Template**
+ Spring MVC is flexible
  + Support many view templates

+ Most common is **JSP** + **JSTL**
  + JSP: Java Server Pages
  + JSTL: JSP Standard Tag Library

+ Developer creates a page 
  + Display data 

+ Other view templates supported 
  + Thymeleaf, Groovy
  + Velocity, Freemarker, etc


**Spring MVC Configuration Process - Part 1**
Add configuration to file: **WEB-INF/web.xml**
1. Configure Spring MVC Dispatcher Servlet
2. Set up URL mappings to Spring MVC Dispatcher Servlet

**Spring MVC Configuration Process - Part 2**
Add configuration to file: **WEB-INF/spring-mvc-demo-servlet.xml**
3. Add support for Spring component scanning
4. Add support for conversion, formatting and validation
5. Configuration Spring MVC View Resolver

*Step 1: Configure Spring MVC DispatcherServlet*

File:web.xml
```XML
<web-app>
  
  <servlet>
    <servlet-name>dispatcher</servlet-name>
    <servlet-class>org.springframwork.web.servlet.DispatcherServlet</servlet-class>
    
    <int-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>/WEB-INF/spring-mvc-demo-servlet.xml</param-value>
    </int-param>
   
    <load-on-startup>1</load-on-startup>
  </servlet>
  
</web-app>
```
+ Added entry for the Spring DispatcherServlet, or the Front Controller, for that put in servlet reference 
  + Give `<servlet-name>` and `<servlet-class>` of servlet 
  + The DispatcherServlet is a part of the core Spring framework 
+ After servlet reference, set up initial parameter.
  + Its basically to tell where is Spring context configuration file is located 

 
*Step 2:Set up URL mappings to Spring MVC Dispatcher Servlet*

File:web.xml
```XML
<web-app>
  
  <servlet>
    <servlet-name>dispatcher</servlet-name>
    <servlet-class>org.springframwork.web.servlet.DispatcherServlet</servlet-class>
    ...
  </servlet>
  
  <servlet-mapping>
    <servlet-name>dispatcher</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>  
  
</web-app>
```
+ In `<servlet-mapping>` tell the system for any URL pattern coming in, have to pass it off to the DispatcherServlet 
  + In example `<url-pattern>` is `/` slash means all web request coming in should be handled by DispatcherServlet.

>**Important Here**
>> Servlet name `<servlet-name>dispatcher</servlet-name>` matches with the servlet reference in servlet mapping `<servlet-name>dispatcher</servlet-name>`

*Step 3:Add support for Spring component scanning*

File:spring-mvc-demo-servlet.xml
```XML
<beans>
  
  <!-- Step 3: Add support for componenet scanning -->
  <context:component-scan base-package="com.tilmeez.springdemo" />
  
</beans>
```


*Step 4:Add support for conversion,formatting and validation*

File:spring-mvc-demo-servlet.xml
```XML
<beans>
  
  <!-- Step 3: Add support for componenet scanning -->
  <context:component-scan base-package="com.tilmeez.springdemo" />
  
  <!--Step 4:Add support for conversion,formatting and validation -->
  <mvc:annotation-driven/>
</beans>
```

*Step 5:Configure Spring MVC view Resolver*

File:spring-mvc-demo-servlet.xml
```XML
<beans>
  
  <!-- Step 3: Add support for componenet scanning -->
  <context:component-scan base-package="com.tilmeez.springdemo" />
  
  <!--Step 4:Add support for conversion,formatting and validation -->
  <mvc:annotation-driven/>
  
  <!-- Step 5:Configure Spring MVC view Resolver -->
  <bean
        class="org.springframework.web.servlet.InternalResourceViewResolver">
    <property name="prefix" value="/WEB-INF/view/" />
    <prperty name="suffix" value=",jsp" />
  </bean>
  
</beans>
```
+ When app provides a "view" name,Spring MVC will (where to look for view files)
  + prepend the prefix
  + append the suffix    
<img align="left" width="400" src="https://user-images.githubusercontent.com/80107049/187021207-b43765e3-34de-4ec8-9a81-1f3e99e9d11c.png"></br>
</br></br></br></br></br>


</br>**Spring MVC Example**</br></br></br></br></br>

<img align="left" width="400" src="https://user-images.githubusercontent.com/80107049/187021270-128c300f-af13-478c-a9d7-dec48232506b.png"></br>

+ Setup a request mapping for a given path
+ HomeController will handle the request and forward it to a view template 
  + Which will call main-menu.jsp
    </br></br></br></br></br></br></br>
**Development Process**
1. Create Controller class
2. Define Controller method 
3. Add Request mapping to Controller method 
4. Return View Name 
5. Develop View Page 

*Step 1:Create Controller class*
+ Annotate class with **@Controller**
  + **@Controller** inherits from **@Component ...** supports scanning

```JAVA
@Controller
public class HomeController {
  
}
```

*Step 2: Define Controller method*
```JAVA
@Controller
public class HomeController {
  
  public String showMyPage() {
    ...
    }
}
```
+ Spring MVC is flexible
  + Can use any method name 

*Step 3:Add Request Mapping to Controller method*
```JAVA
@Controller
public class HomeController {
  
  @RequestMapping("/")
  public String showMyPage() {
    ...
  }
  
}
```
+ Annotation maps a path to a method name
  + That's why you can choose any method name 

+ This `@RequestMapping` will handle all types of request, get, post and so on and so forth.

*Step 4;Return View Name*
```JAVA
@Controller
public class HomeController {
  
  @RequestMapping("/")
  public String showMyPage() {
    return "main-menu";
  }
  
}
```
+ In background spring use information from its configuration file 
  + It actually find view page, base on config
    + looks in given `prefix` directory 
    + and use the view name and then it will append the `suffix` `.jsp` 


*Step 5:Develop View Page*

File:/WEB-INF/view/main-menu.jsp
```JSP
<html><body>
  
  <h2>Spring MVC Demo - Home Page</h2>
  
</body></html>
```


##  Reading HTML Form Data - Overview

**Application Flow**


![image](https://user-images.githubusercontent.com/80107049/187048258-61d8cf52-72ed-487e-886f-12ea81872f52.png)

**Controller Class**

```JAVA
@Controller
public class HelloWorldController {

    // need a controller method to show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form"; //WEB-INF/view/helloworld-form.jsp
    }

    // need a controller method tp Process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }
```

**Development Process**
1. **Create Controller class**
2. **Show HTML form**
  1. Create controller method to show HTML Form
  2. Create View page for HTML form

3. **Process HTML Form**
  1. Create controller method to process HTML Form
  2. Develop View Page for Confirmation

## Adding Data to the Spring Model - Overvie

**Spring Model**
+ The **Model** is a container for your application data


+ In your Controller
  + You can put anything in the **model**
  + string, objects, info from database, etc...

+ Your View page (JSP) can access data from the **model**

**Code Example**
+ We want to create a new method to process form data
+ Read the form data: student's name
+ Convert the name to upper case
+ Add the uppercase version to the model

**Passing Model to your Controller**

![clipboard.png](https://user-images.githubusercontent.com/80107049/187261264-65d08c11-c1d4-4b92-ad8b-2c13e1680183.png)
**View Template - JSP**

<img src="https://user-images.githubusercontent.com/80107049/187261882-5019ab74-5632-4919-9a2a-19d988032b7c.png" width = 700 />

**Adding more data to your Model**

```JAVA
// get the data

String result = ...;
List<Student> theStudentList = ...;
ShoppingCart theShoppingCart = ...;

// add data to the model

model.addAttribute("message", result);

model.addAttribute("message", theStudentList);

model.addAttribute("message", theShoppingCart);
```

## Binding Request Params - Overview
+ Instead of using HttpServletRequest

```JAVA
@RequestMapping("/processFormVersionTwo")
public String letsShoutDude(HttpServletRequest request, Model model) {
  
  // read the request parameter from the HTML form
  String theName = request.getParameter("studentName");
  
 ... 
}
```
+ Bind variable using @RequestParam Annotation

```JAVA
@RequestMapping("/processFromVersionTwo")
public String letShoutDude(
  @RequestParam("studentName") String theName,
  Model model) {
  
  // now we can use the variable: theName
  
}
```
+ Behind the scenes:
  + Spring will read param from request: studentName
  + Bind it to variable: theName


## Controller Level Request Mapping - Overview

Adding request mapping to controller
+ Server as parent mapping for controller
+ All request mappings on methods in the controller are relative
+ Similar to folder directory structure

**Controller Request Mapping**
```JAVA
@RequestMapping("/funny") //Controller mapping
public class FunnyController {
  
  @RequestMapping("/showForm")
  public String showForm() {
   ... 
  }
  
  @RequestMapping("/processForm")
  public String process(HttpServletRequest request, Model model) {
   ... 
  }
  
}
```
+ Here controller mapping is `funny`
+ Method mappings are `showForm` and `processForm`
  + `/funny/showForm` and `/funny/processForm`




## Spring MVC Form Tags Overview

**Spring MVC Form Tags**
+ Spring MVC Form Tags are the building block for a web page
+ Form Tags are configurable and reusable for a web page

**Data Binding**
+ Spring MVC Form Tags can make use of data binding
+ Automatically setting / retrieving data from a Java object / bean

**Spring MVC Form Tags**
+ Form tags will generate HTML for you

| Form Tag         | Description           |
| ---------------- | --------------------- |
| form:form        | main form container   |
| form:input       | text filed            |
| form:textarea    | multi-line text field |
| form:checkbox    | check box             |
| form:radiabutton | radio buttons         |
| form:select      | drop down list        |
| more ...         |                       |


**Web Page Structure**
+ JSP page with special Spring MVC Form tags

```HTML
<html>
  ... regular html ...
  ... Spring MVC form tags ...
  ... more html ...
</html>
```

**How to Refernce Spring MVC Form Tags**
+ Specify the Spring namespace at beginning of JSP file

```HTML
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
```

## Text Fields - Overview

![image](https://user-images.githubusercontent.com/80107049/188125665-e37cd6da-759d-46f1-8ab9-e6763e462eb6.png)

**Showing Form**

In your Spring Controller
+ Before you show the form, you must add a **model attribute**
+ This is a bean that will hold form data for the **data binding**

**Show Form - Add Model Attribute**    
code snippet from Controller      
![image](https://user-images.githubusercontent.com/80107049/188125562-8da06dfc-c150-40c7-8b2e-717ac618a0a6.png)


**Setting up HTML Form - Data Binding**

![image](https://user-images.githubusercontent.com/80107049/188125485-9e38e3c3-0655-4eb2-9cd8-1e81a3f41435.png)

+ When Form is Loaded ... field are populated
+ When Form is submitted ... calls setter methods

**Handling Form Submission in the Controller**

```JAVA 
@RequestMapping("/processForm")
public String processForm(@ModelAttribute("student") Student theStudent) {
  
  // log the input data
  System.out.println("theStudent: " + theStudent.getName());
  
  return "student-confirmation";
}
```
+ @ModelAttribute: bind form data to object
+ Behind the scenes: the object is populated with form data

**Development Process**
1. Create Student class+
2. Create Student controller class
3. Create HTML form
4. Create form processing code
5. Create confirmation page


## Drop-Down Lists - Overview

Drop-Down list is represented by the tag `<form:select>`

_code Snippet_
```HTML
<form:select path="country">
  
  <form:option value="Brazil" lable="Brazil" />
  <form:option value="France" lable="Frace" />
  <form:option value="Germany" lable="Germany" />
  <form:option value="Pakistan" lable="Pakistan" />
  
</form:select>
```
+ `path="country"` is Property for data binding
+ `lable` is display to user
+ `value` is actual code which is pass over when its submitted

**Development Process**
1. Update HTML form
2. Update Student class - add getter/ setter for new property
3. Update confirmation page

##  Radio Buttons - Overview

A Radio Button is represented by the tag `<form:radiobutton>`

_Code Example_

```HTML
JAVA <form:radiobutton path="favoriteLanguage" value="Java" />
C# <form:radiobutton path="favoriteLanguage" value="C#" />
PHP <form:radiobutton path="favoriteLanguage" value="PHP" />
Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />
```
+ `path="favoriteLanguage"` is Data binding
  + On submit, Spring will call student.setFavoriteLanguagr(...)

## Checkboxes - Overview

A Check Box is represented by the tag `<form:checkbox>`

_Code Example_

```HTML
Linux <form:checkbox path="operatingSystems" value="Linux" />
Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
MS Windows <form:checkbox path="operatingSystems" value="MS Windows" />
```
+ `path="operatingSystems"` is Data binding
+ In java code
  + Need to add support when user selects multiple options
    + Array of Strings
      + Add appropriate get/set methods



## Spring MVC Form Validation Overview

**The Need for Validation**
+ Check the user input form for
  + required fields
  + valid numbers in a range
  + valid format(postal code)
  + custom business rule

**Java's Standard Bean Validation API**
+ Java has a standard Bean Validation API (JSR-303)
+ Defines a metadata model and API for entity validation
+ Not tied to either the web tier or the persistence tier
+ Available for server-side apps and also client-side JavaFX/Swing apps
+ Only a specification ... vendor independent ... portable
  + But still need an implementation ...

**Spring and Validation**
+ Spring version 4 and higher supports Bean Validation API
+ Preferred method for validation when building Spring apps
+ Simply add Validation JARs to our project

**Bean Validation Feature**

| Validation Frature                |
| --------------------------------- |
| required                          |
| validate length                   |
| validate numbers                  |
| validate with regular expressions |
| custom validation                 |

**Validation Annotations**

| Annotation        | Description                                  |
| ----------------- | -------------------------------------------- |
| **@NotNull**      | Checks that the annotation value is not null |
| **@Min**          | Must be a number >=value                     |
| **@Max**          | Must be a number <=value                     |
| **@Size**         | Size must match the given size               |
| **@Pattern**      | Must match a regular expression pattern      |
| **@Future/@Past** | Data must be in future or past of given data |
| **others ...**    |                                              |

**The Hibernate**
+ Hibernate started as an ORM project
+ But in recent years, they have expanded into other areas
+ They have a fully compliant JSR-303 implementation
  + Not tied to ORM or database work ... separate project

_About the Version_
+ Hibernate Validator 7 is based on **Jakarta EE 9**
+ **Jakarta EE** is the community version of Java EE (rebranded, relicensed)
+ Allows innovation of **Jakarta EE** with community-driven approach
+ **Jakarta EE** does not replace Java EE
  + Last version is Java EE 8(August 2017)
  + **Jakarta EE** is moving forward with **Jakarta EE 9**(December 2020) and future releases

**Jakarta EE**
+ At the moment, main change with Jakarta EE ... package renaming
+ `javax.*` package are renamed to `jakarta.*`


+ For example
  + javax.servlet.http.HttpServlet is now jakarta.servket.http.HttpServlet
  + https://jakarta.ee/about

**What impact on Hibernate Validator??**
+ Hibernate Validator 7 is based on **Jakarta EE 9**
+ Spring 5 is still based on some components of Java EE(`javax.*`)
+ Spring may use Jakarta EE components in the future
+ As a result, Spring 5 is not compatible with Hibernate Validator 7


+ Two releases of Hibernate Validator
  + Hibernate Validator 7 is for Jakarta EE 9 project
  + Hibernate **Validator 6.2** is compatible with Spring 5

+ Hibernate Validator 6.2 has the **SAME** feature as Hibernate Validator 7

**In Summary**
+ If using Spring 5 ... then Hibernate Validator 6.x
+ If using Jakarta EE 9 ... then Hibernate Validator 7.x

## Checking for Required Fields Overview
**Required Field**

![image](https://user-images.githubusercontent.com/80107049/188125993-e426b493-8533-4cf9-8dc2-1f1fe4d4f600.png)



**Development Process**
1. Add validation rule to Customer class
2. Display error messages on HTML form
3. Perform validation in the Controller class
4. Update confirmation page

_Step 1:Add validation rule to Customer class_      
![image](https://user-images.githubusercontent.com/80107049/188125914-b72a2c58-3610-498d-a2bb-73b7b792e715.png)

_Step 2:Display error message on HTML form_

File:customer-form.jsp    
![image](https://user-images.githubusercontent.com/80107049/188125855-4f784214-65e6-4d65-8b46-27e2761199d5.png)


_Step 3:Perform validation in Controller class_

![image](https://user-images.githubusercontent.com/80107049/188125798-6862492d-487b-48a7-aa34-f80514b8193d.png)


_Step 4:Update confirmation page_

```HTML
<html>
  
  <body>
    
    The customer is confirmed: ${customer.firstName} ${customer.lastName}
    
  </body>
  
</html>
```

**Special Note about BindingResult Parameter Order**

When performing Spring MVC validation, the location of the BindingResult parameter is very important. In the method signature, **the BindingResult parameter must appear immediately after the model attribute**.

If you place it in any other location, Spring MVC validation will not work as desired. In fact, your validation rules will be ignored.
```JAVA
   @RequestMapping("/processForm")
        public String processForm(
                @Valid @ModelAttribute("customer") Customer theCustomer,
                BindingResult theBindingResult) {
            ...            
        }
```

***Defining @RequestMapping methods***

*@RequestMapping handler methods have a flexible signature and can choose from a range of supported controller method arguments and return values.  
...*

*The *`Errors`* or *`BindingResult`* parameters have to follow the model object that is being  
bound immediately ...*

*Source: *[*https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-methods*](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-methods)

## Add Pre-processing Code with @InitBinder - Overview

+ Our previous example had a problem with white space
  + **Last name** field with all whitespace passed...
  + Should have failed **!**

+ We need to trim whitespace from input fields

**@Initbinder**
+ @InitBinder annotation works as a pre-processor
+ It will pre-process each web request to our controller
+ Method annotated with **@InitBinder** is executed

<br>

+ Will use to trim String
  + Remove leading and trailing white space

+ If String has white spaces ... trim it to **null**
+ Will resolve validation problem ...





**Register Customer Editor in Controller**    
File:CustomerController.java
```Java
...
  
  @InitBinder
  public void initBinder(WebDataBinder dataBinder) {
  
    StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
  
    dataBinder.registerCustomerEditor(String.class, stringTrimmerEditor);
}

...
```
+ @InitBinder: pre-process all web requests coming into our Controller
+ `StringTrimmerEditor` is a class defined in Spring API
  + removes whitespace - leading and trailing
  + `new StringTrimmerEditor(true)` true - means trim to null






## Validating a Number Range - Overview

**Validate a Number Range**
+ Add a new input field on our form for:**Free passes**
+ User can only enter a range: 0 to 10

**Development Process**
1. Add validation rule to Customer class
2. Display error messages on HTML form
3. Perform validation in the Controller class
4. Update confirmation page



_Step 1:Add validation rule to Customer class_

```JAVA
import javax.validation.constraints.Min;
import javax.validation.constriants.Max;

public class Customer {
  
  @Min(value=0, message="must be greater than or equal to zero")
  @Max(value=10, message="must be less than or equal to 10")
  private int freePasses;
  
  // getter/setter methods
  
}
```

## Applying Regular Expressions - Overview

**Regular Expressions**
+ A sequence of characters that define a search pattern
  + This pattern is used to find or match strings

<br>

+ Regular expressions is like its own language
  + Plenty of free tutorials available
    + https://docs.oracle.com/javase/tutorial/essential/regex/

**Validate a Postal Code**
+ Add a new input field on our form for:**Postal Code**
+ User can only enter 5 chars / digits
+ Apply **Regular Expression**


**Development Process**
1. Add validation rule to Customer class
2. Display error messages on HTML form
3. Update confirmation page

_Step 1:Add validation rule to Customer class_
```JAVA
import javax.validation.constraints.Pattern;
public class Customer {
  
  @Pattern(regexp="^[a-zA-Z0-9]{5}", message="only 5 char/digits")
  private String postalCode;
  
  // getter/setter methods
  
}
```


**How to Handle String input for Integer Fields - Custom Message**

_Development Process_
1. Create custom error message
  + src/resources/messages.properties

![image](https://user-images.githubusercontent.com/80107049/188126108-aa9cd189-95ed-4e7a-9399-a8f43e3844c0.png)

2. Load custom messages resource in Spring config file
  + WebContent/WEB-INF/spring-mvc-demo-servlet.xml





##  Custom Form Validation - Overview
+ Perform custom validation based on your business rules
  + In example: Course Code must start with "HIS"

+ Spring MVC calls custom validation
+ Custom validation returns boolean value for pass/fail(true/false)

**Create a custom Java Annotation**
+ For custom validation ... we will crate a Custom Java Annotation
  + @CourseCode

![image](https://user-images.githubusercontent.com/80107049/188126350-bdd7c72a-574b-4727-bc51-e981b7a963ea.png)


**Development Process**
1. Create custom validation rule
  1. Create **@CourseCode** annotation
  2. Create **CourseCodeConstraintValidator**
    + Helper class, Contains custom business logic for validation
2. Add validation rule to Customer class
3. Display error messages on HTML form
4. Update confirmation page

_Step 1a:Create @CourseCode annotation_

![image](https://user-images.githubusercontent.com/80107049/188126285-63d17846-2402-42e8-99c9-c7b0065aee7c.png)


_Step 1b:Create CourseCodeConstraintValidator_


![image](https://user-images.githubusercontent.com/80107049/188126227-b9956294-4433-45c1-89a3-74b328fdb172.png)



**Question:**

Is it possible to integrate multiple validation string in one annotation? For example, validate against both HIS and SS.

**Answer:**

Yes, you can do this. In your validation, you will make use of an array of strings.

Here's an overview of the steps.

1. Update CourseCode.java to use an array of strings

2. Update CourseCodeConstraintValidator.java to validate against array of strings

3. Update Customer.java to validate using array of strings


**Detailed Steps**

**1. Update CourseCode.java to use an array of strings**

Change the value entry to an array of Strings:
```JAVA
 // define default course code
    public String[] value() default {"HIS"};
```
Note the use of square brackets for the array of Strings. Also, the initialized value uses curley-braces for array data.

**2. Update CourseCodeConstraintValidator.java to validate against array of strings**

Change the field for coursePrefixes to an array

`private String[] coursePrefixes;`


Update the isValid(...) method to loop through the course prefixes. In the loop, check to see if the code matches any of the course prefixes.

```JAVA
    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {

        boolean result = false;

        if (theCode != null) {

            //
            // loop thru course prefixes
            //
            // check to see if code matches any of the prefixes
            //
            for (String tempPrefix : coursePrefix) {
                result = theCode.startsWith(tempPrefix);

                // if found a match then break out the loop
                if (result) {
                    break;
                }
            }
        } else {
            result = true;
        }

        return result;
    }
```

**3. Update Customer.java to validate using array of strings**
```JAVA
 @CourseCode(value={"HIS", "SS"}, message="must start with HIS or SS")
    private String courseCode;
```
Note the use of curley braces.




