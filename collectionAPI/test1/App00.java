package katrenich.collectionAPI.test1;


/**
 * Class only for testing EntityA, EntityB, EntityC
 */
public class App00 {
	public static void main(String[] args) {
		EntityA entity = new EntityA();
		entity.setAge(10);
		entity.setName("Artem");
		entity.setHeight(120);
		System.out.println(entity);
		System.out.println("-----------------");
		System.out.println("EntityB");
		String[][] s = new String[][]{{"A", "B", "C", "D"}, {"1", "2", "3", "4"}};
		String[][] s1 = new String[][]{{"A", "B", "C", "D"}, {"1", "2", "3", "4"}};
		double[] d = new double[]{1.005, 2.004, 3.04};
		double[] d1 = new double[]{1.005, 2.004, 3.04};
		EntityB entityB1 = new EntityB(s, d);
		EntityB entityB2 = new EntityB(s1, d1);
		System.out.println("HeshCode: " + entityB1.hashCode());
		System.out.println("Equals: " + entityB1.equals(entityB2));
		System.out.println(entityB1);
	}


}