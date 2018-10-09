package StreamImpl;

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductTestUsingReductionOperation {

	public static void main(String[] args) {
		//As list
		List<Product> list=Arrays.asList(new Product(2,"sofa"), new Product(2,"car"), new Product(3,"table"), new Product(4,"chair"), new Product(4,"tv"));
		list.stream().map(Product::getName).collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("-----------------------------");
		//As string-> joining(separator,prefix,suffix)
		System.out.println(list.stream().map(Product::getName).collect(Collectors.joining(",", "[", "]")));
		
		System.out.println("-----------------------------");
		//average as double value.. can also find summingInt,summarizingInt etc
		Double avg=list.stream().collect(Collectors.averagingInt(Product::getPid));
		IntSummaryStatistics summary=list.stream().collect(Collectors.summarizingInt(Product::getPid));
		System.out.println("Avergae:"+avg);
		System.out.println(summary);
		
		System.out.println("-----------------------------");
		//grouping by product id:
		Map<Integer,List<Product>> map=list.stream().collect(Collectors.groupingBy(Product::getPid));
		map.forEach((k,v)->
		{
			System.out.println(k);
			System.out.println(v);
		});
		
		System.out.println("-----------------------------");
		//partitioning on basis of pid>2
		Map<Boolean,List<Product>> part=list.stream().collect(Collectors.partitioningBy(p->p.getPid()>2));
		part.forEach((k,v)->
		{
			System.out.println(k);
			System.out.println(v);
		});
		
		System.out.println("-----------------------------");
		//converting into set
		list.stream().collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet)).forEach(System.out::println);
		

	}

}
