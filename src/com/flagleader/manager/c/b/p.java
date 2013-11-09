package com.flagleader.manager.c.b;

import com.flagleader.export.PagesMessages;
import com.flagleader.manager.c.h;
import com.flagleader.manager.c.l;
import com.flagleader.repository.tree.ExportModel;

public class p extends h
{
  private String[] a = null;
  private String[] e = null;

  public p(com.flagleader.manager.c.c paramc, ExportModel paramExportModel, com.flagleader.manager.r paramr)
  {
    super(paramc, paramExportModel, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("name.dialog"), new l(this));
    a(com.flagleader.manager.d.c.b("exportfile.JspExportProperties"), new A(this));
    if ((c().getModelStr().length() > 0) || (f() == null))
      a(com.flagleader.manager.d.c.b("importfile.JspExportProperties"), c().getImportFile());
    else
      a(com.flagleader.manager.d.c.b("importfile.JspExportProperties"), new B(this));
    a(com.flagleader.manager.d.c.b("jspTitle.JspExportProperties"), new C(this));
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
        a(c().getPreferences().getString(arrayOfString[i] + ".display"), new q(this, str2));
      }
      else if (((String)localObject).equals("input"))
      {
        a(c().getPreferences().getString(arrayOfString[i] + ".display"), new r(this, str2));
      }
      else if (((String)localObject).equals("bigtext"))
      {
        a(c().getPreferences().getString(arrayOfString[i] + ".display"), new s(this, str2));
      }
      else if (((String)localObject).equals("jstext"))
      {
        a(c().getPreferences().getString(arrayOfString[i] + ".display"), new u(this, str2));
      }
      else if (((String)localObject).equals("htmltext"))
      {
        a(c().getPreferences().getString(arrayOfString[i] + ".display"), new w(this, str2));
      }
      else
      {
        if (!((String)localObject).equals("jsptext"))
          continue;
        a(c().getPreferences().getString(arrayOfString[i] + ".display"), new y(this, str2));
      }
    }
  }

  private ExportModel c()
  {
    if ((d() != null) && ((d() instanceof ExportModel)))
      return (ExportModel)d();
    return null;
  }

  private String[] f()
  {
    if (this.a == null)
      this.a = c().getPreferences().getAdditionalStringArray("rspTemplates.choise");
    return this.a;
  }

  private String[] g()
  {
    if (this.e == null)
    {
      this.e = new String[this.a.length];
      for (int i = 0; i < this.a.length; i++)
        this.e[i] = c().getPreferences().getString(this.a[i] + ".name", this.a[i]);
      if ((this.e == null) || (this.e.length != this.a.length))
        this.e = this.a;
    }
    return this.e;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.b.p
 * JD-Core Version:    0.6.0
 */