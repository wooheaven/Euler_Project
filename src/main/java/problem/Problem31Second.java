package problem;

import java.util.HashSet;

public class Problem31Second {
	public static void main(String[] args) {

		HashSet<String> conins = new HashSet<String>();

		int sum;
		int p50tmp = 0;
		int p100tmp = 0;
		int p200tmp = 0;

		for (int p1 = 0; p1 < 201; p1++) {
			for (int p2 = 0; p2 < 101; p2++) {
				for (int p5 = 0; p5 < 41; p5++) {
					for (int p10 = 0; p10 < 21; p10++) {
						for (int p20 = 0; p20 < 11; p20++) {
							sum = 0;
							sum = sum + p1;
							sum = sum + p2 * 2;
							sum = sum + p5 * 5;
							sum = sum + p10 * 10;
							sum = sum + p20 * 20;
							for (int p50 = 0; p50 < 5; p50++) {
								p50tmp = p50 * 50;
								sum = sum + p50tmp;

								if (sum > 200) {
//									sum = sum - p50tmp;
									break;
								} else if (sum < 200 && (200 - sum) % 100 != 0) {
									sum = sum - p50tmp;
									continue;
								}
								for (int p100 = 0; p100 < 3; p100++) {
									p100tmp = p100 * 100;
									sum = sum + p100tmp;

									if (sum > 200) {
										sum = sum - p100tmp;
										break;
									} else if (sum < 200 && (200 - sum) % 200 != 0) {
										sum = sum - p100tmp;
										continue;
									}
									for (int p200 = 0; p200 < 2; p200++) {
										p200tmp = p200 * 200;
										sum = sum + p200tmp;

										if (sum > 200) {
											sum = sum - p200tmp - p100tmp;
											break;
										} else if (sum < 200) {
											sum = sum - p200tmp;
											continue;
										} else if (sum == 200) {
											conins.add("p1=" + String.valueOf(p1) + "-p2=" + String.valueOf(p2) + "-p5=" + String.valueOf(p5) + "-p10=" + String.valueOf(p10) + "-p20=" + String.valueOf(p20) + "-p50=" + String.valueOf(p50) + "-p100=" + String.valueOf(p100)
													+ "-p200=" + String.valueOf(p200));
											sum = sum - p200tmp - p100tmp;
											break;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(conins.size());
	}
}
