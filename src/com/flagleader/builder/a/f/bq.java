package com.flagleader.builder.a.f;

import com.flagleader.repository.lang.c;
import com.flagleader.repository.m;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.util.filesystem.FileUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.lang.SystemUtils;

class bq extends Thread
{
  bq(bn parambn, boolean paramBoolean)
  {
  }

  public void run()
  {
    String str1 = SystemUtils.JAVA_IO_TMPDIR;
    File localFile1 = new File(str1 + File.separator + bn.d(this.a).getUuid(), bn.d(this.a).getEditUuid() + "J.java");
    File localFile2 = new File(str1 + File.separator + bn.d(this.a).getUuid(), bn.d(this.a).getEditUuid() + "J.line");
    int i = 0;
    String str2 = "";
    Object localObject2;
    int k;
    if ((localFile1.exists()) && (!this.b) && (bn.d(this.a).getMaxModifyTime() < localFile1.lastModified()))
      try
      {
        str2 = FileUtil.readFromFile(localFile1);
        if (localFile2.exists())
        {
          String str3 = FileUtil.readFromFile(localFile2);
          localObject2 = str3.split(";");
          for (int j = 0; j < localObject2.length; j++)
          {
            if ((localObject2[j] == null) || (localObject2[j].length() <= 0))
              continue;
            k = localObject2[j].indexOf(',');
            if (k <= 0)
              continue;
            bn.b(this.a).put(localObject2[j].substring(0, k), localObject2[j].substring(k + 1));
          }
        }
        i = 1;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    Object localObject1;
    Object localObject3;
    if (i == 0)
    {
      localObject1 = m.a().i();
      ((c)localObject1).b(false);
      bn.a(this.a, ((c)localObject1).b(bn.d(this.a)));
      localObject2 = new StringBuffer();
      localObject3 = new BufferedReader(new StringReader(bn.e(this.a)));
      k = 1;
      try
      {
        for (String str4 = ((BufferedReader)localObject3).readLine(); str4 != null; str4 = ((BufferedReader)localObject3).readLine())
          ((StringBuffer)localObject2).append(k++ + " " + str4 + FileUtil.newline);
        ((BufferedReader)localObject3).close();
      }
      catch (Exception localException3)
      {
      }
      bn.a(this.a, ((c)localObject1).a());
      str2 = ((StringBuffer)localObject2).toString();
    }
    bn.b(this.a, str2);
    if (i == 0)
      try
      {
        localFile1.getParentFile().mkdirs();
        FileUtil.saveToFile(localFile1, new StringBuffer(str2));
        localObject1 = bn.b(this.a).keySet().iterator();
        localObject2 = new FileOutputStream(localFile2);
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (String)((Iterator)localObject1).next();
          ((FileOutputStream)localObject2).write((localObject3 + "," + bn.b(this.a).get(localObject3).toString() + ";").getBytes());
        }
        ((FileOutputStream)localObject2).flush();
        ((FileOutputStream)localObject2).close();
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    this.a.b(bn.f(this.a));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.bq
 * JD-Core Version:    0.6.0
 */