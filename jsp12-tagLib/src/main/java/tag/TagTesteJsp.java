package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagTesteJsp extends SimpleTagSupport {
	
	@Override
	public void doTag() throws JspException, IOException {
		JspWriter jspWriter = getJspContext().getOut();
		jspWriter.println("Esta é uma TagLib customizada");
	}

}
