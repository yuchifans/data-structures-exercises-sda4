package main.java;

public class Main {

	public static void main(String[] args) {
		
		LinkedList ls1 = new LinkedList();
		LinkedList ls2 = new LinkedList();
		LinkedList lst = new LinkedList();
		LinkedList ls4 = new LinkedList();
		ls1.add(1);
		ls1.add(2);
		LinkedList ls3= ls1.concat(ls2);		
		ls1.add(3);
		ls2.add(4);
		ls1.printAll();
		ls2.printAll();
		ls3.printAll();
		ls4.add(1);
		ls4.add(2);
		ls4.add(3);
		ls4.add(4);
		ls4.add(5);
		ls4.reverse2();
		ls4.printAll();
		System.out.println(ls2==ls3);		
		for(int i=0;i<20000000;i++) {
			lst.add(i);
		}	
		//System.out.println(lst.get(0));
		double start = (double) System.nanoTime();
		lst.printAll();
		double stop = (double) System.nanoTime();
		double runtime = (double) ((stop - start) / 1000000000);
		System.out.println(runtime);
        

	}
}
