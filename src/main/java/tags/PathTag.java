package tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class PathTag extends TagSupport {
    String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public int doStartTag() throws JspException {
            pageContext.getSession().setAttribute("path",path);
        return SKIP_BODY;
    }
}

