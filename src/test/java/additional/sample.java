package additional;

import java.util.Date;

public class sample {
public static void main(String[] args) {
	Date date = new Date();
	String datetext=date.toString().replace(" ","_").replace(":", "-").replace("-", "-");
	System.out.println(datetext);
}
}
