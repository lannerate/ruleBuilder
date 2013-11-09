package com.flagleader.builder.a.f;

import com.flagleader.repository.e.o;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleSet;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.io.IOException;
import org.apache.commons.lang.SystemUtils;

class bf extends Thread
{
  bf(be parambe, boolean paramBoolean)
  {
  }

  public void run()
  {
    String str1 = SystemUtils.JAVA_IO_TMPDIR;
    String str2 = "";
    if ((be.a(this.a) instanceof IPackageElement))
    {
      if (be.a(this.a).getMainPackage() != null)
        str2 = be.a(this.a).getMainPackage().getUuid();
      else if (be.a(this.a).getEnvionment() != null)
        str2 = be.a(this.a).getEnvionment().getUuid();
    }
    else if ((be.a(this.a) instanceof RulePackage))
      str2 = ((RulePackage)be.a(this.a)).getUuid();
    File localFile = new File(str1 + File.separator + str2, be.a(this.a).getEditUuid() + ".html");
    localFile.getParentFile().mkdirs();
    try
    {
      if ((!localFile.exists()) || (this.b) || (be.a(this.a).getMaxModifyTime() > localFile.lastModified()) || (be.a(this.a).getEnvionment().getMaxModifyTime() > localFile.lastModified()))
      {
        String str3 = be.b(this.a);
        FileUtil.saveToFile(localFile.getPath(), str3, o.b(str3));
      }
      be.a(this.a, localFile);
    }
    catch (IOException localIOException)
    {
      be.a(this.a, be.b(this.a));
    }
    this.a.b(be.c(this.a));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.bf
 * JD-Core Version:    0.6.0
 */