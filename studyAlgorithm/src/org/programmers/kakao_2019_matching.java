package org.programmers;

public class kakao_2019_matching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String page = "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\r\n" + 
				"<head>\r\n" + 
				"  <meta charset=\"utf-8\">\r\n" + 
				"  <meta property=\"og:url\" content=\"https://a.com\"/>\r\n" + 
				"</head>  \r\n" + 
				"<body>\r\n" + 
				"Blind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \r\n" + 
				"<a href=\"https://b.com\"> Link to b </a>\r\n" + 
				"</body>\r\n" + 
				"</html>";
		page = page.toLowerCase();
		
		int link = 0;
		int fromIndex = -1;
		while ((fromIndex = page.indexOf("<a href=", fromIndex + 1)) >= 0) {
			link++;
		}
		
        //String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
        //page =page.replaceAll(match, "");
		System.out.println(page);
		
		int find = 0;
	    fromIndex = -1;
	    while ((fromIndex = page.indexOf("blind", fromIndex + 1)) >= 0) {
	      find++;
	    }
		System.out.println("link;"+link+", find: "+find);
	}

}
