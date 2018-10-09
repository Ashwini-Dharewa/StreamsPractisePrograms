package StreamImpl;

import java.util.stream.Stream;

public class StreamPipeline {

	public static void main(String[] args) {
		Stream.of("abc","bcd","cde").skip(1).forEach(System.out::println);//skips 1 element
		System.out.println("-----------------------------");
		//skips 1 element and prints substring(0,2)of others
		Stream.of("abc","bcd","cde").skip(1).map(element->element.substring(0,2)).forEach(System.out::println);
		System.out.println("-----------------------------");
		Stream.of("abc","dcb","edc").skip(1).map(element->element.substring(0,2)).sorted().forEach(System.out::println);
		System.out.println(Stream.of("abc","bcd","cde").skip(1).map(element->element.substring(0,2)).sorted().count());
	}

}
