package com.flagleader.builder.e.g;

import com.flagleader.repository.tree.IRuleTree;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.eclipse.jface.wizard.Wizard;

public class j extends Wizard
{
  private a a;
  private c b;
  private f c;
  private IRuleTree d = null;
  private ArrayList e = new ArrayList();
  private ArrayList f = new ArrayList();

  public j(IRuleTree paramIRuleTree)
  {
    setNeedsProgressMonitor(true);
    this.d = paramIRuleTree;
  }

  public void addPages()
  {
    this.a = new a(this);
    this.b = new c(this);
    this.c = new f(this);
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

  public a b()
  {
    return this.a;
  }

  public c c()
  {
    return this.b;
  }

  public f d()
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
 * Qualified Name:     com.flagleader.builder.e.g.j
 * JD-Core Version:    0.6.0
 */