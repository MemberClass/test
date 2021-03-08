package action;

import java.io.PrintWriter;

import javax.naming.Context;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.DogRegistService;
import vo.ActionForward;
import vo.Dog;

public class DogRegistAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DogRegistService DogReistService = new DogRegistService();
		String realFolder = "";
		String saveFolder = "/images";
		String encType = "UTF-8";
		int maxSize = 5 * 1024 * 1024;

		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType,
				new DefaultFileRenamePolicy());
		String image = multi.getFilesystemName("image");
		Dog dog = new Dog(0, multi.getParameter("kind"),Integer.parseInt(multi.getParameter("price")),image,multi.getParameter("nation"),
			 Integer.parseInt(multi.getParameter("height")),Integer.parseInt(multi.getParameter("weight")),
				multi.getParameter("content"),0);
		
		boolean isRegistSuccess =DogReistService.registDog(dog);
		ActionForward forward=null;
		
		if(isRegistSuccess) {
			forward=new ActionForward("dogList.dog",true);
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패')");
			out.println("history.back();");
			out.println("</script>");
		}
		return forward;
	}

}
