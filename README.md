# Spring MVC - Building Spring Web Apps

**What is Spring MVC?**
+ Framework for building web applications in Java
+ Based on Model-View-Controller design pattern
+ Leverages feature of the Core Spring Framework(IoC, DI)

**Model-View-Controller(MVC)**


<img src="https://user-images.githubusercontent.com/80107049/187021053-7a826ede-9526-41f4-a247-bc33758821d7.png" width=600 />


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


