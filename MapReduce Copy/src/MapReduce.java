import java.util.HashMap;
import java.util.Stack;


public class MapReduce extends HashMap<String, Stack<String>> {

	private HashMap<String, String> reduced;
	
	public MapReduce(){
		reduced = new HashMap<String, String>();
	}
	
	public void fin_map(String key, String val ){
		
		if(this.containsKey(key))
			this.get(key).push(val);
		else
			{
				Stack<String> s = new Stack<String>();
				s.push(val);
				this.put(key, s );
			}
		
	}
	
	
	public HashMap<String, String> reduce(){
		
	
	Stack<String> stak = new Stack<String>();
	
	for(String s : this.keySet()){
		
		int i = 0;
		Stack<String> ss = this.get(s);
		
		while(!ss.empty())
			i += Integer.decode(ss.pop());
			
		if(!reduced.containsKey(s))//memoization 
			reduced.put(s, String.valueOf(i));
		else
			reduced.put(s, String.valueOf(Integer.decode(reduced.get(s)) + i ));
		
		stak.push(s);
		
		
	}
	
	while(!stak.isEmpty())
		this.remove(stak.pop());
	
	return reduced;
	}
	

}
