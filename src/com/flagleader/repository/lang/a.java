package com.flagleader.repository.lang;

import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleClass;
import com.flagleader.repository.tree.IRulePackage;
import java.io.File;
import java.io.PrintWriter;
import java.util.List;

public abstract interface a
{
  public abstract void a(IRulePackage paramIRulePackage, PrintWriter paramPrintWriter);

  public abstract String a(IPackageElement paramIPackageElement);

  public abstract String a(IElement paramIElement);

  public abstract List b(IPackageElement paramIPackageElement);

  public abstract File a(IRuleClass paramIRuleClass, String paramString, boolean paramBoolean);

  public abstract String a(File paramFile, String paramString);

  public abstract File a(IRuleClass paramIRuleClass, boolean paramBoolean, String paramString);

  public abstract c a();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.a
 * JD-Core Version:    0.6.0
 */