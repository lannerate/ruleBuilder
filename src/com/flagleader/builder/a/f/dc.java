package com.flagleader.builder.a.f;

import com.flagleader.repository.e.o;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.apache.commons.lang.SystemUtils;

class dc extends Thread
{
  dc(da paramda, boolean paramBoolean)
  {
  }

  public void run()
  {
    da.d(this.a).clear();
    if ((da.e(this.a).getMainPackage() != null) && (da.e(this.a).getMainPackage().findRuleHistory(da.e(this.a).getUuid(), da.e(this.a).toString()) != null))
    {
      da.a(this.a, da.f(this.a));
    }
    else
    {
      this.a.e = false;
      String str1 = SystemUtils.JAVA_IO_TMPDIR;
      String str2 = "";
      if (da.e(this.a).getMainPackage() != null)
        str2 = da.e(this.a).getMainPackage().getUuid();
      else if (da.e(this.a).getEnvionment() != null)
        str2 = da.e(this.a).getEnvionment().getUuid();
      File localFile = new File(str1 + File.separator + str2, da.e(this.a).getEditUuid() + "V.html");
      localFile.getParentFile().mkdirs();
      try
      {
        if ((!localFile.exists()) || (this.b) || (da.e(this.a).getMaxModifyTime() > localFile.lastModified()))
        {
          String str3 = da.f(this.a);
          FileUtil.saveToFile(localFile.getPath(), str3, o.b(str3));
        }
        da.a(this.a, localFile);
      }
      catch (IOException localIOException)
      {
        da.a(this.a, da.f(this.a));
      }
    }
    this.a.b(da.g(this.a));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.dc
 * JD-Core Version:    0.6.0
 */