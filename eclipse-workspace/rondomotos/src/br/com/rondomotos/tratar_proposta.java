package br.com.rondomotos;

import java.io.BufferedReader;
import java.io.FileReader;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class tratar_proposta {

	private static String minhaLinha = "";
	public static ArrayList<String> temp_proposta;

	public static void eliminaEspaco(String caminho, String ope) {

		try {

			if (ope != null) {

				config_localidade.configLocalidade();

				BufferedReader br = new BufferedReader(new FileReader(caminho));
				temp_proposta = new ArrayList<String>();
				
				while ((minhaLinha = br.readLine()) != null) {
					minhaLinha = minhaLinha.replaceAll("\"", ""); // Utilizado C�digo Regex para remover aspa dupla.
					minhaLinha = minhaLinha.replaceAll("\";", ""); // Utilizado C�digo Regex para remover espa�os.
					String[] linhasLer = minhaLinha.split(";");

					switch (linhasLer[0]) {
					case "RONDO MOTOS LTDA":
						// Nada Faz
						break;

					case "Vendedor":
						// Nada Faz
						break;

					default:

						switch (linhasLer[3]) {
						case "CART�O":
							linhasLer[7] = linhasLer[7].replaceAll(",", ".");

							if (linhasLer[6].equals("False")) {

								temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
										+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
										+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 1,
												Double.parseDouble(linhasLer[7])));

							}
							break;

						}

						switch (linhasLer[3]) {
						case "BOLETO BANC�RIO":
							linhasLer[7] = linhasLer[7].replaceAll(",", ".");

							if (linhasLer[6].equals("False")) {

								temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
										+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
										+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 1,
												Double.parseDouble(linhasLer[7])));

							}
							break;
						}

						switch (linhasLer[3]) {
						case "DINHEIRO":
							linhasLer[7] = linhasLer[7].replaceAll(",", ".");

							if (linhasLer[6].equals("False")) {

								temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
										+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
										+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 0,
												Double.parseDouble(linhasLer[7])));

							}
							break;

						}

						switch (linhasLer[3]) {
						case "A RECEBER CHEQUE A VISTA":
							linhasLer[7] = linhasLer[7].replaceAll(",", ".");

							if (linhasLer[6].equals("False")) {

								temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
										+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
										+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 0,
												Double.parseDouble(linhasLer[7])));

							}
							break;

						}

						switch (linhasLer[3]) {
						case "FINANCIAMENTO":
							linhasLer[7] = linhasLer[7].replaceAll(",", ".");

							if (linhasLer[6].equals("False")) {

								temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
										+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
										+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 0,
												Double.parseDouble(linhasLer[7])));

							}
							break;

						}
						switch (linhasLer[3]) {
						case "DEP�SITO BANC�RIO":
							linhasLer[7] = linhasLer[7].replaceAll(",", ".");

							if (linhasLer[6].equals("False")) {

								temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
										+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
										+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 0,
												Double.parseDouble(linhasLer[7])));

							}
							break;

						}

						switch (linhasLer[3]) {
						case "CONS�RCIO":
							linhasLer[7] = linhasLer[7].replaceAll(",", ".");
							if (!obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 0,
									Double.parseDouble(linhasLer[7])).contentEquals("nada")) {
								if (linhasLer[6].equals("False")) {

									String teste = linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
											+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
											+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]),
													1, Double.parseDouble(linhasLer[7]));
									String[] linhasLerCompleta = teste.split(";");
									if (linhasLerCompleta[9].equals("RONDO MOTOS LTDA")) {

									} else {
										temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
												+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
												+ obterValorTabela.valorTabela(linhasLer[1],
														Integer.parseInt(linhasLer[4]), 0,
														Double.parseDouble(linhasLer[7])));
									}
								}
								break;

							}
						}
						switch (linhasLer[3]) {
						case "TROCA DE VE�CULO":
							linhasLer[7] = linhasLer[7].replaceAll(",", ".");

							if (linhasLer[6].equals("False")) {

								temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
										+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
										+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 0,
												Double.parseDouble(linhasLer[7])));

							}
							break;

						}

						switch (linhasLer[3]) {
						case "FINANCIAMENTO PR�PRIO":
							linhasLer[7] = linhasLer[7].replaceAll(",", ".");

							if (linhasLer[6].equals("False")) {

								temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
										+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
										+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 1,
												Double.parseDouble(linhasLer[7])));

							}
							break;

						}

						switch (linhasLer[3]) {
						case "CART�O D�BITO":
							linhasLer[7] = linhasLer[7].replaceAll(",", ".");

							if (linhasLer[6].equals("False")) {

								temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
										+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
										+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 0,
												Double.parseDouble(linhasLer[7])));

							}
							break;

						}

						switch (linhasLer[3]) {
						case "PERMUTA":
							linhasLer[7] = linhasLer[7].replaceAll(",", ".");

							if (linhasLer[6].equals("False")) {

								temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
										+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
										+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 0,
												Double.parseDouble(linhasLer[7])));

							}
							break;

						}

						switch (linhasLer[3]) {
						case "DUPLICATA MERCATIL":
							linhasLer[7] = linhasLer[7].replaceAll(",", ".");

							if (linhasLer[6].equals("False")) {

								temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
										+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
										+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 1,
												Double.parseDouble(linhasLer[7])));

							}
							break;

						}

						switch (linhasLer[3]) {
						case "A RECEBER CHEQUE":
							linhasLer[7] = linhasLer[7].replaceAll(",", ".");

							if (linhasLer[6].equals("False")) {

								temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
										+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
										+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 1,
												Double.parseDouble(linhasLer[7])));

							}
							break;

						}

						switch (linhasLer[3]) {
						case "A RECEBER CHEQUE - ALIENA��O":
							linhasLer[7] = linhasLer[7].replaceAll(",", ".");

							if (linhasLer[6].equals("False")) {

								temp_proposta.add(linhasLer[2] + ";" + linhasLer[0] + ";" + linhasLer[3] + ";"
										+ linhasLer[1] + ";" + linhasLer[5] + ";" + linhasLer[4] + ";"
										+ obterValorTabela.valorTabela(linhasLer[1], Integer.parseInt(linhasLer[4]), 1,
												Double.parseDouble(linhasLer[7])));

							}
							break;

						}
					}
				}
				br.close();
			}
		} catch (

		Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.toString());
		}

	}

}
