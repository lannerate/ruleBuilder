package com.flagleader.builder.a.d;

import com.flagleader.builder.BuilderConfig;
import com.flagleader.repository.export.IPage;
import com.flagleader.util.JspUtil;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;

class K extends Thread
{
  K(I paramI, boolean paramBoolean)
  {
  }

  public void run()
  {
    String str1 = BuilderConfig.getInstance().getTempPath();
    String str2 = this.a.e().getDisplayName();
    if (str2.endsWith(".jsp"))
      str2 = StringUtil.replace(".jsp", ".html", str2.replace('/', '_'));
    else
      str2 = this.a.e().getUuid() + ".html";
    File localFile = new File(str1, str2);
    try
    {
      if ((!localFile.exists()) || (this.b) || (this.a.e().getModifyTime() > localFile.lastModified()))
      {
        StringBuffer localStringBuffer = new StringBuffer(this.a.e().getDesignStr("d_"));
        while ((localStringBuffer.indexOf("<%") >= 0) && (localStringBuffer.indexOf("%>") > localStringBuffer.indexOf("<%")))
          localStringBuffer.replace(localStringBuffer.indexOf("<%"), localStringBuffer.indexOf("%>") + 2, "");
        JspUtil.saveHtmlFile(localFile.getPath(), localStringBuffer.toString());
      }
      if (I.b(this.a) != null)
        I.a(this.a, localFile);
      else
        I.a(this.a, FileUtil.readFromFile(localFile));
    }
    catch (Exception localException)
    {
      I.a(this.a, this.a.e().getDesignCompiler("d_"), localException);
    }
    this.a.b(I.c(this.a));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.K
 * JD-Core Version:    0.6.0
 */