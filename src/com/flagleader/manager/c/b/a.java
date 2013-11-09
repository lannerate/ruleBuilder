package com.flagleader.manager.c.b;

import com.flagleader.export.PagesMessages;
import com.flagleader.manager.r;
import com.flagleader.repository.export.AjaxPage;

public class a extends com.flagleader.manager.c.h
{
  public a(com.flagleader.manager.c.c paramc, AjaxPage paramAjaxPage, r paramr)
  {
    super(paramc, paramAjaxPage, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("name.dialog"), new com.flagleader.manager.c.l(this));
    a(com.flagleader.manager.d.c.b("prefrename.JspExportProperties"), new n(this));
    a(com.flagleader.manager.d.c.b("exportfile.JspExportProperties"), new l(this));
    if (c().getModelStr().length() > 0)
      a(com.flagleader.manager.d.c.b("importfile.JspExportProperties"), c().getImportFile());
    else
      a(com.flagleader.manager.d.c.b("importfile.JspExportProperties"), new m(this));
    a(com.flagleader.manager.d.c.b("jspTitle.JspExportProperties"), new o(this));
    String[] arrayOfString = (String[])null;
    if (c().getImportFile().length() > 0)
      arrayOfString = c().getPreferences().getStringArray(c().getImportFile() + ".props");
    if (arrayOfString == null)
      arrayOfString = c().getPreferences().getStringArray("export.props");
    for (int i = 0; (arrayOfString != null) && (i < arrayOfString.length); i++)
    {
      int j = 1;
      String str1 = c().getPreferences().getString(arrayOfString[i] + ".relate", "");
      if ((str1 != null) && (str1.length() > 0))
      {
        j = 0;
        localObject = c().getPreferences().getStringArray(arrayOfString[i] + ".relatevalue");
        for (int k = 0; (localObject != null) && (k < localObject.length); k++)
        {
          if (!c().getPropertyValue(str1).equalsIgnoreCase(localObject[k]))
            continue;
          j = 1;
          break;
        }
      }
      if (j == 0)
        continue;
      Object localObject = c().getPreferences().getString(arrayOfString[i] + ".type", "input");
      String str2 = arrayOfString[i];
      if (((String)localObject).equals("list"))
      {
        a(c().getPreferences().getString(arrayOfString[i] + ".display"), new b(this, str2));
      }
      else if (((String)localObject).equals("input"))
      {
        a(c().getPreferences().getString(arrayOfString[i] + ".display"), new c(this, str2));
      }
      else if (((String)localObject).equals("bigtext"))
      {
        a(c().getPreferences().getString(arrayOfString[i] + ".display"), new d(this, str2));
      }
      else if (((String)localObject).equals("jstext"))
      {
        a(c().getPreferences().getString(arrayOfString[i] + ".display"), new f(this, str2));
      }
      else if (((String)localObject).equals("htmltext"))
      {
        a(c().getPreferences().getString(arrayOfString[i] + ".display"), new h(this, str2));
      }
      else
      {
        if (!((String)localObject).equals("jsptext"))
          continue;
        a(c().getPreferences().getString(arrayOfString[i] + ".display"), new j(this, str2));
      }
    }
  }

  private AjaxPage c()
  {
    if ((d() != null) && ((d() instanceof AjaxPage)))
      return (AjaxPage)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.b.a
 * JD-Core Version:    0.6.0
 */