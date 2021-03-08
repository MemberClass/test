package member.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import member.svc.MemberViewService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberViewAction implements Action, action.Action{
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 	
		 	HttpSession session=request.getSession();
	   		String id=(String)session.getAttribute("id");
	   		
	   		ActionForward forward = null;
	   		if(id==null){
	   			forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("./memberLogin.me");
	   		}else if(!id.equals("admin")){
	   			response.setContentType("text/html;charset=euc-kr");
		   		PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('�����ڰ� �ƴմϴ�.');");
		   		out.println("location.href='./memberLogin.me';");
		   		out.println("</script>");
	   		}
	   		
	   		else{
	   		forward = new ActionForward();
	   		String viewId=request.getParameter("id");
	   		MemberViewService memberViewService = new MemberViewService();
	   		MemberBean member=memberViewService.getMember(viewId);
	   		request.setAttribute("member", member);
	   		forward.setPath("./member_info.jsp");
	   		}
	   		return forward;
	}
}