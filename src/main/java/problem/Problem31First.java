package problem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;

public class Problem31First {
	public static void main(String[] args) {

		HashMap<String, String> coinCombination = new HashMap<String, String>();

		BigInteger inputIndex = new BigInteger("0");
		BigInteger sum200Index = new BigInteger("0");

		StringBuilder key = new StringBuilder();
		StringBuilder value = new StringBuilder();

		int p1 = 0; // 0 <= 1pence <= 200
		int p2 = 0; // 0 <= 2pence <= 100
		int p5 = 0; // 0 <= 5pence <= 40
		int p10 = 0; // 0 <= 10pence <= 20
		int p20 = 0; // 0 <= 20pence <= 10
		int p50 = 0; // 0 <= 50pence <= 4
		int p100 = 0; // 0 <= 100pence <= 2
		int p200 = 0; // 0 <= 200pence <= 1

		while (p1 < 201) {
			while (p2 < 101) {
				while (p5 < 41) {
					while (p10 < 21) {
						while (p20 < 11) {
							while (p50 < 5) {
								while (p100 < 3) {
									while (p200 < 2) {
										inputIndex=inputIndex.add(BigInteger.ONE);
										if (p1 + p2 * 2 + p5 * 5 + p10 * 10 + p20 * 20 + p50 * 50 + p100 * 100 + p200 * 200 == 200) {
											sum200Index=sum200Index.add(BigInteger.ONE);

											key.append(String.valueOf(inputIndex));
											key.append(",");
											key.append(String.valueOf(sum200Index));

											value.append(String.valueOf(p1));
											value.append(",");
											value.append(String.valueOf(p2));
											value.append(",");
											value.append(String.valueOf(p5));
											value.append(",");
											value.append(String.valueOf(p10));
											value.append(",");
											value.append(String.valueOf(p20));
											value.append(",");
											value.append(String.valueOf(p50));
											value.append(",");
											value.append(String.valueOf(p100));
											value.append(",");
											value.append(String.valueOf(p200));

											coinCombination.put(key.toString(), value.toString());

											key.setLength(0);
											value.setLength(0);

											// System.out.printf("<%d,%d> %d,%d,%d,%d,%d,%d,%d,%d\n",inputIndex,coinCombination.size(), p1, p2, p5, p10, p20, p50, p100, p200);
										} else {
											// System.out.printf("<%d,x> %d,%d,%d,%d,%d,%d,%d,%d\n",inputIndex, p1, p2, p5, p10, p20, p50, p100, p200);
										}
										p200++;
										if (p200 == 2) {
											p200 = 0;
											break;
										}
									}
									p100++;
									if (p100 == 3) {
										p100 = 0;
										break;
									}
								}
								p50++;
								if (p50 == 5) {
									p50 = 0;
									break;
								}
							}
							p20++;
							if (p20 == 11) {
								p20 = 0;
								break;
							}
						}
						p10++;
						if (p10 == 21) {
							p10 = 0;
							break;
						}
					}
					p5++;
					if (p5 == 41) {
						p5 = 0;
						break;
					}
				}
				p2++;
				if (p2 == 101) {
					p2 = 0;
					break;
				}
			}
			p1++;
		}
		
		String fileName = "D:\\coinCombination.txt";
		boolean append = false;

		Iterator <String> it = coinCombination.keySet().iterator();
		
		try {
		FileWriter fw = new FileWriter(fileName, append);
		BufferedWriter bw = new BufferedWriter(fw);
			StringBuilder lineOutput = new StringBuilder();
			String key1 = null;
			
			while(it.hasNext()){
				lineOutput.setLength(0);
				key1 = it.next();
				lineOutput.append(key1);
				lineOutput.append(" ");
				lineOutput.append(coinCombination.get(key1));
				
				bw.write(lineOutput.toString());
				bw.newLine();
			}
			
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
	}
}