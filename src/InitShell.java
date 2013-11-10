/*** Eclipse Class Decompiler plugin, copyright (c) 2012 Chao Chen (cnfree2000@hotmail.com) ***/
import java.io.*;

public class InitShell {

	public static void main(String args[]) {
		String s = ";";
		if (args != null && args.length > 0)
			s = args[0];
		String s1 = "";
		if (args != null && args.length > 1)
			s1 = args[1];
		String s2 = "start.bat";
		if (args != null && args.length > 2)
			s2 = args[2];
		StringBuffer stringbuffer = new StringBuffer(
				"java -Xms40m -Xmx1024m -classpath ./classes");
		stringbuffer.append(s);
		File file = new File("lib");
		if (file.exists()) {
			File afile[] = file.listFiles();
			for (int i = 0; i < afile.length; i++)
				stringbuffer.append("./lib/").append(afile[i].getName())
						.append(s);

		}
		stringbuffer.append(" ").append(s1);
		try {
			File file1 = new File(s2);
			file1.createNewFile();
			FileOutputStream fileoutputstream = new FileOutputStream(file1,
					false);
			fileoutputstream.write(stringbuffer.toString().getBytes());
			fileoutputstream.close();
			System.out.print("OK!\n");
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
}
