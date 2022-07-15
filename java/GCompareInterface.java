import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

//sort by name if name is same sort on age
//employee
class Employi implements Comparable<Employi>{
  private String name;
  private Integer age;

  Employi(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return this.name;
  }

  public Integer getAge() {
    return this.age;
  }

  @Override
  public int compareTo (Employi e2) {
    if (this.getName().compareTo(e2.getName()) == 0) {
    	return this.getAge().compareTo(e2.getAge());
    }
    return this.getName().compareTo(e2.getName());
  }
  
  @Override
  public String toString() {
	  return "name: " + this.getName() + ", age:" + this.getAge();
  }
  
  public static Comparator<Employi> ageComparator= (e1, e2) -> {
	  return e1.getAge().compareTo(e2.getAge());
  };
  
  public static Comparator<Employi> nameComparator= (e1, e2) -> {
	  return e1.getName().compareTo(e2.getName());
  };
}

class GCompareInterface {
  public static void main(String []args) {
    List<Employi> empList = new ArrayList<Employi>();
    empList.add(new Employi("a", 35));
    empList.add(new Employi("d", 30));
    empList.add(new Employi("c", 45));
    empList.add(new Employi("b", 40));
    
    empList.stream().sorted().forEach(System.out::println);

    System.out.println("age");
    Collections.sort(empList, Employi.ageComparator);
    empList.stream().forEach(System.out::println);
    
    System.out.println("name");
    Collections.sort(empList, Employi.nameComparator);
    empList.stream().forEach(System.out::println);
  }
}