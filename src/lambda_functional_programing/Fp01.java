package lambda_functional_programing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp01 {
    public static void main(String[] args) {

        List<Integer> ll=new ArrayList<>();
        ll.add(25);
        ll.add(6);
        ll.add(9);
        ll.add(15);
        ll.add(2);
        ll.add(3);
        ll.add(25);
        ll.add(131);
        ll.add(8);
        listElemanlariniYAzdirFunctional(ll);
        System.out.println();
        ciftElemamnlariniYazdir(ll);
        System.out.println();
        tekEleamnlarinKareleriniYazdir(ll);
        System.out.println();
        tekrarsiztekElemanlarinKupleriiniYaszdir(ll);
        System.out.println();
        tekrarsiElemanlarinKareToplami(ll);
        tekrasizCiftElemanlarinkupununZarpimi(ll);
        getMaxEleman(ll);
        getMaxEleman2(ll);
        getYedidenBuyukCiftMin(ll);
        getYedidenBuyukCiftMin2(ll);
        getYedidenBuyukCiftMin3(ll);
        getTersSiralamaylaTekarasizElemanlarinYarisi(ll);
    }public static void listElemanlariniYAzdirFunctional(List<Integer>list){
        list.stream().forEach(t-> System.out.print(t+" "));

    }
    public static void ciftElemamnlariniYazdir(List<Integer>list){
        list.stream().filter(t->t%2==0).forEach(t->System.out.print(t+" "));
    }public static void tekEleamnlarinKareleriniYazdir(List<Integer>list){
        list.stream().filter(t->t%2!=0).map(t->t*t).forEach(t->System.out.print(t+" "));
    }public static void tekrarsiztekElemanlarinKupleriiniYaszdir(List<Integer> list){
        list.stream().distinct().filter(t->t%2!=0).map(t->t*t*t).distinct().forEach(t->System.out.print(t+" "));
    }public static void tekrarsiElemanlarinKareToplami(List<Integer>list){
       Integer toplam= list.stream().distinct().filter(t->t%2==0).map(t->t*t).reduce(0,(t,u)->t+u);
        System.out.println(toplam);
    }public static void tekrasizCiftElemanlarinkupununZarpimi(List<Integer>list) {
        Integer carpim = list.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t * t).reduce(1, (t, u) -> t * u);
        System.out.println(carpim);
    }public static void getMaxEleman(List<Integer> list) {
        Integer maxELeman=list.stream().distinct().reduce(Integer.MIN_VALUE,(t,u)->t>u?t:u);
        System.out.println(maxELeman);

    }public static void getMaxEleman2(List<Integer>list) {
        Integer maxELeman=list.stream().distinct().sorted().reduce(Integer.MIN_VALUE,(t,u)->u);
        System.out.println(maxELeman);
    }public static void getYedidenBuyukCiftMin(List<Integer>list){
      Integer min=  list.stream().distinct().filter(t->t%2==0).filter(t->t>7).reduce(Integer.MAX_VALUE,(t,u)->t<u?t:u);
        System.out.println(min);
    }public static void getYedidenBuyukCiftMin2(List<Integer>list){
     Integer min=list.stream().distinct().filter(t->t%2==0).filter(t->t>7).sorted(Comparator.reverseOrder()).reduce(Integer.MAX_VALUE,(t,u)->u);
        System.out.println(min);
    }public static void getYedidenBuyukCiftMin3(List<Integer>list) {
      Integer min =  list.stream().filter(t->t%2==0).filter(t->t>7).sorted().findFirst().get();
        System.out.println(min);
    }public static void  getTersSiralamaylaTekarasizElemanlarinYarisi(List<Integer> list){
        List<Double>sonuc=list.stream().distinct().map(t->t/2.0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sonuc);
    }
}
