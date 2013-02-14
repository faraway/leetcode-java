package leetcode;
public class DecidingWhereToEatWastesTime {
	public static void main(String[] args){
		String[] options = new String[]{
			"China King(South Campus)",
			"China King(Maple)",
			"Mcdonalds",
			"KFC",
			"Beijing",
			"China Star",
			"Denny's",
			"Wendy's",
			"Fuji",
			"Uncle John"
		};
		System.out.println(options[(int)(Math.random()*options.length)]);
	}
}
