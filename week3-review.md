## HTML
1.	What is HTML?
    - Hyper Text Markup Language (HTML) is a type of markup used to specify the structure and content of web pages.
2.	What is the HTML5 doctype declaration?
	- `<!DOCTYPE html>`
	- The Doctype declaration is not case sensitive.
	- Doctype declarations are now optional for html5 documents.
3.	List some tags. What is `<head>` used for? `<body>`?
	- `<html>`, `<head>`, `<body>`, `<p>`, `<div>`, `<a>`, `<img>`
	- `<head>` is the parent element for metadata about the document. For example, `<title>`, `<link>`, and `<script>` are all elements that belong inside the `<head>`.
	- `<body>` is the container element for the contents of an html document.
4.	What are the required tags for an HTML document?
	- `<html>`, `<head>`, `<body>`, and `<title>` are required for an html document.
5.	What is the tag for ordered list? unordered list? Change bullet styling?
	- `<ol>` is the tag for an ordered list.
	- `<ul>` is the tag for an unordered list.
	- `<li>` is the tag for a list item within either type of list.
	- `<ul style="list-style-type:square>` would, for example, change the style of the bullet points in an unordered list to be little squares.
6.	What features came with HTML5? Are HTML 5 tags different from other tags?
	- html5 has more features and tags than html4. 
	- html5 includes support for web sockets and multimedia.
	- html5 tags are largely the same as tags from other versions of html. html5 is backwards-compatible, but introduces some new tags (like `<canvas>`) and redefines a few old tags (like `<abbr>` vs `<acronym>`). 
7.	Do all tags come in a pair? List a self-closing tag.
	- Not all tags come in a pair. Some tags are self-closing.
	- For example: `<img src="example.jpg" />`
8.	What’s the difference between an element and an attribute? List some global attributes.
	- An html element is defined by a tag and contains everything from the start to the end of the tag.
	- An html attribute provides additional information about an htlm element. An attribute is defined within the opening tag of an element.
	- As an example, `<a>` would be the element, `href` would be the attribute.
	- `class`, `id`, and `style` are some global attributes. All elements have these attributes.
9.	What is the syntax for a comment in HTML?
	- `<!-- -->` is the syntax for a comment in html.
10.	What tags would you use to create a table? A navbar? What about a form?
	- A table is defined with the `<table>` tag. Rows are defined with `<tr>` and header rows are defined with `<th>`. Within a row, table cells are defined with `<td>`. A table may also include a header (`<thead>`), a body (`<tbody>`), and a footer (`<tfoot>`). 
	- A navbar can be deifined using a generic `<div>` container element containing an unordered list of `<a>` elements with links pointing towards other pages. A navbar could also be specified using a more specific `<nav>` element containing a list of `<a>` elements.
	- A form is defined with the `<form>` tag. The form tag contains the `method` and `action` attributes. A form element can contain many types of input and output elements including `<button>`, `<lable>`, `<select>`, and `<input>`.
11.	What’s the difference between a class and id?
	- A class labels a group of elements that belong to the same group. Classes allow elements to share the same styling or script functionality. An element can have more than one class.
	- An id is a unique identifier for a specific element. No other element in the entire website should share the same id.
	- An element can have both a class and an id.
	- Id is a more specific selector, so it can be used to override the class selector when styling a webpage.
12.	How would you include CSS into an HTML document?
	- In-line css is defined using the `style` attribute.
	- Internal css is defined using a `<style>` element in the `<head>` of an html document.
	- External css is defined by linking a separate css file in the head with a `<link>` element.
13.	What is a semantic tag?
	- A semantic tag desacribes the contents of the element. For example, `<article>` is a semantic element, while `<div>` is a non-semantic element. The `<article>` tag contains self-contained content that can stand on its own. A `<div>` element could contain any type of content.

## CSS
1.	What is CSS? what are the different ways of styling an html file?
	- Cascading Style Sheets (CSS) is the language used to add style to an html document. CSS describes how an html element should be displayed.
	- html files can be styled with inline, internal, or external css styling. (html question 12)
2.	Which way has highest priority when styles cascade: inline, internal, and external stylesheets. Which is best practice? Why?
	- Inline has the highest priority, then internal, then external.
	- External style sheets are the best practice. External style sheets can be reused across all pages within a website in order to maintain a consistent style throughout the site.
