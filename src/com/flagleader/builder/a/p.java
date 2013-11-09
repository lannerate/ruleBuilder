package com.flagleader.builder.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.b.r;
import com.flagleader.repository.rlm.editen.ITextEditen;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;

class p extends r
{
  p(o paramo, String paramString, ITextEditen paramITextEditen)
  {
    super(paramString);
  }

  protected void a()
  {
    if (!o.a(this.a).g())
    {
      String str = b();
      str = StringUtil.replace(FileUtil.newline, "\\n", str);
      if (str.trim().length() > 0)
        str = str.trim();
      if ((str.endsWith("\\n")) && (str.length() > 2))
        str = str.substring(0, str.length() - 2);
      if (!this.e.getText().equals(str))
      {
        this.e.setText(str);
        this.e.update();
      }
    }
  }

  protected boolean a(String paramString)
  {
    if (!this.e.checkValue(paramString))
    {
      o.a(this.a).b.showError(ResourceTools.getMessage("errorType.edit"));
      return false;
    }
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.p
 * JD-Core Version:    0.6.0
 */