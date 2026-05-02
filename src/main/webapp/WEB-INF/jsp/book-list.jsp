<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book List</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 20px; background-color: #f4f4f9; }
        h2 { color: #333; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; background: white; }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background-color: #007bff; color: white; }
        tr:nth-child(even) { background-color: #f2f2f2; }
        .btn { padding: 8px 12px; text-decoration: none; border-radius: 4px; color: white; font-size: 14px; }
        .btn-add { background-color: #28a745; margin-bottom: 10px; display: inline-block; }
        .btn-edit { background-color: #ffc107; color: black; }
        .btn-delete { background-color: #dc3545; }
        .actions { display: flex; gap: 5px; }
    </style>
</head>
<body>
    <h2>Book Management System</h2>
    <a href="/books/add" class="btn btn-add">Add New Book</a>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>ISBN</th>
                <th>Price</th>
                <th>Author</th>
                <th>Nationality</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td>${book.id}</td>
                    <td>${book.title}</td>
                    <td>${book.isbn}</td>
                    <td>$${book.price}</td>
                    <td>${book.author.name}</td>
                    <td>${book.author.nationality}</td>
                    <td class="actions">
                        <a href="/books/edit/${book.id}" class="btn btn-edit">Edit</a>
                        <a href="/books/delete/${book.id}" class="btn btn-delete" onclick="return confirm('Are you sure?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
