import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class MapReduceTester {

	public static void main(String[] args) throws Exception{
		
		MapReduce mr = new MapReduce();
		
		/*
		mr.fin_map("cat", "5");
		mr.fin_map("cat", "67");
		mr.fin_map("cattt", "6");
		mr.fin_map("cat", "344");
		mr.fin_map("catt", "1");
		*/
		
		
		Scanner s = new Scanner(new File("decind.txt"));
		while( s.hasNextLine() ){
			
			String[] lin = s.nextLine().split(" ");
			
			for(String str : lin)
				mr.fin_map(str.trim(), "1");
		//System.out.println( Arrays.toString(lin) );
			
		}
		
		
		
		
		HashMap<String, String> mapp = mr.reduce();
		for(Object key  : mapp.keySet().toArray())
			System.out.println( "(" + key + ", " + mapp.get((String)key) + ")" );
	}

}
