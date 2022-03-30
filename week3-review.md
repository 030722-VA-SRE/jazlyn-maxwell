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
	- Cascading Style Sheets (CSS) 
2.	Which way has highest priority when styles cascade: inline, internal, and external stylesheets. Which is best practice? Why?
3.	What are the different CSS selectors? Write the syntax for each.

## Spring Core
1.	What are Spring Projects and Spring Modules?
2.	What is IOC and what does the IOC Container do?
3.	What is dependency injection and what are some of the benefits of using dependency injection?
4.	What types of dependency injection does Spring support?
5.	What are some differences between BeanFactory and ApplicationContext? Which one eagerly instantiates your beans?
6.	What is the Spring Bean lifecycle?
7.	What is bean wiring? What about autowiring?
8.	What are the different ways that Spring can wire beans?
9.	What are the scopes of Spring beans? Which is default?
10.	What does the @Configuration and @Bean annotations do?
11.	List some stereotype annotations. What are the differences between these?

## Spring MVC
1.	Explain the MVC architecture and how HTTP requests are processed in the architecture
2.	What is the role of the DispatcherServlet? What about the ViewResolver?
3.	How would you declare which HTTP requests you’d like a controller to process?
4.	What is the difference between @RequestMapping and @GetMapping?
5.	How to declare the data format your controller expects from requests or will create in responses?
6.	What annotation would you use to bypass the ViewResolver?
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