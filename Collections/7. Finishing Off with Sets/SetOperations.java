import java.util.HashSet;

public class SetOperations {

    public void execute() {
        HashSet<Integer> squares = new HashSet<>();
        HashSet<Integer> cubes = new HashSet<>();

        for(int i = 0; i < 100; i++) {
            squares.add(i * i);
            cubes.add(i* i * i);
        }

        System.out.println("Squares: "+ squares.size());
        System.out.println("Cubes: "+ cubes.size());

        HashSet<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);

        HashSet<Integer> interSection = new HashSet<>(squares);
        interSection.retainAll(cubes);
        System.out.println();
        for(Integer num: interSection) {
            System.out.println(num+" square of "+Math.sqrt(num)+" cube of "+ Math.cbrt(num));
        }
        System.out.println();
        System.out.println("Square Union Cube set size: "+ union.size());

    }
}
