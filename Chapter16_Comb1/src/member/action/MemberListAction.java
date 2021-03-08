package member.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import member.svc.MemberListService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberListAction implements Action, action.Action{
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
	   			response.setContentType("text/html;charset=UTF-8");
		   		PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('�����ڰ� �ƴմϴ�.');");
		   		out.println("location.href='./memberLogin.me");
		   		out.println("</script>");
	   		}
	   		else{
	   	    forward = new ActionForward();
	   	    MemberListService memberListService = new MemberListService();
	   		ArrayList<MemberBean> memberList=memberListService.getMemberList();
	   		request.setAttribute("memberList", memberList);
	   		forward.setPath("./member_list.jsp");
	   		}
	   		return forward;
	}
}