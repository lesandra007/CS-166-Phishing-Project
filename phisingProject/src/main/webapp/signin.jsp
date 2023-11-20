<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%--@elvariable id="form" type="List<com.example.demo.Bean>"--%>

<!DOCTYPE html>
<html>
    <body>
        <div class="container-sm mt-5" style="max-width: 600px">
            <h3>Sign In</h3>

            <form method="POST">
                <div class="mb-3">
                   <label for="studentID" class="form-label">SJSU ID Number</label>
                   <div id="student_id" class="form-text">#########</div>
                   <input type="text" name="username" class="form-control">
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Password</label>
                    <div id="emailHelp" class="form-text">SJSUOne Password</div>
                    <input type="text" name="password" class="form-control"">
                </div>
                <button type="submit" class="btn btn-primary" name="action" value="submit">Submit</button>
            </form>
        </div>
    </body>
</html>