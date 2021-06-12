package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Program {

	public static void main(String[] args) {
		
		Map<String, Integer> contagem =  new LinkedHashMap<>();
		
		String path = "C:\\Users\\diogo\\Documents\\eclipse\\ExampleMap\\in.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while(line!= null) {
				String [] field = line.split(",");
				String name = field[0];
				int count = Integer.parseInt(field[1]);
				
				if(contagem.containsKey(name)) {
					int votos = contagem.get(name);
					contagem.put(name, count + votos);
				}else {
					contagem.put(name, count);
				}
				line = br.readLine();
			}
			for(String key : contagem.keySet()) {
				System.out.println(key + ": "+contagem.get(key));
			}
			
		}catch(IOException e) {
			System.out.println("Error: "+ e.getMessage());
		}
	}

}
