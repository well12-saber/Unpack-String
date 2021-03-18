package parse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parse {

	public static String parseStr(String arg) {
		String str=arg;
		int counter=0;
		String sub;
		
		Pattern patternMain = Pattern.compile("[0-9]+\\[[a-zA-Z]*\\]");
		Pattern patternCount = Pattern.compile("[0-9]+");
		Pattern patternSub = Pattern.compile("[a-zA-Z]+");
		
		Matcher matcherMain = patternMain.matcher(str);
		
	    while(matcherMain.find()) {
	    	Matcher matcherCount = patternCount.matcher(matcherMain.group());
	    	Matcher matcherSub = patternSub.matcher(matcherMain.group());
	    	StringBuilder strbuild=new StringBuilder();
	    	
	    	if(matcherCount.find() & matcherSub.find()) {
	    		counter=Integer.parseInt(matcherCount.group());
	    		sub=matcherSub.group();
	    		for (int i=0;i<counter;++i) {
	    			strbuild.append(sub);
	    		}
	    	}
	    	str=matcherMain.replaceFirst(strbuild.toString());
	    	matcherMain = patternMain.matcher(str);
	    }
		return str;
	}
	
	public static void main(String[] args) {
		System.out.println(parseStr("2[3[x]y]"));
	}

}
