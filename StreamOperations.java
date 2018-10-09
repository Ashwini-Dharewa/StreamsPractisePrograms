package StreamImpl;


import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamOperations {

	public static void main(String[] args) {
		Stream.iterate(0,i->i+2).limit(5).collect(Collectors.toList()).forEach(System.out::println);
		System.out.println("-----------------------------");
		System.out.println(Stream.of("a","b","c").filter(i->i.contains("b")).findAny().get());
		System.out.println("-----------------------------");
		//these streams cannot be reused..storing the result in collection helps in reusing them
		List<String> list=Stream.of("a","b","c").filter(i->i.contains("b")).collect(Collectors.toList());
		System.out.println(list.stream().findAny().get());//reuse
		System.out.println("-----------------------------");
		System.out.println(list.stream().findFirst());//reuse
		System.out.println("-----------------------------");
		//Builder
		Stream.<String>builder().add("a").add("b").add("c").build().forEach(System.out::println);
		System.out.println("-----------------------------");
		//generator
		Stream.generate(()->"Hi").limit(2).forEach(System.out::println);
		System.out.println("-----------------------------");
		//IntStream/LongStream
		IntStream.range(1,5).forEach(System.out::println);//1,2,3,4
		System.out.println("-----------------------------");
		LongStream.rangeClosed(1,5).forEach(System.out::println);//1,2,3,4,5
		System.out.println("-----------------------------");
		Random random=new Random();
		DoubleStream d=random.doubles(3);
		d.forEach(System.out::println);
		System.out.println("-----------------------------");
		"abcd".chars().forEach(System.out::println);//returns IntStream for ascii values
	}

}
