package com.mx.framework.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.github.pagehelper.PageInfo;

/**
 *  描述: 自定义分页标签处理类
 *  作者: 郎国峰 
 *  时间: 2019年3月14日 下午2:37:01
 */
public class PageTag extends TagSupport {
	
	/**
	* @Fields field:field:{todo}(用一句话描述这个变量表示什么)
	*/
	
	private static final long serialVersionUID = 1L;
	/**
	 * 控制器传给页面的分页对象名
	 */
	private String pageName;
	/**
	 * 查询分页数据的请求路径
	 */
	private String uri;
	/**
	 * 条件查询的表单名
	 */
	private String formName;

	@Override
	public int doStartTag() throws JspException {
		//获取web资源
		HttpServletRequest request = (HttpServletRequest)super.pageContext.getRequest();
		JspWriter out = super.pageContext.getOut();
		//得到分页对象
		PageInfo pageInfo = (PageInfo)request.getAttribute(pageName);
		//获取分页属性
		int pageNum = pageInfo.getPageNum();//得到当前页
		int pageSize = pageInfo.getPageSize();//得到每页显示条数
		int pages = pageInfo.getPages();//得到总页数
		long total =  pageInfo.getTotal();//得到总条数
		int prePage = pageInfo.getPrePage();//得到上一页
		int nextPage = pageInfo.getNextPage();//得到下一页
		//获取项目名
		String path = request.getContextPath();
		//判断uri的前面有没有"/"，如果没有则加一个"/"
		if(uri.substring(0, 1).equals("/") == false  ){
			uri = "/"+uri;
		}
		//封装页面标签
		StringBuffer strbuf=new StringBuffer();
		
		strbuf.append("  ");
		strbuf.append(" <ul class=\" pager  \"> ");
		strbuf.append("     <li><a href=\""+path+uri+"?pageNum=1 \">首页</a></li> ");
		strbuf.append(" 	<li><a href=\""+path+uri+"?pageNum="+prePage+" \">上一页</a></li> ");
		//如果总页数<5页,那么页数就有几页显示几页
		if(pages<5) {
			for (int i = 1; i <= pages; i++) {
				if(pageNum==i) {//判断是否是当前页,如果是当前页,那么加上active样式,显示当前页,否则不加
					strbuf.append(" 	<li class=\"active\"><a href=\""+path+uri+"?pageNum="+i+" \">"+i+"</a></li> ");
				}else {
					strbuf.append(" 	<li><a href=\""+path+uri+"?pageNum="+i+" \">"+i+"</a></li> ");
				}
			}
		}
		//如果总页数>=5页,那么只显示5页
		if(pages>=5) {
			if(pageNum<=3) {//当前页在三页一下包括三页,那么显示1-5页
				for (int i = 1; i <= 5; i++) {
					if(pageNum==i) {//判断是否是当前页,如果是当前页,那么加上active样式,显示当前页,否则不加
						strbuf.append(" 	<li class=\"active\"><a href=\""+path+uri+"?pageNum="+i+" \">"+i+"</a></li> ");
					}else {
						strbuf.append(" 	<li><a href=\""+path+uri+"?pageNum="+i+" \">"+i+"</a></li> ");
					}
				}
			}else if(pageNum>3&&pageNum<=pages-2) {//当前页是第四页到倒数第三页之间,显示5页,并将当前页放到中间
				for (int i = pageNum-2; i <= pageNum+2; i++) {
					if(pageNum==i) {//判断是否是当前页,如果是当前页,那么加上active样式,显示当前页,否则不加
						strbuf.append(" 	<li class=\"active\"><a href=\""+path+uri+"?pageNum="+i+" \">"+i+"</a></li> ");
					}else {
						strbuf.append(" 	<li><a href=\""+path+uri+"?pageNum="+i+" \">"+i+"</a></li> ");
					}
				}
			}else if(pageNum>pages-2) {//当前页为最后两页时,显示最后5页
				for (int i = pages-4; i <= pages; i++) {
					if(pageNum==i) {//判断是否是当前页,如果是当前页,那么加上active样式,显示当前页,否则不加
						strbuf.append(" 	<li class=\"active\"><a href=\""+path+uri+"?pageNum="+i+" \">"+i+"</a></li> ");
					}else {
						strbuf.append(" 	<li><a href=\""+path+uri+"?pageNum="+i+" \">"+i+"</a></li> ");
					}
				}
			}
		}
		strbuf.append(" 	<li><a href=\""+path+uri+"?pageNum="+nextPage+" \">下一页</a></li> ");
		strbuf.append(" 	<li><a href=\""+path+uri+"?pageNum="+pages+" \">尾页</a></li> ");
		strbuf.append(" 	&nbsp;&nbsp;&nbsp;&nbsp; ");
		strbuf.append(" 	<li><a href=\"#\">当前第&nbsp;"+pageNum+"&nbsp;页&nbsp;/&nbsp;共&nbsp;"+pages+"&nbsp;页</a></li> ");
		strbuf.append(" </ul> ");
		try {
			out.print(strbuf);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

}
