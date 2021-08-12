package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/view/components/header.jsp");
    _jspx_dependants.add("/view/components/right.jsp");
    _jspx_dependants.add("/view/components/footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_url_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_url_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_url_value_nobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      if (_jspx_meth_c_url_0(_jspx_page_context))
        return;
      out.write("\">\n");
      out.write("        <title>My Font Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"wapper\">\n");
      out.write("            ");
      out.write("\n");
      out.write("<div id=\"header\">\n");
      out.write("    <div id=\"header-nav\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <ul class=\"nav-link\">\n");
      out.write("                <li><a href=\"\">My front page</a></li>\n");
      out.write("                <li><a href=\"\">Gallery 1</a></li>\n");
      out.write("                <li><a href=\"\">Gallery 2</a></li>\n");
      out.write("                <li><a href=\"\">Gallery 3</a></li>\n");
      out.write("                <li><a href=\"\">Contact</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div id=\"header-title\">\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <a class=\"logo\" href=\"\"><img src=\"images/logo.png\" alt=\"\"></a>\n");
      out.write("            <div class=\"title\">\n");
      out.write("                <a href=\"\">PHOTOGRAPHER</a>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"subtitle\">Welcome to this website</div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</div>");
      out.write("\n");
      out.write("            <div id=\"content\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div id=\"left\">\n");
      out.write("                        <div class=\"left-home\">\n");
      out.write("                            <img class=\"home-image\" src=\"..//view/images/homeImage.jpg\" alt=\"\">\n");
      out.write("                            <i>Lorem ipsum dolor sit amet</i>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"category\">\n");
      out.write("                            <div class=\"category-gallery\">\n");
      out.write("                                <img src=\"..//view/images/img7.jpg\" alt=\"\">\n");
      out.write("                                <h4><a class=\"title-gallery\" href=\"\">View Gallery 1 </a></h4>\n");
      out.write("                                <p class=\"line-height\">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam\n");
      out.write("                                    nonummy nibh euismod\n");
      out.write("                                    tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam,\n");
      out.write("                                    quis\n");
      out.write("                                    nostrud exerci tation</p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"category-gallery\">\n");
      out.write("                                <img src=\"..//view/images/img6.jpg\" alt=\"\">\n");
      out.write("                                <h4><a class=\"title-gallery\" href=\"\">View Gallery 2 </a></h4>\n");
      out.write("                                <p class=\"line-height\">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam\n");
      out.write("                                    nonummy nibh euismod\n");
      out.write("                                    tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam,\n");
      out.write("                                    quis\n");
      out.write("                                    nostrud exerci tation</p>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"category-gallery\">\n");
      out.write("                                <img src=\"..//view/images/img8.jpg\" alt=\"\">\n");
      out.write("                                <h4><a class=\"title-gallery\" href=\"\">View Gallery 3 </a></h4>\n");
      out.write("                                <p class=\"line-height\">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam\n");
      out.write("                                    nonummy nibh euismod\n");
      out.write("                                    tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam,\n");
      out.write("                                    quis\n");
      out.write("                                    nostrud exerci tation</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"about-me\">\n");
      out.write("                            <h3>About me</h3>\n");
      out.write("                            <p class=\"line-height\">Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam\n");
      out.write("                                nonummy\n");
      out.write("                                nibh euismod tincidunt\n");
      out.write("                                ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud\n");
      out.write("                                exerci\n");
      out.write("                                tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat.Nam liber\n");
      out.write("                                tempor\n");
      out.write("                                cum soluta nobis, Duis autem vel eum\n");
      out.write("                                iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu\n");
      out.write("                                feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit\n");
      out.write("                                praesent\n");
      out.write("                                luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum\n");
      out.write("                                soluta\n");
      out.write("                                nobis eleifend option congue nihil imperdiet doming id quod mazim</p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                     ");
      out.write("\n");
      out.write("<div id=\"right\">\n");
      out.write("    <div class=\"sidebar\">\n");
      out.write("        <div class=\"header-sidebar\">\n");
      out.write("            <h4>Share this page</h4>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"content-sidebar\">\n");
      out.write("            <a class=\"share-facebook\" href=\"\">Share on Facebook</a>\n");
      out.write("            <a class=\"share-twitter\" href=\"\">Share on Twitter</a>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"wapper-sidebar\"></div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("             ");
      out.write("\n");
      out.write("<div id=\"footer\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"footer-counter\">\n");
      out.write("            <span class=\"footer-page-counter-item\">1</span>\n");
      out.write("            <span class=\"footer-page-counter-item\">0</span>\n");
      out.write("            <span class=\"footer-page-counter-item\">8</span>\n");
      out.write("            <span class=\"footer-page-counter-item\">4</span>\n");
      out.write("            <span class=\"footer-page-counter-item\">9</span>\n");
      out.write("            <span class=\"footer-page-counter-item\">0</span>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"clear-both\"></div>\n");
      out.write("    </div>\n");
      out.write("</div>");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_url_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_0.setPageContext(_jspx_page_context);
    _jspx_th_c_url_0.setParent(null);
    _jspx_th_c_url_0.setValue("/view/css/style.css");
    int _jspx_eval_c_url_0 = _jspx_th_c_url_0.doStartTag();
    if (_jspx_th_c_url_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_0);
      return true;
    }
    _jspx_tagPool_c_url_value_nobody.reuse(_jspx_th_c_url_0);
    return false;
  }
}
