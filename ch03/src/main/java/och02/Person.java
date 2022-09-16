package och02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Person
 */
@WebServlet("/Person")
public class Person extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Person() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("name");
		String id   = request.getParameter("id");
		String password   = request.getParameter("password");
		String gender     = request.getParameter("gender");
		String[] notice   = request.getParameterValues("notice"); //getParameterValues : 배열값을 출력할때 사용한다.
		String job        = request.getParameter("job");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>개인정보</h1>");
		out.println("이름 :"   +name     +"<p>");
		out.println("아이디 :"  +id       +"<p>");
		out.println("암호 :"   +password +"<p>");
		out.println("성별 :"   +gender   +"<p>");
		out.println("메일수신 :");
			if(notice != null) {
				for(int i=0; i<notice.length; i++) {
					out.println(notice[i] + " ");
				}
			}else out.println("없음");   //function에서 선택리밋을 풀고 아무것도 선택하지 않았을때 나온다.
		out.println("<p>직업 :"   +job      +"<p>");
		out.println("</body></html>");
		out.close();
	}

}
