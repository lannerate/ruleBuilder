package com.flagleader.manager.c.d;

import com.flagleader.manager.builder.b;
import com.flagleader.manager.c.c.f;
import com.flagleader.manager.c.j;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.RulePackage;
import java.io.File;

public class E
  implements f
{
  public E(y paramy)
  {
  }

  public String a()
  {
    return y.a(this.a).getExeRulePackageName();
  }

  public boolean a(String paramString)
  {
    if (!y.a(this.a).getExeRulePackageName().equals(paramString.toString()))
    {
      if ((y.a(this.a).getProject() != null) && (y.a(this.a).getProject().exitsPackage(paramString.toString()) != null))
      {
        y.b(this.a).b().showError(c.b("exitsPackage.RulePackagePropertiesEditor"));
        return false;
      }
      if (new File(y.a(this.a).getFilePathName()).exists())
        y.b(this.a).b().showQuestion(c.b("deleteFile.RulePackagePropertiesEditor"), new j(this.a, y.a(this.a)));
      y.a(this.a, paramString.toString());
      y.a(this.a).setExeRulePackageName(paramString.toString());
      if (y.a(this.a).getProject() != null)
        y.a(this.a).getProject().setNeedSave(true);
      y.a(this.a).setModified(true);
      y.a(this.a).getEnvionment().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.d.E
 * JD-Core Version:    0.6.0
 */