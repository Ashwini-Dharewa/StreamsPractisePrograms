package StreamImpl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ReductionOperations {

	public static void main(String[] args) {
		System.out.println(IntStream.range(1,5).reduce((a,b)->a+b).getAsInt());
		System.out.println("-----------------------------");
		//add extra 10
		System.out.println(IntStream.range(1,5).reduce(10,(a,b)->a+b));
		
		System.out.println("-----------------------------");
		//10+12=22, (10+6)16+(10+22)32=48 , 22+48=70 
		List<Integer> list=Arrays.asList(12,6,22);
		System.out.println(list.parallelStream().reduce(10, (a,b)->a+b , (a,b)->
		{
			System.out.println("Combiner was called!"+(a+b));
			return a+b;
		}));
		
		System.out.println("-----------------------------");
		//filter
		List<String> filt=Arrays.asList("abc","bcd","cda");
		filt.stream().filter(element->element.contains("b")).forEach(System.out::println);
		IntStream.range(1,5).filter(i->i>2).forEach(System.out::println);//3,4
		
		System.out.println("-----------------------------");
		//matching
		System.out.println(filt.stream().anyMatch(element->element.contains("b")));//anyone has b-true
		System.out.println(filt.stream().allMatch(element->element.contains("b")));//everyone has b-false
		System.out.println(filt.stream().noneMatch(element->element.contains("b")));//no one has b-false
		

	}

}
