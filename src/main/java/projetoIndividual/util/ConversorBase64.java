package projetoIndividual.util;

import com.google.common.base.Charsets;
import com.google.common.io.BaseEncoding;

public class ConversorBase64 {

	public String paraBase64(String str) {
		byte[] byteArr = str.getBytes(Charsets.UTF_8);
		String codificada = BaseEncoding.base64().encode(byteArr);
		return codificada;
	}
	
	public String paraString(String str) {
		byte[] byteArr = BaseEncoding.base64().decode(str);
		String decodificada = new String(byteArr, Charsets.UTF_8);
		return decodificada;
	}
	
}
