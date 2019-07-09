package com.cagf.tool.util;

import javax.servlet.http.HttpServletRequest;

public class Page
{
	public static String getPage(HttpServletRequest request, String appendString,
			int start, int range, long count)
	{
		String path = request.getRequestURI();

		// 会返回形如：listDocumentCatalog.action的资源名（去掉查询字符串）
		String requestedResourceName = path
				.substring(path.lastIndexOf("/") + 1);

		// 总页数
		long numPages = count / range + (0 == count % range ? 0 : 1);

		if (numPages <= 1)
		{
			return "";
		}

		StringBuffer sb = new StringBuffer();

		sb.append(" [ ");

		// 显示左箭头
		if (start > 0)
		{
			sb.append("<a href=\"").append(requestedResourceName).append("?");

			if ("".equals(appendString))
			{
				sb.append("start=");
			}
			else
			{
				sb.append(appendString);
				sb.append("&start=");
			}

			sb.append(start - range);
			sb.append("&range=");
			sb.append(range);
			sb.append("\">");
			sb
					.append("<img src=\"../images/prev.gif\" width=\"10\" height=\"10\" border=\"0\">");
			sb.append("</a>");
			sb.append("&nbsp;");
		}

		// 当前处于第几页
		int currentPage = start / range + 1;

		int low = currentPage - 5;

		if (low <= 0)
		{
			low = 1;
		}

		int high = currentPage + 5;

		// 加上...
		if (low > 2)
		{
			sb.append("<a href=\"").append(requestedResourceName).append("?");

			if ("".equals(appendString))
			{
				sb.append("start=0");
			}
			else
			{
				sb.append(appendString);
				sb.append("&start=0");
			}

			sb.append("&range=");
			sb.append(range);
			sb.append("\">");
			sb.append("1");
			sb.append("</a>");
			sb.append("...");
		}

		while (low < currentPage)
		{
			sb.append("<a href=\"").append(requestedResourceName).append("?");

			if ("".equals(appendString))
			{
				sb.append("start=");
			}
			else
			{
				sb.append(appendString);
				sb.append("&start=");
			}

			sb.append((low - 1) * range);
			sb.append("&range=");
			sb.append(range);
			sb.append("\">");
			sb.append(low);
			sb.append("</a>");
			sb.append("&nbsp;");

			low++;
		}

		// 打印当前页
		sb.append("<b>");
		sb.append(currentPage);
		sb.append("</b>");

		// 打印当前页的后5页

		currentPage++;

		while ((currentPage <= high) && (currentPage <= numPages))
		{
			sb.append("&nbsp;<a href=\"").append(requestedResourceName).append(
					"?");

			if ("".equals(appendString))
			{
				sb.append("start=");
			}
			else
			{
				sb.append(appendString);
				sb.append("&start=");
			}

			sb.append((currentPage - 1) * range);
			sb.append("&range=");
			sb.append(range);
			sb.append("\">");
			sb.append(currentPage);
			sb.append("</a>");

			currentPage++;
		}

		if (high + 1 < numPages)
		{
			sb.append("...");
		}

		if (high + 1 <= numPages)
		{
			sb.append("<a href=\"").append(requestedResourceName).append("?");

			if ("".equals(appendString))
			{
				sb.append("start=");
			}
			else
			{
				sb.append(appendString);
				sb.append("&start=");
			}

			sb.append((numPages - 1) * range);
			sb.append("&range=");
			sb.append(range);
			sb.append("\">");
			sb.append(numPages);
			sb.append("</a>");
		}

		// 如果不在最后一页，则显示向右箭头
		if (count > (start + range))
		{
			sb.append("&nbsp;<a href=\"").append(requestedResourceName).append(
					"?");

			if ("".equals(appendString))
			{
				sb.append("start=");
			}
			else
			{
				sb.append(appendString);
				sb.append("&start=");
			}

			sb.append(start + range);
			sb.append("&range=");
			sb.append(range);
			sb.append("\">");
			sb
					.append("<img src=\"../images/next.gif\" width=\"10\" height=\"10\" border=\"0\">");
			sb.append("</a>");
		}
		
		sb.append("]");

		return sb.toString();
	}
}