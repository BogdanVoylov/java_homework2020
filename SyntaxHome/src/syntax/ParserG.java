package syntax;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ParserG {
	List<String> additionalAlphabet = Arrays.asList("S","A","B");
	Letter input;
	String current;
	char next;
	public ParserG(){

	}
	/*{S -> abABd, S -> abb, A -> aAb, A -> d, B -> BcA, B -> b}*/
	public boolean analys(String word){
		input = new Letter(word);
		current = word;
		System.out.println(":"+current);
		try {
        	S();
		}catch (SyntaxError error){
        	return false;
		}
		return true;
	}

	private void S() throws SyntaxError{
		Matcher m = Pattern.compile("^ab(.+?)d$").matcher(current);
		if(m.find()){
			current = m.group(1);
			System.out.println("S:"+current);
			A();
			B();
		}else if(current.matches("^abb$")){
			return;
		}else{
			throw new SyntaxError("S does not match");
		}
	}
	private void A() throws SyntaxError{
		Matcher m = Pattern.compile("^a(.+?)b(?!b)(.+?)").matcher(current);
		Matcher m1 = Pattern.compile("^d(.+?)$").matcher(current);
		if(m.find()){
			System.out.println("A1:"+current+"|"+m.group(1));
			current = m.group(1);
			A();
		}else if(m1.find()){
			current = m1.group(1);
			System.out.println("A2:"+current);
			return;
		}else if(current.equals("d")){
			System.out.println("A2:"+current);
			return;
		}else {
			System.out.println("(A)Error at " +current);
			throw new SyntaxError("A does not match");
		}
	}
	private void B() throws SyntaxError{
		Matcher m = Pattern.compile("^(.+?)c(.+?)$").matcher(current);
		if(m.find()){
			current = m.group(1);
			System.out.println("B1:"+m.group(1)+"|"+m.group(2));
			B();
			current = m.group(2);
			A();
		}else if(current.equals("b")){
			System.out.println("B2:"+current);
			current = "";
			return;
		}else{
			System.out.println("(B)Error at " +current);
			throw new SyntaxError("B does not match");
		}
	}
	// .... methods
	// ......
	// ......

}
