1. Scriptlet Tag:
Scriptlets are used to embed any Java code fragments in the JSP page.

For example: <% i++; %>     

Here the scriptlet tag is executed and the value of i is incremented each time the page is requested. We can use scriptlets for printing HTML statements also. For e.g.:

<%@ page language="java" %>
<%! int i = 0; %>
<%
   out.print("");        
   i++;
   out.print("The value of i is now:  " + i);
   out.print("");
%>

2. Declaration Tag:
Declarations declare and define variables and methods that can be used in the JSP page 
(a JSP declaration can contain any valid Java declaration including inner classes and static code blocks. 
However, such declarations are rarely used). A declaration always starts with <%! and ends with %>.

For e.g.: <%! int i = 0; %>


3. Expression Tag:
Expression tags are used as a shortcut to print values in the output HTML in a JSP page. Syntax of Expression tag is:

<%= variable %>  


4. Directive Tag:
Directive tags provide general information about the JSP page to the JSP engine. 
A directive tag always starts with <%@ and ends with %>.

There are 3 types of directives: page, include, and taglib.

The general syntax for the 3 directives is:

<%@ page attribute-list %>
<%@ include attribute-list %>
<%@ taglib attribute-list %>

A page directive informs the JSP engine about the overall properties of a JSP page. 
For example, the following page directives inform the JSP engine that Java will be used as scripting language in our JSP page:

<%@ page language=”java” %>

An include directive tells the JSP engine to include the contents of another file (HTML, JSP, etc) into the current file. 
For example:

<%@ include file=”test.html” %>

             or

<%@ include file=”test.jsp” %>

A taglib directive is used to associate a prefix with a tag library. For example:

<%@ taglib prefix=”test” uri=”taglib.tld” %>