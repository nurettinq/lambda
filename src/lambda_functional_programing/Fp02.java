package lambda_functional_programing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp02 {
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
        tekElemanlarinKupu(ll);
        System.out.println();
        tekElemanlarinKaresiniYazdir(ll);
        System.out.println();
        tekelemanlariYazdir(ll);
        System.out.println();
        tekrarsizCiftElemanlarinKareleriToplami(ll);
        tekrarsizCiftElemanlarinKareleriToplami2(ll);
        tekrarsizCiftElemanlarinKareleriToplami3(ll);
        tekrarsizCiftElemanlarinKuplerinial(ll);
        getMaxEleman(ll);
        tersSiraTekrarsizElemanlariYazdir(ll);
    }public static void tekElemanlarinKaresiniYazdir(List<Integer> list){
        list.stream().distinct().filter(Utils::tekElemaniSec).map(Utils::karesinAl).forEach(Utils::ayniSatirdaBosluklaYazdir);

    }public static void tekElemanlarinKupu(List<Integer>list){
        list.stream().distinct().filter(Utils::tekElemaniSec).map(Utils::kupunuAl).forEach(Utils::ayniSatirdaBosluklaYazdir);
    }public static void tekelemanlariYazdir(List<Integer>list){
        list.stream().filter(Utils::ciftElemaniSec).forEach(Utils::ayniSatirdaBosluklaYazdir);
    }public static void tekrarsizCiftElemanlarinKareleriToplami(List<Integer>list){
        Integer toplam=list.stream().distinct().filter(Utils::ciftElemaniSec).map(Utils::karesinAl).reduce(0,Math::addExact);
        System.out.println(toplam);
    }public static void tekrarsizCiftElemanlarinKareleriToplami2(List<Integer>list){
        Integer toplam=list.stream().distinct().filter(Utils::ciftElemaniSec).map(Utils::karesinAl).reduce(Math::addExact).get();
        System.out.println(toplam);
}public static void tekrarsizCiftElemanlarinKareleriToplami3(List<Integer>list){
        Integer toplam=list.stream().distinct().filter(Utils::ciftElemaniSec).map(Utils::karesinAl).reduce(Integer::sum).get();
        System.out.println(toplam);
}public static void tekrarsizCiftElemanlarinKuplerinial(List<Integer>list){
  Integer carpim=      list.stream().distinct().filter(Utils::ciftElemaniSec).map(Utils::kupunuAl).reduce(Math::multiplyExact).get();
        System.out.println(carpim);
    }public static void getMaxEleman(List<Integer> list) {
       Integer max= list.stream().distinct().reduce(Math::max).get();
        System.out.println(max);
    }public static void tersSiraTekrarsizElemanlariYazdir(List<Integer> list) {
   List<Double> sonuc =   list.stream().distinct().filter(t->t>5).map(Utils::yarisiniAl).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(sonuc);
    }


}
