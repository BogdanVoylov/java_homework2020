package syntax;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expr {
	Pattern pattern = Pattern.compile("^(.*?)(\\*|\\-|\\+)(.*?)$");
	Letter input;
	char next;
	public Expr(){ }

	public boolean test(String word) {
		try {
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine engine = manager.getEngineByName("js");
			Object result = engine.eval(word);
		}catch (Exception e){
			return  false;
		}
		return true;
	}
	// .... methods
	// ......
	// ......

	//--------------------------------------------------------
	public Integer evalLeft(String word){
		try{
			StringBuilder stringBuilder = new StringBuilder(word);
			stringBuilder.reverse();
			return evalGroup(stringBuilder.toString());
		}catch (Exception e){
			return null;
		}
	}

	public Integer evalGroup(String word){
		Matcher preMatcher = Pattern.compile("^\\((.+?)\\)$").matcher(word);
		if(preMatcher.find()){
			word = preMatcher.group(1);
		}
		Matcher matcher = pattern.matcher(word);
		if(word.matches("^\\d+$")){
			return Integer.valueOf(word);
		}
		if(matcher.matches()){
			if(matcher.group(2).equals("+")){
				return Integer.valueOf(matcher.group(1)) + evalGroup(matcher.group(3));
			}else if(matcher.group(2).equals("-")){
				return Integer.valueOf(matcher.group(1)) - evalGroup(matcher.group(3));
			}else if(matcher.group(2).equals("*")){
				return Integer.valueOf(matcher.group(1)) * evalGroup(matcher.group(3));
			}

		}
		return null;
	}


	// .... methods
	// ......
	// ......

	//-------------
	public Integer evalRigth(String word){
		// ... statements
		try {
			return  evalGroup(word);
		}catch (Exception e){
			return null;
		}
	}
	// .... methods
	// ......
	// ......

 	//------------------------------------------
	public Integer evalPrior(String word){
		// ... statements
		return null;
	}
	// .... methods
	// ......
	// ......

}
