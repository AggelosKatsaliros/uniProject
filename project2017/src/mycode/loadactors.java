package mycode;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class loadactors {
	private String input;
	HashMap<String,ArrayList<String>> link = new HashMap<String,ArrayList<String>>();
	HashMap<String,String> zelda = new HashMap<String,String>();
	
	public void loadfile(String actor) throws FileNotFoundException{
		FileInputStream inputstream= new FileInputStream("movie_actors.dat");
		Scanner inputReader = new Scanner(inputstream);
		while(inputReader.hasNextLine()){
			ArrayList<String> arr2 = new ArrayList();
			input = inputReader.nextLine();
			String te []= input.split("\t");
			boolean p=link.containsKey(te[2]);
			if(p==true) {
				arr2.addAll(link.get(te[2]));
				arr2.add(te[0]);
			}else {
				arr2.add(te[0]);
			}
			link.put(te[2],arr2);
		}
		ArrayList<String> w = new ArrayList();
		w=(link.get(actor));
		HashMap<String,String> pali = new HashMap<String,String>();
		loadmovies pros= new loadmovies();
		pali=pros.getTitle();
		for(int i=0; i<w.size(); i++) {
			zelda.put(w.get(i), pali.get(w.get(i)));
		}
		// to hashmap zelda hashmap ,kai teliko hashmap, exei gia keys h8opoious kai gia values tis tainies stis opoies paizoun
		inputReader.close();
	}
	
	private String input2;
	HashMap<String,ArrayList<String>> link2 = new HashMap<String,ArrayList<String>>();
	
	public ArrayList<String> loadfile2(String arithmos) throws FileNotFoundException{
		FileInputStream inputstream= new FileInputStream("movie_actors.dat");
		Scanner inputReader = new Scanner(inputstream);
		while(inputReader.hasNextLine()){
			ArrayList<String> arr2 = new ArrayList();
			input2 = inputReader.nextLine();
			String te []= input2.split("\t");
			boolean p=link2.containsKey(te[0]);
			if(p==true) {
				arr2.addAll(link2.get(te[0]));
				arr2.add(te[2]);
			}else {
				arr2.add(te[2]);
			}
			link2.put(te[0],arr2);
		}
		
		inputReader.close(); 
		return link2.get(arithmos);
	}
	
	HashMap<String,ArrayList<String>> link6 = new HashMap<String,ArrayList<String>>();
	public ArrayList<String> loadfile3(String title) throws FileNotFoundException{
		ArrayList<String> link5 = new ArrayList<String>();
		loadmovies ne= new loadmovies();
		link5= ne.loadAllInf2(title);
		FileInputStream inputstream= new FileInputStream("movie_actors.dat");
		Scanner inputReader = new Scanner(inputstream);
		
		while(inputReader.hasNextLine()){
			ArrayList<String> arr2 = new ArrayList();
			input2 = inputReader.nextLine();
			String te []= input2.split("\t");
			boolean p=link2.containsKey(te[0]);
			if(p==true) {
				arr2.addAll(link2.get(te[0]));
				arr2.add(te[2]);
			}else {
				arr2.add(te[2]);
			}
			link2.put(te[0],arr2);
			
			if (link5.get(0).equals(te[0])){
				link6.put(title,arr2);
			}
			
		}
		inputReader.close();
		return (link6.get(title));
		
	}
	
	public HashMap<String,String> getmoviesfromactors(){
		
		return zelda;
	}
	
	
}

