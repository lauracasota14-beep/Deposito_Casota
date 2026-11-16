
public class Stats<T extends Number> {
	private T[] numbers;

	public Stats() {
		super();
	}

	public Stats(T[] numeri) {
		this.numbers = numeri;
	}

	public T[] getNumbers() {
		return numbers;
	}

	public void setNumbers(T[] numbers) {
		this.numbers = numbers;
	}

	public double average() {
		double sum = 0.0;
		for (T number : this.numbers) {
// Senza extends Number sul generic
// if (number instanceof Number) {
// sum += ((Number) number).doubleValue();
// }
			sum += number.doubleValue();

		}
		return sum / this.numbers.length;
	}
	public boolean sameAvg(Stats<?> obj) {
		if(this.average() == obj.average())
		{
			return true;
		}else 
		{
			return false;
		}
	}

}