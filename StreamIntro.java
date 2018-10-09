package StreamImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamIntro{

	public static void main(String[] args) {
		
		String arr[]= {"abc","vbn","yui"};
		Stream s=Arrays.stream(arr);
		Stream sArr=Arrays.stream(arr,1,3);
		s.forEach(System.out::println);
		System.out.println("-----------------------------");
		sArr.forEach(System.out::println);//prints vbn(3-1) to yui(3)
		System.out.println("-----------------------------");
		
		Stream<String> of=Stream.of("acd","ytr");
		of.forEach(System.out::println);
		System.out.println("-----------------------------");
		
		ArrayList<String> list=new ArrayList<String>();
		list.add("asd");list.add("bca");
		/*Stream<String> st=list.stream();
		 st.forEach(System.out::println);*/
		list.stream().forEach(System.out::println);
		System.out.println("-----------------------------");
		
		ArrayList<String> plist=new ArrayList<String>();
		plist.add("hello");plist.add("hi");
		plist.parallelStream().forEach(ob->doProcess(ob));
		System.out.println("-----------------------------");

	}

	private static void doProcess(String s) {
		System.out.println(s+" World");
	}

}
