<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!Doctype Html>
<Html>
<Head>
<Title>
Make a Navigation Bar
</Title>
<style type=text/css>
body
{
height: 125vh;
margin-top: 80px;
padding: 30px;
background-size: cover;
font-family: sans-serif;
}
header {
background-color: orange;
position: fixed;
left: 0;
right: 0;
top: 5px;
height: 30px;
display: flex;
align-items: center;
box-shadow: 0 0 25px 0 black;
}
header * {
display: inline;
}
header li {
margin: 20px;
}
header li a {
color: blue;
text-decoration: none;
}
</style>
</Head>
<Body>
<header>
<nav>
<ul>
<li>
<a href="product"> product </a>
</li>
<li>
<a href="sales"> sales </a>
</li>
<li> <a href="buyers"> buyers</a>
</li>
</ul>
</nav>
</header>
Bine ai venit......
</Body>
</Html>