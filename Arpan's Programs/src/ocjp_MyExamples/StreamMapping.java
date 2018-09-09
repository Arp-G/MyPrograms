package ocjp_MyExamples;

import java.util.stream.*;

import java.util.*;

import java.util.function.*;

public class StreamMapping
{
    public static void main(String args[]) {
       
       DoubleToIntFunction DI=x->(int)x;
       
       IntToLongFunction IL=x->x;
       
       LongUnaryOperator LL=x->x;
       
       ToLongFunction SL=x->((String)x).length(); //Stream<String> to LongStream
       
       DoubleFunction DS=x->x+""; //DoubleStream to Stream<String>
       
       IntStream ins=IntStream.of(1,2,3);
       
       LongStream ls=LongStream.of(4,5,6);
       
       DoubleStream ds=DoubleStream.of(7.7,8.8,9.9);
       
       Stream<String> StringS=Stream.of("arp","java");
       
       
       //DoubleStream to IntStream
       
       IntStream str=ds.mapToInt(DI);
       
       //IntStream to LongStream
       
       LongStream str1=ins.mapToLong(IL);
       
       //LongSTream to LongStream
       
       str1=ls.map(LL);
       
       //Stream<String> to LongSTream
       
       str1=StringS.mapToLong(SL);
       
       //DoubleSTream to Stream<String>
       
       DoubleStream tmp=DoubleStream.of(1.22,5.45,99.45);
       
       Stream<String> str2=tmp.mapToObj(DS);
       
       //Stream.concat()  its a static Stream method
       
       Integer arr[]={1,2,3,4,5};
       
       Double arr1[]={6.0,7.0,8.0,9.0,10.0};
       
       List<Integer> list=Arrays.asList(1,2,3,4,5);
       
       List<Double> list1=Arrays.asList(arr1);
       
       Stream<Integer> istream=list.stream();
       
       Stream<Double> dstream=list1.stream();
       
       Stream<Number> ns=Stream.concat(istream,dstream);
       
       ns.forEach(x->System.out.print(x+","));
       
       
      //Stream.iterate()  its a static Stream method
       
       Stream<Boolean> bs=Stream.iterate(false,x->!x).limit(4); // false, true, false...
       
       bs.forEach(System.out::print);
       
       
   
    }
}