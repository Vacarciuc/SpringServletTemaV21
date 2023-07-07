<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="shortcut icon" type="image/png" href="/favicon.png">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">

    <link rel="stylesheet" href="/styles.css">
    <title>Spring Boot + JSP</title>
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
</head>

<body>
    <header>
    <nav>
    <ul>
    <li>
    <a href="index"> acasa </a>
    </li>
    <li>
    <a href="sales"> sales </a>
    </li>
    <li> <a href="buyers"> buyers</a>
    </li>
    </ul>
    </nav>
    </header>
   <div class="container">

      <div class="title">
        <h1>Produse</h1>
      </div>

      <c:choose>
        <c:when test="${not empty productList}">
            <table class="table table-bordered">
                <thead>
                    <tr>
                	    <th>ID</th>
                	    <th>Nume</th>
                    	<th>Descriere</th>
                	    <th>Stoc</th>
            			<th>Pret</th>
            			<th>Operatiune</th>
               		</tr>
                </thead>
                	<tbody>
                	    <c:forEach items="${productList}" var="product">
                            <tr>
                                <td><p>${product.id}</p><br/></td>
                                <td><p>${product.nameProduct}</p><br/></td>
                                <td><p>${product.descriptionProduct}</p><br/></td>
                                <td><p>${product.stock}</p><br/></td>
                                <td><p>${product.price}</p><br/></td>
                                <td><form action="/delete_product">
                                        <input name="productId" hidden value=${product.id}>
                                        <button type="submit" class="btn btn-lg btn-block btn-primary">Sterge</button>
                                     </form>
                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                     <form action="/saveId">
                                         <input name="productId" hidden value=${product.id}>
                                         <button type="submit" class="btn btn-lg btn-block btn-primary" onclick="updateProduct.jsp">Editeaza</button>
                                     </form>
                                </td>
                            </tr>
                        </c:forEach>
                	</tbody>
            </table>
        </c:when>
            <c:otherwise>
                <b>NO DATA</b>
            </c:otherwise>

        </c:choose>
    </div>

    <footer class="footer">
      <div class="container">
        <p class="text-muted"><a href="insertProduct">Adauga produs</a></p>
      </div>
    </footer>

</body>

</html>