package action;

import org.openqa.selenium.JavascriptExecutor;

public class Action {
	
	JavascriptExecutor js = null;
	
	public void ScrollDown(){
		int i; 
		  
		for (i = 0; i < 15; i++)  
		{ 
			js.executeScript("$(\".scroling_div\").scrollTop(99999999999999999999999999999);");
		} 
	}
	
	
	/* public void scroll() { 
		
	"function goDown()"+{
	    "divHeight = $(\".scroling_div\").height();"+
	    "scrollpos = $(\".scroling_div\").scrollTop();"+
	    "maxScroll = $(\".scroling_div\").get(0).scrollHeight;"+
	    "if(scrollpos+divHeight == maxScroll){"+
	        clearInterval(interval); // stop the interval
	        "$(".scroling_div").scrollTop(0);"+
	    }
	else
	{
	        
	        "$(\".scroling_div\").scrollTop(maxScroll);"+
	    }

	"var interval = null;"
	"interval = setInterval(goDown,30);"
		
}*/
}

