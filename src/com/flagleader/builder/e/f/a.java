package com.flagleader.builder.e.f;

import com.flagleader.repository.tree.IRuleTree;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.eclipse.jface.wizard.Wizard;

public class a extends Wizard
{
  private b a;
  private e b;
  private h c;
  private IRuleTree d = null;
  private ArrayList e = new ArrayList();
  private ArrayList f = new ArrayList();

  public a(IRuleTree paramIRuleTree)
  {
    setNeedsProgressMonitor(true);
    this.d = paramIRuleTree;
  }

  public void addPages()
  {
    this.a = new b(this);
    this.b = new e(this);
    this.c = new h(this);
    addPage(this.a);
    addPage(this.b);
    addPage(this.c);
  }

  public boolean performFinish()
  {
    if (this.c.a().size() > 0)
      f();
    return true;
  }

  public IRuleTree a()
  {
    return this.d;
  }

  public b b()
  {
    return this.a;
  }

  public e c()
  {
    return this.b;
  }

  public h d()
  {
    return this.c;
  }

  private void f()
  {
  }

  public LinkedHashMap e()
  {
    return this.c.a();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.f.a
 * JD-Core Version:    0.6.0
 */