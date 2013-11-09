package com.flagleader.manager.a;

import com.flagleader.manager.builder.b;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.IRuleProject;
import java.io.File;

public class k
{
  r a = null;

  public k(r paramr)
  {
    this.a = paramr;
  }

  public void a(IRuleProject paramIRuleProject)
  {
    if (paramIRuleProject.isModified())
    {
      this.a.b().showQuestion(c.b("choosesaveproject"), new l(this, paramIRuleProject));
      paramIRuleProject.clearAutoSave();
      paramIRuleProject.close();
      paramIRuleProject.disposeAndUpdate();
    }
    else
    {
      paramIRuleProject.clearAutoSave();
      paramIRuleProject.close();
      paramIRuleProject.disposeAndUpdate();
    }
  }

  public void a(IRuleProject paramIRuleProject, String paramString)
  {
    if (paramString.length() > 0)
      paramIRuleProject.setFilePath(paramString + File.separator + paramIRuleProject.getDisplayName() + File.separator + "default.prj");
    paramIRuleProject.save();
    this.a.j().c(c.a("HasBeenExport", new String[] { paramIRuleProject.getFilePath() }));
  }

  public void b(IRuleProject paramIRuleProject, String paramString)
  {
    if (paramString.length() > 0)
      paramIRuleProject.setFilePath(paramString + File.separator + paramIRuleProject.getDisplayName() + File.separator + "default.prj");
    paramIRuleProject.save();
    this.a.j().c(c.a("HasBeenExport", new String[] { paramIRuleProject.getFilePath() }));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.a.k
 * JD-Core Version:    0.6.0
 */