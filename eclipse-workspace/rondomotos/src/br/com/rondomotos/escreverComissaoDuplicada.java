package br.com.rondomotos;

import java.util.ArrayList;

public class escreverComissaoDuplicada {

	public static ArrayList<String> finalizado = null;
	public static ArrayList<String> cidade = null;
	public static ArrayList<String> finalizadoOk = null;
	public static ArrayList<String> finalizadoTotal = null;

	public static void escrever() {

		finalizado = new ArrayList<String>();
		finalizadoOk = new ArrayList<String>();
		cidade = new ArrayList<String>();
		finalizadoTotal = new ArrayList<String>();

		Object[] st = ComissaoFinal.comissaoDuplicada.toArray();
		for (Object s : st) {
			if (ComissaoFinal.comissaoDuplicada.indexOf(s) != ComissaoFinal.comissaoDuplicada.lastIndexOf(s)) {
				ComissaoFinal.comissaoDuplicada.remove(ComissaoFinal.comissaoDuplicada.lastIndexOf(s));
			}
		}

		for (String linha : ComissaoFinal.comissaoDuplicada) {
			String[] lh = linha.split(";");
			cidade.add(lh[9]);
		}

		Object[] stCidade = cidade.toArray();
		for (Object s : stCidade) {
			if (cidade.indexOf(s) != cidade.lastIndexOf(s)) {
				cidade.remove(cidade.lastIndexOf(s));
			}
		}

		for (String linha : cidade) {
			for (String lh : ComissaoFinal.comissaoDuplicada) {
				String[] lhSplit = lh.split(";");
				if (linha.contentEquals(lhSplit[9])) {
					finalizado.add(lh);

				}

			}

		}

		for (String linha : Comissao.arrayListaVendedorTratados) {
			String[] linhaSplit = linha.split(";");
			Double db = 0.0;
			Double db1 = 0.0;

			for (String lh : finalizado) {
				String[] lhSplit = lh.split(";");

				if (linhaSplit[0].contentEquals(lhSplit[4])) {
					db = Double.parseDouble(lhSplit[8].replaceAll(",", "."));

					db1 = db1 + db;
					finalizadoOk.add(lh + ";" + db1);

				}

			}
			finalizadoTotal.add(linha + ";" + db1);
			
		}

		finalizado = new ArrayList<String>();
		for (String linha : cidade) {
			for (String lh : finalizadoOk) {
				String[] lhSplit = lh.split(";");
				if (linha.contentEquals(lhSplit[9])) {
					finalizado.add(lh);

				}

			}

		}

		finalizadoOk = new ArrayList<String>();
		
		String cidade = null;
		for (String lh : finalizadoTotal) {
			String[] lhSplit = lh.split(";");
			for (String linha : finalizado) {
				String[] linhaSplit = linha.split(";");
				
				if(lhSplit[0].contentEquals(linhaSplit[4])) {
				finalizadoOk.add(linhaSplit[0] + ";" + linhaSplit[1] + ";" + linhaSplit[2] + ";" + linhaSplit[3] + ";" + linhaSplit[4] + ";" + linhaSplit[5]
						+ ";" + linhaSplit[6] + ";" + linhaSplit[7] + ";" + linhaSplit[8] + ";" + linhaSplit[9]+ ";" + linhaSplit[10]);
				cidade = linhaSplit[9];
				}
			}
			finalizadoOk.add("0000;0000;0000;0000;0000;0000;0000;0000;" +lhSplit[2] + ";" + cidade + ";0000");
		}
		
		

	}

}
