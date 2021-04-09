package mc322.lab03;

public class AppLab03 {

	public static void main(String[] args) {
		String strAnim = "080403MCMVM";
		Animacao anim = new Animacao(strAnim);
		System.out.println(anim.apresenta());
		anim.passo();
		System.out.println(anim.apresenta());
		anim.passo();
		System.out.println(anim.apresenta());
		anim.passo();
		System.out.println(anim.apresenta());
		anim.passo();
		System.out.println(anim.apresenta());
		anim.passo();
		System.out.println(anim.apresenta());
	}

}
