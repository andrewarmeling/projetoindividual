package projetoindividual.util;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

public class ConversorMD5 {

	public String paraMD5(String str) {
		String hash = Hashing.md5().hashString(str, Charsets.UTF_8).toString();
		return hash;
	}

}
