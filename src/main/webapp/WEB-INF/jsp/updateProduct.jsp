<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
  integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  <meta charset="UTF-8">
  <title>updateProduct</title>
</head>
<body>
<form action="/updateproduct" style="width:400px;margin:auto;">
  <p>Introduceti date produs</p>
  <table class="product">
    <tbody>
    <tr>

      <td>nume</td>
      <td><input name ="nume" type="text"  class="form-control" id="exampleInputnume" aria-describedby="textHelp" value="comment">
      </td>
    </tr>
    <tr>
      <td>descriere</td>
      <td><input name ="descriere" type="text" class="form-control" id="exampleInputdescriere" aria-describedby="textlHelp">
      </td>
    </tr>
    <tr>
      <td>stoc</td>
      <td><input name ="stoc" type="number" class="form-control" id="exampleInputstoc" aria-describedby="numberHelp">
      </td>
    </tr>
    <tr>
      <td>pret</td>
      <td><input name ="pret" type="number" class="form-control" id="exampleInputpret" aria-describedby="numbHelp">
      </td>
    </tr>
    </tbody>
  </table>
  <button type="submit" class="btn btn-primary">Efectueaza</button>
</form>
<p th:text="${message}"></p>

</body>
</html>