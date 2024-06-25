<%@ page import="java.sql.*" %>
<%@ page contentType="text/plain; charset=UTF-8" %>
<%
    String classId = request.getParameter("classId");
    String result = "";

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "your_username", "your_password");
        String sql = "SELECT c_id FROM classes WHERE c_id = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, classId);
        rs = stmt.executeQuery();

        if (rs.next()) {
            result = "exists";
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    out.print(result);
%>
