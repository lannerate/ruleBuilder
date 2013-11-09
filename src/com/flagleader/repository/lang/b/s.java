package com.flagleader.repository.lang.b;

import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import java.io.PrintWriter;

public class s extends j
{
  public s()
  {
  }

  public s(PrintWriter paramPrintWriter)
  {
    super(paramPrintWriter);
  }

  public void c(IElement paramIElement)
  {
    if ((paramIElement instanceof IRuleTree))
      this.e = ((RulePackage)((IRuleTree)paramIElement).getCompilePackage());
    else if ((paramIElement instanceof RulePackage))
      this.e = ((RulePackage)paramIElement);
    else
      return;
    b();
    b(this.e);
    this.l = new j().a(this.e.getLogCondition());
    this.m = this.e.getEnvionment().getAllTraceVariable();
    if (paramIElement != null)
      super.a(this.e, (ITreeNode)paramIElement);
    j();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.lang.b.s
 * JD-Core Version:    0.6.0
 */