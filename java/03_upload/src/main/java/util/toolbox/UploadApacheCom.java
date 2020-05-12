package util.toolbox;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;

@WebServlet(name = "UploadApacheCom", urlPatterns = {"/upload"})

public class UploadApacheCom extends HttpServlet {
	
	private final String STR_FOLDER = "upload";
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		String msg = "";
	
		// Run-time folder
		String sSavePath = request.getServletContext().getRealPath("");
		sSavePath = sSavePath + File.separator + STR_FOLDER;
		
		File fileSaveDir = new File(sSavePath);
		if (!fileSaveDir.exists() ) 
			fileSaveDir.mkdir();
		
		// Apache common upload ServletFileUpload start
		if ( ServletFileUpload.isMultipartContent(request) ) {
			
			ServletFileUpload upload = new ServletFileUpload( new DiskFileItemFactory());
		    try {
			List<FileItem> multiple = 	new ServletFileUpload( new DiskFileItemFactory()).parseRequest(request);			
			for (FileItem item: multiple) {
				
				if (item.isFormField()) {
					// implement when there is....
				} else {
					// upload file 
					String sName = new File(item.getName()).getName();
					item.write(new File(sSavePath + File.separator +sName));
					msg += "File uploaded "+ sName;
				}		
			}
		
		    } catch (Exception e) {
                         msg += "File upload failed : "+ e;
                    }

		    
		}
		
		// Finalize
		msg = "Process complete. " + msg;
		request.setAttribute("message", msg);
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}
			
}