3.	What are the different CSS selectors? Write the syntax for each.
	- Selectors are patterns used to select the element(s) to be styled by a specific command.
	- An html element can be selected with the tag name. For example, all `<p>` elements can be selected with the selector `p`.
	- All members of a given class can be selected with the class name. All elements where `class=heading` can be selected with the selector `.heading`.
	- A specific element with an id can be selected with the value of the id. For example an element with attribute `id=pizzaDiv` can be selected with the selector `#pizzaDiv`.
	- Selectors can be combined to target more and more specific elements. In CSS, the most specific selector has priority over the styling of an element.

## Spring Core
1.	What are Spring Projects and Spring Modules?
	- Spring Projects are implementations of the Spring framework that focus on specific industry concerns. Spring Projects include different modules, dependencies, and default configurations geared towards addressing a specific concern. Different Spring Projects include Spring Boot, Spring Security, Spring Cloud, and Spring Data.
	- Spring Modules are different features that within the Spring Framework which address a specific sliver of functionality within an application. An application built using the Spring Framework will levergae several Spring Modules in order to implement different parts of the application. Spring Modules include Spring Core, Spring Beans, Spring Context, Spring WebMVC, Spring AOP, and Spring ORM.
2.	What is IOC and what does the IOC Container do?
	- Inversion of Control (IOC) is a design principle that addresses coupling within a code base. A class will give up control over its dependencies in order to reduce the coupling between the two classes.
	- The IOC Container is responsible for handling dependencies within an application. The IOC container will instantiate and provide dependencies to classes to reduce the coupling between them.
	- The IOC Container specifically manages depecndencies between Spring Beans. The IOC Container handles instantiation and destruction of a Bean.
3.	What is dependency injection and what are some of the benefits of using dependency injection?
	- Dependency Injection is how Spring implements IoC. When a client class uses the features of a service class, it requires an implementation of that class in order to use its class methods. With dependency injection, a different class (managed by Spring) will provide the instance of the service class to the client class. This separates the responsibility of managing dependencies from the class itself.
	- Dependency injection reduces coupling between classes. Loosely coupled code is easier to maintain, test, read, extend, and reuse. Dependency injection allows Spring to manage the lifecycle of a Bean for us.
4.	What types of dependency injection does Spring support?
	- Spring supports field injection, setter/method injection, and constructor injection.
5.	What are some differences between BeanFactory and ApplicationContext? Which one eagerly instantiates your beans?
	- The BeanFactory is an older version of the IOC Container. It used lazy loading to instantiate Beans.
	- ApplicaitonContext is the current IOC Contatiner version. It eagerly instantiates Beans.
6.	What is the Spring Bean lifecycle?
	- The Life Cycle of a Spring bean is the collection of steps the responsible IOC Container needs to take in order to correctly instantiate and destroy the bean. The framework may require several pre- and post-initialization and pre- and post-destruction callback methods as part of a bean's Life Cycle.
	- The Bean Life Cycle may be customized.
7.	What is bean wiring? What about autowiring?
	- Bean wiring refers to the establishment of dependencies between beans.
	- Autowiring allows Spring to manage the establishment of dependencies. We use the `@Autowired` annotation to inform Spring that a bean should be managed as a dependency.
8.	What are the different ways that Spring can wire beans?
	- Field injection is done by annotating the field with `@Autowired`. Field injection is discouraged, as it violates data encapsulation.
	- Setter/Method injection is done by annotating a setter method for the field with `@Autowired`.
	- Constructor injection is done by annotating the class constructor with `@Autowired`. This one annotation can be used to wire multiple beans.
9.	What are the scopes of Spring beans? Which is default?
	- The Singleton scope of a Spring bean will create a bean once, then return the same instance to all classes requesting the bean. The Singleton scope is the default.
	- Prototype scope returns a new instance every time a bean is requested.
	- There are also three Web Related scopes.
		- The Request scope returns a new bean per HTTP Request.
		- The Session scope returns a new bean per HTTP Session.
		- The Global scope returns a new bean per global HTTP Session.
10.	What does the @Configuration and @Bean annotations do?
	- The `@Configuration` annotation is placed over a class that uses one or more `@Bean` methods. This annotation tells Spring to generate bean definitions and service requests for those beans at runtime.
	- The `@Bean` annotation is placed over a method to signify that the returned object should be managed by Spring.
11.	List some stereotype annotations. What are the differences between these?
	- `@Component` is the standard stereotype annotation. It is used to mark a class as a managed bean. Other seterotype annotations include this annotation implicitly.
	- `@Service` marks a class as a service component.
	- `@Controller` is used to signify that a class is a controller and handles HTTP requests in conjunction with Spring WebMVC.
	- `@Repository` denotes a repository or dao. A repository interacts with the persistence layer of an application in conjunction with SpringData JPA.

