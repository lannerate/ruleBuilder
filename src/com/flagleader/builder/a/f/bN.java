package com.flagleader.builder.a.f;

import com.flagleader.repository.flow.RulePoolFlow;
import com.flagleader.repository.lang.a;
import com.flagleader.repository.lang.c;
import com.flagleader.repository.m;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleSet;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleSet;
import com.flagleader.repository.tree.RuleSetFlow;
import com.flagleader.repository.tree.RuleTreeFlow;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.lang.SystemUtils;

class bN extends Thread
{
  bN(bK parambK, boolean paramBoolean)
  {
  }

  public void run()
  {
    String str1 = SystemUtils.JAVA_IO_TMPDIR;
    String str2 = "";
    if ((bK.c(this.a) instanceof IPackageElement))
    {
      if (bK.c(this.a).getMainPackage() != null)
        str2 = bK.c(this.a).getMainPackage().getUuid();
      else if (bK.c(this.a).getEnvionment() != null)
        str2 = bK.c(this.a).getEnvionment().getUuid();
    }
    else if ((bK.c(this.a) instanceof RulePackage))
      str2 = ((RulePackage)bK.c(this.a)).getUuid();
    File localFile1 = new File(str1 + File.separator + str2, bK.c(this.a).getEditUuid() + "D.java");
    File localFile2 = new File(str1 + File.separator + str2, bK.c(this.a).getEditUuid() + "D.line");
    int i = 0;
    String str3 = "";
    Object localObject2;
    if ((localFile1.exists()) && (!this.b) && (bK.c(this.a).getMaxModifyTime() < localFile1.lastModified()) && (bK.c(this.a).getEnvionment().getMaxModifyTime() < localFile1.lastModified()))
      try
      {
        str3 = FileUtil.readFromFile(localFile1);
        if (localFile2.exists())
        {
          String str4 = FileUtil.readFromFile(localFile2);
          localObject2 = str4.split(";");
          for (int j = 0; j < localObject2.length; j++)
          {
            if ((localObject2[j] == null) || (localObject2[j].length() <= 0))
              continue;
            int k = localObject2[j].indexOf(',');
            if (k <= 0)
              continue;
            bK.a(this.a).put(localObject2[j].substring(0, k), localObject2[j].substring(k + 1));
          }
        }
        i = 1;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    Object localObject1;
    if (i == 0)
    {
      localObject1 = m.a().f().a();
      ((c)localObject1).a(true);
      ((c)localObject1).b(false);
      if ((bK.c(this.a) instanceof RuleSet))
        str3 = ((c)localObject1).a((RuleSet)bK.c(this.a));
      else if ((bK.c(this.a) instanceof RuleSetFlow))
        str3 = ((c)localObject1).a((RuleSetFlow)bK.c(this.a));
      else if ((bK.c(this.a) instanceof RuleTreeFlow))
        str3 = ((c)localObject1).a((RuleTreeFlow)bK.c(this.a));
      else if ((bK.c(this.a) instanceof RulePoolFlow))
        str3 = ((c)localObject1).a((RulePoolFlow)bK.c(this.a));
      else if ((bK.c(this.a) instanceof RulePackage))
        str3 = ((c)localObject1).a((RulePackage)bK.c(this.a));
      bK.a(this.a, ((c)localObject1).a());
    }
    bK.a(this.a, str3);
    if (i == 0)
      try
      {
        localFile1.getParentFile().mkdirs();
        FileUtil.saveToFile(localFile1, new StringBuffer(str3));
        localObject1 = bK.a(this.a).keySet().iterator();
        localObject2 = new FileOutputStream(localFile2);
        while (((Iterator)localObject1).hasNext())
        {
          String str5 = (String)((Iterator)localObject1).next();
          ((FileOutputStream)localObject2).write((str5 + "," + bK.a(this.a).get(str5).toString() + ";").getBytes());
        }
        ((FileOutputStream)localObject2).flush();
        ((FileOutputStream)localObject2).close();
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    this.a.b(bK.d(this.a));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.bN
 * JD-Core Version:    0.6.0
 */