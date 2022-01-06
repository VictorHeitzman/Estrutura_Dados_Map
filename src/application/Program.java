package application;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> votes = new HashMap<String, Integer>();
		
		System.out.println("Enter with of path: ");
		String path = sc.nextLine();
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			while(line != null) {
				
				String[] position = line.split(",");
				String name = position[0];
				int count = Integer.parseInt(position[1]);
				
				if (votes.containsKey(name)) {
					int totVotes = votes.get(name);
					votes.put(name, count  + totVotes);					
				}
				else{
					votes.put(name, count);
				}
				line = br.readLine();
			}
			
			for(String key : votes.keySet()) {
				System.out.println(key + ", " + votes.get(key));
			}
		}
		catch (IOException e) {
		System.out.println("Error: " + e.getMessage());
		}
		
	}
}