## Spring MVC
1.	Explain the MVC architecture and how HTTP requests are processed in the architecture
	- MVC stands for Model View Controller. MVC uses separation of concerns to break up the frontend and backend of an application. HTTP requests are handled by the controller. The controller has methods to hanle each request at a particular endpoint and accesses the model (backend logic) to perform the requested functionality. A controller may return either raw data (often in JSON) or a View (html document).
2.	What is the role of the DispatcherServlet? What about the ViewResolver?
	- The DispatcherServlet accepts all requests and then maps them to the relevant controller.
	- The ViewResolver maps the view names used in the implementation of a controller to an actual view.
3.	How would you declare which HTTP requests you’d like a controller to process?
	- A Controller can use the `@RequestMapping` annotation to only accept requests made to a certain path.
4.	What is the difference between @RequestMapping and @GetMapping?
	- `@RequestMapping` takes a path and a verb as parameters.
	- `@GetMapping` specifies the verb 'get' as part of the annotation istself, so only takes a path as a parameter. Other similar maaping methods exist for the other HTTP verbs.
5.	How to declare the data format your controller expects from requests or will create in responses?
6.	What annotation would you use to bypass the ViewResolver?
	- `@ResponseBody` is used to bypass the ViewRewsolver. It tells Spring that the controller method will return raw data as a response.
	- `@RestController` implicitly includes `@ResponseBody` on all methods in that class.
7.	How would you extract query and path parameters from a request URL in your controller?
8.	What concerns is the controller layer supposed to handle vs the service layer?
9.	How would you specify HTTP status codes to return from your controller?
10.	How do you handle exceptions thrown in your code from your controller? What happens if you don’t set up any exception handling?
11.	What is the difference between @Controller and @RestController?

## Spring Data
1.	What is JPA?
2.	What is Spring ORM and Spring Data?
3.	What interfaces are available in Spring Data JPA?
4.	What is the naming conventions for methods in Spring Data repositories?
5.	What is @Query used for?

## Spring Boot
1.	How is Spring Boot different from legacy Spring applications? What does it mean that it is “opinionated”?
2.	What does “convention over configuration” mean?
3.	What annotation would you use for Spring Boot apps? What does it do behind the scenes?
4.	How does Boot’s autoconfiguration work?
5.	What is the advantage of having an embedded Tomcat server?
6.	What is the significance of the Spring Boot starter POM?
7.	What is the Spring Boot actuator? What information can it give you?
8.	What files would you use to configure Spring Boot applications?
9.	What is the benefit of using Spring Boot profiles?

## REST
1.	What does the acronym REST stand for? What makes a service “RESTful”?
2.	What protocols and data format do REST services use?
3.	What are the architectural constraints of REST?
4.	Explain the levels of the Richardson Maturity Model
5.	Explain the HATEOAS concept
6.	What is a “resource” in a REST service?
7.	What does the “uniform interface” constraint mean? Give an example of some RESTful endpoints you would create for an API. Should the URLs contain nouns, verbs, or adjectives?
8.	How would you implement authentication/authorization in a RESTful web service while maintaining statelessness?

## HTTP
1.	What does HTTP stand for?
2.	What are the components inside of an HTTP request? What about an HTTP response?
3.	What are the important HTTP verbs / methods and what do they do?
	1.	Which are idempotent?
	2.	Which are safe?
4.	List the levels of HTTP status codes and what they mean
5.	What are some specific HTTP status codes that are commonly used?

## SDLC
1.	What are the steps in the software development lifecycle?
2.	What is the difference between Waterfall and Agile methodologies? Explain the benefits and drawbacks of each
3.	List some of the principles declared in the Agile manifesto
4.	What specific Agile frameworks exist? What are the main features of each?
5.	What is the Scrum process? Explain each of the Scrum ceremonies
6.	How long is a typical sprint?
7.	What is a “standup” and what should you report about your work?
8.	What is the role of a “Scrum master” in a project? What about the “Product owner”?
9.	Explain the following metrics/charts: sprint velocity, burndown chart
10.	What is a Scrum board?

## SRE
1.	What is SRE?
2.	What is toil?
3.	What are the responsibilities of an SRE?
4.	Define SLA, SLO, SLI.
5.	How does SRE differ from the traditional development/operation split?