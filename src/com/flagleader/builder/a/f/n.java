package com.flagleader.builder.a.f;

import com.flagleader.repository.tree.DecisionMultiRule;
import com.flagleader.repository.tree.ITreeNode;

public class n extends com.flagleader.builder.a.c.a
{
  public n(a parama)
  {
  }

  public boolean b()
  {
    return !a.b(this.a).isLocked();
  }

  public String c()
  {
    return "RuleOrder";
  }

  public int g()
  {
    return 2;
  }

  public String[] i()
  {
    String[] arrayOfString = new String[a.b(this.a).getMaxPos() - a.b(this.a).getMinPos()];
    for (int i = 0; i < a.b(this.a).getMaxPos() - a.b(this.a).getMinPos(); i++)
      arrayOfString[i] = new Integer(a.b(this.a).getMinPos() + i + 1).toString();
    return arrayOfString;
  }

  public String j()
  {
    return new Integer(a.b(this.a).getPos() + 1).toString();
  }

  public boolean a(int paramInt)
  {
    if (a.b(this.a).getPos() != paramInt)
    {
      a.b(this.a).setPos(paramInt);
      a.b(this.a).setModified(true);
      if ((a.b(this.a).getParent() instanceof ITreeNode))
      {
        ((ITreeNode)a.b(this.a).getParent()).setModified(true);
        ((ITreeNode)a.b(this.a).getParent()).updateTree();
      }
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.n
 * JD-Core Version:    0.6.0
 */