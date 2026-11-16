
public class StatsTest {

	public static void main(String[] args) {
		Double[] dAr = {5.2, 4.5, 6.8};
		Stats<Double> dStats = new Stats<>(dAr);
		
		System.out.println("Media della Array Double = " + dStats.average());
		
		Integer[] iAr = {5, 4, 6};
		Stats<Integer> iStats = new Stats<>(iAr);
		
		System.out.println("Media della Array Integer = " + iStats.average());
		
		if(iStats.sameAvg(dStats)) {
			
			System.out.println("Le medie sono le stesse");
		}else
		 {
			System.out.println("Le medie sono differenti");
		}
	}

}
