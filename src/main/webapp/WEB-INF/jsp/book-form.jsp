<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>${book.id == null ? 'Add Book' : 'Edit Book'}</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; background-color: #f4f4f9; }
        .container { max-width: 500px; background: white; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        h2 { color: #333; }
        .form-group { margin-bottom: 15px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input, select { width: 100%; padding: 8px; border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box; }
        .btn { padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer; color: white; font-size: 16px; }
        .btn-save { background-color: #007bff; }
        .btn-cancel { background-color: #6c757d; text-decoration: none; display: inline-block; text-align: center; }
        .error { color: red; margin-bottom: 10px; }
    </style>
</head>
<body>
    <div class="container">
        <h2>${book.id == null ? 'Add New Book' : 'Edit Book'}</h2>
        
        <c:if test="${param.error != null}">
            <div class="error">Error: Data integrity violation. Please check your inputs.</div>
        </c:if>

        <form action="/books/save" method="post">
            <input type="hidden" name="id" value="${book.id}" />
            
            <div class="form-group">
                <label>Title:</label>
                <input type="text" name="title" value="${book.title}" required />
            </div>
            
            <div class="form-group">
                <label>ISBN:</label>
                <input type="text" name="isbn" value="${book.isbn}" required />
            </div>
            
            <div class="form-group">
                <label>Price:</label>
                <input type="number" step="0.01" name="price" value="${book.price}" required />
            </div>
            
            <div class="form-group">
                <label>Author:</label>
                <select name="author.id" required>
                    <option value="">Select Author</option>
                    <c:forEach var="author" items="${authors}">
                        <option value="${author.id}" ${book.author.id == author.id ? 'selected' : ''}>
                            ${author.name} (${author.nationality})
                        </option>
                    </c:forEach>
                </select>
            </div>
            
            <button type="submit" class="btn btn-save">Save</button>
            <a href="/books" class="btn btn-cancel">Cancel</a>
        </form>
    </div>
</body>
</html>
